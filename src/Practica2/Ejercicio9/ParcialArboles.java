package Practica2.Ejercicio9;

import java.util.ArrayList;

import Practica2.Ejercicio1y2.BinaryTree;

public class ParcialArboles {

  public BinaryTree<ArrayList<Integer>> sumAndDif(BinaryTree<Integer> arbol) {
    if (arbol != null && !arbol.isEmpty()) {
      ArrayList<Integer> listaRaiz = new ArrayList<Integer>();
      listaRaiz.add(arbol.getData());
      listaRaiz.add(arbol.getData());
      BinaryTree<ArrayList<Integer>> arbol2 = new BinaryTree<ArrayList<Integer>>(listaRaiz);
      if (arbol.hasLeftChild())
        sumAndDifRec(arbol.getLeftChild(), arbol2, arbol.getData(), true);
      if (arbol.hasRightChild())
        sumAndDifRec(arbol.getRightChild(), arbol2, arbol.getData(), false);
      return arbol2;
    }
    return null;
  }

  private void sumAndDifRec(BinaryTree<Integer> ab1, BinaryTree<ArrayList<Integer>> ab2,
      int ancestro, boolean esHijoIzquierdo) {
    if (ab1 == null || ab1.isEmpty())
      return;

    ArrayList<Integer> lista = new ArrayList<Integer>();
    lista.add(ab1.getData() + ancestro);
    lista.add(ab1.getData() - ancestro);

    BinaryTree<ArrayList<Integer>> nodoActual = new BinaryTree<ArrayList<Integer>>(lista);

    if (esHijoIzquierdo) {
      ab2.addLeftChild(nodoActual);
    } else {
      ab2.addRightChild(nodoActual);
    }
    if (ab1.hasLeftChild())
      sumAndDifRec(ab1.getLeftChild(), nodoActual, ab1.getData(), true);
    if (ab1.hasRightChild())
      sumAndDifRec(ab1.getRightChild(), nodoActual, ab1.getData(), false);
  }

  public void imprimirArbolListas(BinaryTree<ArrayList<Integer>> ab) {
    if (ab != null && !ab.isEmpty()) {

      ab.getData().forEach(nodo -> System.out.print(nodo + " | "));
      System.out.println();

      if (ab.hasLeftChild())
        imprimirArbolListas(ab.getLeftChild());
      if (ab.hasRightChild())
        imprimirArbolListas(ab.getRightChild());
    }
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

    arbol.addLeftChild(hI);
    arbol.addRightChild(hD);

    ParcialArboles parcial = new ParcialArboles();
    BinaryTree<ArrayList<Integer>> arbol2 = parcial.sumAndDif(arbol);
    parcial.imprimirArbolListas(arbol2);
  }

}
