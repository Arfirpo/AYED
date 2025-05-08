package Practica2.Ejercicio6;

import Practica2.Ejercicio1y2.BinaryTree;

public class Transformacion {
  private BinaryTree<Integer> arbol;

  public Transformacion() {
    this.arbol = new BinaryTree<Integer>();
  }

  public Transformacion(BinaryTree<Integer> ab) {
    this.arbol = ab;
  }

  public BinaryTree<Integer> suma() {
    if ((!arbol.isEmpty()) && (arbol != null))
      sumaRec(arbol);
    return arbol;
  }

  private int sumaRec(BinaryTree<Integer> nodo) {
    int actual = 0;
    if (nodo.getData() != null) {
      actual = nodo.getData();
    }
    if (nodo.isLeaf()) {
      nodo.setData(0);
      return actual;
    }
    int suma = 0;
    if (nodo.hasLeftChild())
      suma += sumaRec(nodo.getLeftChild());
    if (nodo.hasRightChild())
      suma += sumaRec(nodo.getRightChild());
    nodo.setData(suma);
    return actual + suma;
  }

  public BinaryTree<Integer> getArbol() {
    return this.arbol;
  }

  public static void main(String[] args) {
    BinaryTree<Integer> arbol = new BinaryTree<Integer>(1);
    BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(2);
    hijoIzquierdo.addRightChild(new BinaryTree<Integer>(4));
    BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(3);
    hijoDerecho.addLeftChild(new BinaryTree<Integer>(5));
    hijoDerecho.getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
    hijoDerecho.getLeftChild().addRightChild(new BinaryTree<Integer>(8));
    hijoDerecho.addRightChild(new BinaryTree<Integer>(6));
    arbol.addLeftChild(hijoIzquierdo);
    arbol.addRightChild(hijoDerecho);

    Transformacion tr = new Transformacion(arbol);
    System.out.println("arbol normal");
    System.out.println();
    tr.getArbol().imprimirEntreNiveles(0, 3);
    System.out.println();
    System.out.println("arbol transformado");
    System.out.println();
    tr.suma().imprimirEntreNiveles(0, 3);
  }
}
