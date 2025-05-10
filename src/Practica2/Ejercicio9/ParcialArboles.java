package Practica2.Ejercicio9;

import java.util.ArrayList;

import Practica2.Ejercicio1y2.BinaryTree;

public class ParcialArboles {

  public BinaryTree<ArrayList<Integer>> sumAndDif(BinaryTree<Integer> arbol) {
    if (arbol != null && !arbol.isEmpty()) {
      BinaryTree<ArrayList<Integer>> arbol2 = new BinaryTree<ArrayList<Integer>>();
      return sumAndDifRec(arbol, arbol2, 0);
    }
    return null;
  }

  private BinaryTree<ArrayList<Integer>> sumAndDifRec(BinaryTree<Integer> ab1, BinaryTree<ArrayList<Integer>> ab2,
      int ancestro) {
    if (ab1 != null && ab1.isEmpty()) {
      ab2.getData().add(ab1.getData() + ancestro);
      ab2.getData().add(ab1.getData() - ancestro);
      ancestro = ab1.getData();

      if (ab1.hasLeftChild())
        ab2.addLeftChild(new BinaryTree<ArrayList<Integer>>());
      sumAndDifRec(ab1.getLeftChild(), ab2.getLeftChild(), ancestro);
      if (ab1.hasRightChild())
        ab2.addRightChild(new BinaryTree<ArrayList<Integer>>());
      sumAndDifRec(ab1.getRightChild(), ab2.getRightChild(), ancestro);
    }
    return ab2;
  }

  public static void main(String[] args) {
    BinaryTree<Integer> arbol = new BinaryTree<Integer>(20);

    BinaryTree<Integer> hI = new BinaryTree<Integer>(5);
    BinaryTree<Integer> hD = new BinaryTree<Integer>(30);

    hI.addLeftChild(new BinaryTree<Integer>(-5));
    hI.addRightChild(new BinaryTree<Integer>(10));
    hD.addLeftChild(new BinaryTree<Integer>(50));
    hD.addRightChild(new BinaryTree<Integer>(-9));

    hI.getRightChild().addLeftChild(new BinaryTree<Integer>(1));
    hD.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
    hD.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));

    ParcialArboles parcial = new ParcialArboles();
    BinaryTree<ArrayList<Integer>> arbol2 = parcial.sumAndDif(arbol);
  }

}
