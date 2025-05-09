package Practica2.ejercicio7;

import Practica2.Ejercicio1y2.BinaryTree;

public class ParcialArboles {
  private BinaryTree<Integer> arbol;

  public ParcialArboles() {
    this.arbol = new BinaryTree<Integer>();
  }

  public ParcialArboles(BinaryTree<Integer> arbol) {
    this.arbol = arbol;
  }

  public void setArbol(BinaryTree<Integer> ab) {
    this.arbol = ab;
  }

  public BinaryTree<Integer> getArbol() {
    return this.arbol;
  }

  public boolean isLeftTree(int num) {

    return ((this.arbol != null) && !this.arbol.isEmpty()) ? isLeftTreeRec(this.arbol, num) : false;
  }

  private boolean isLeftTreeRec(BinaryTree<Integer> nodo, int num) {

    if ((nodo == null) || (nodo.isEmpty()))
      return false;

    if (nodo.getData() == num) {
      int cantIzq = 0;
      int cantDer = 0;

      if (nodo.hasLeftChild()) {
        cantIzq = contadorHijoUnico(nodo.getLeftChild(), 0);
      } else {
        cantIzq = -1;
      }
      if (nodo.hasRightChild()) {
        cantDer = contadorHijoUnico(nodo.getRightChild(), 0);
      } else {
        cantDer = -1;
      }
      return cantIzq > cantDer;
    }

    else {
      boolean isFound = false;
      if (nodo.hasLeftChild())
        isFound = isLeftTreeRec(nodo.getLeftChild(), num);
      if ((!isFound) && (nodo.hasRightChild()))
        isLeftTreeRec(nodo.getRightChild(), num);
      return isFound;
    }
  }

  private int contadorHijoUnico(BinaryTree<Integer> nodo, int cant) {
    if (nodo == null || nodo.isEmpty()) {
      return cant;
    }

    if ((nodo.hasLeftChild() && !nodo.hasRightChild()) || (!nodo.hasLeftChild() && !nodo.hasRightChild())) {
      cant++;
    }
    int totCant = cant;
    if (nodo.hasLeftChild())
      totCant = contadorHijoUnico(nodo.getLeftChild(), totCant);
    if (nodo.hasRightChild())
      totCant = contadorHijoUnico(nodo.getRightChild(), totCant);
    return totCant;
  }

  public static void main(String[] args) {

    BinaryTree<Integer> arbol = new BinaryTree<Integer>(2);

    BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(7);

    hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(23));
    hijoIzquierdo.addRightChild(new BinaryTree<Integer>(6));

    hijoIzquierdo.getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));

    hijoIzquierdo.getRightChild().addLeftChild(new BinaryTree<Integer>(55));
    hijoIzquierdo.getRightChild().addRightChild(new BinaryTree<Integer>(11));

    BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(-5);
    hijoDerecho.addLeftChild(new BinaryTree<Integer>(19));
    hijoDerecho.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
    hijoDerecho.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(18));

    arbol.addLeftChild(hijoIzquierdo);
    arbol.addRightChild(hijoDerecho);

    ParcialArboles pA = new ParcialArboles(arbol);

    System.out.println();
    System.out.println(pA.isLeftTree(7));
    System.out.println(pA.isLeftTree(2));
    System.out.println(pA.isLeftTree(-5));
    System.out.println(pA.isLeftTree(19));
    System.out.println(pA.isLeftTree(-3));
  }
}
