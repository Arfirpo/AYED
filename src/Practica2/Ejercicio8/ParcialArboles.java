package Practica2.Ejercicio8;

import Practica2.Ejercicio1y2.BinaryTree;

public class ParcialArboles {

  public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
    return ((arbol1 != null && !arbol1.isEmpty()) && (arbol2 != null && !arbol2.isEmpty()))
        ? esPrefijoRec(arbol1, arbol2)
        : false;
  }

  private boolean esPrefijoRec(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
    boolean prefijo = false;
    if (arbol2 == null)
      return prefijo;
    if (!arbol1.getData().equals(arbol2.getData())) {
      prefijo = false;
    }
    if (prefijo) {
      if (arbol1.hasLeftChild())
        prefijo = esPrefijoRec(arbol1.getLeftChild(), arbol2.getLeftChild());
      if (arbol1.hasRightChild() && prefijo)
        prefijo = esPrefijoRec(arbol1.getRightChild(), arbol2.getRightChild());
    }
    return prefijo;
  }

  public static void main(String[] args) {
    BinaryTree<Integer> ab1 = new BinaryTree<Integer>(65);

    BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(37);
    BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(81);

    hijoIzquierdo.addRightChild(new BinaryTree<Integer>(47));
    hijoDerecho.addRightChild(new BinaryTree<Integer>(93));

    ab1.addLeftChild(hijoIzquierdo);
    ab1.addRightChild(hijoDerecho);

    BinaryTree<Integer> ab2 = new BinaryTree<Integer>(65);
    BinaryTree<Integer> hijoIzquierdo2 = new BinaryTree<Integer>(37);
    BinaryTree<Integer> hijoDerecho2 = new BinaryTree<Integer>(81);

    hijoIzquierdo2.addLeftChild(new BinaryTree<Integer>(22));
    hijoIzquierdo2.addRightChild(new BinaryTree<Integer>(47));

    hijoIzquierdo2.getLeftChild().addLeftChild(new BinaryTree<Integer>(11));
    hijoIzquierdo2.getLeftChild().addRightChild(new BinaryTree<Integer>(29));
    ;

    hijoDerecho2.addLeftChild(new BinaryTree<Integer>(76));
    hijoDerecho2.addRightChild(new BinaryTree<Integer>(93));

    hijoDerecho2.getRightChild().addLeftChild(new BinaryTree<Integer>(65));
    hijoDerecho2.getRightChild().addRightChild(new BinaryTree<Integer>(94));

    ab2.addLeftChild(hijoIzquierdo2);
    ab2.addRightChild(hijoDerecho2);

    ParcialArboles pA = new ParcialArboles();

    System.out.println(pA.esPrefijo(ab1, ab2));

  }

}
