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
