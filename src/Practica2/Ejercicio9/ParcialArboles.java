package Practica2.Ejercicio9;

import java.util.ArrayList;

import Practica2.Ejercicio1y2.BinaryTree;

public class ParcialArboles {

  public BinaryTree<ArrayList<Integer>> sumAndDif(BinaryTree<Integer> arbol) {
    if (arbol != null && !arbol.isEmpty()) {
      BinaryTree<ArrayList<Integer>> arbol2 = new BinaryTree<ArrayList<Integer>>();
      arbol2.getData().add(arbol.getData() + 0);
      arbol2.getData().add(arbol.getData() - 0);
      return sumAndDifRec(arbol, arbol2);
    }
    return null;
  }

  private BinaryTree<ArrayList<Integer>> sumAndDifRec(BinaryTree<Integer> ab1, BinaryTree<ArrayList<Integer>> ab2) {

    return ab2;
  }

}
