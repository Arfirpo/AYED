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
        sumAndDifRec(arbol.getLeftChild(), arbol2, arbol.getData(), arbol.getData(), true);
      if (arbol.hasRightChild())
        sumAndDifRec(arbol.getRightChild(), arbol2, arbol.getData(), arbol.getData(), false);
      return arbol2;
    }
    return null;
  }

  private void sumAndDifRec(
      BinaryTree<Integer> ab1,
      BinaryTree<ArrayList<Integer>> ab2,
      int ancestro,
      int sumaAncestro,
      boolean esHijoIzquierdo) {

    if (ab1 == null || ab1.isEmpty())
      return;

    ArrayList<Integer> lista = new ArrayList<Integer>();
    lista.add(ab1.getData() + sumaAncestro);
    lista.add(ab1.getData() - ancestro);

    BinaryTree<ArrayList<Integer>> nodoActual = new BinaryTree<ArrayList<Integer>>(lista);

    if (esHijoIzquierdo) {
      ab2.addLeftChild(nodoActual);
    } else {
      ab2.addRightChild(nodoActual);
    }
    if (ab1.hasLeftChild())
      sumAndDifRec(ab1.getLeftChild(), nodoActual, ab1.getData(), ab1.getData() + sumaAncestro, true);
    if (ab1.hasRightChild())
      sumAndDifRec(ab1.getRightChild(), nodoActual, ab1.getData(), ab1.getData() + sumaAncestro, false);
  }

  public void imprimirArbolListas(BinaryTree<ArrayList<Integer>> ab) {
    imprimirArbolListasRec(ab, "");
  }

  private void imprimirArbolListasRec(BinaryTree<ArrayList<Integer>> ab, String prefijo) {
    if (ab != null && !ab.isEmpty()) {
      System.out.print(prefijo);
      System.out.print("[");

      for (int i = 0; i < ab.getData().size(); i++) {
        System.out.print(ab.getData().get(i));
        if (i < ab.getData().size() - 1) {
          System.out.print(", ");
        }
      }

      System.out.println("] (Suma con ancestros, Diferencia con ancestro directo)");

      if (ab.hasLeftChild()) {
        System.out.println(prefijo + "├── Hijo izquierdo:");
        imprimirArbolListasRec(ab.getLeftChild(), prefijo + "│   ");
      }

      if (ab.hasRightChild()) {
        System.out.println(prefijo + "└── Hijo derecho:");
        imprimirArbolListasRec(ab.getRightChild(), prefijo + "    ");
      }
    }
  }

  // Método para imprimir el árbol original en formato de árbol
  public void imprimirArbol(BinaryTree<Integer> ab) {
    imprimirArbolRec(ab, "");
  }

  private void imprimirArbolRec(BinaryTree<Integer> ab, String prefijo) {
    if (ab != null && !ab.isEmpty()) {
      System.out.println(prefijo + ab.getData());

      if (ab.hasLeftChild()) {
        System.out.println(prefijo + "├── Hijo izquierdo:");
        imprimirArbolRec(ab.getLeftChild(), prefijo + "│   ");
      }

      if (ab.hasRightChild()) {
        System.out.println(prefijo + "└── Hijo derecho:");
        imprimirArbolRec(ab.getRightChild(), prefijo + "    ");
      }
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
    parcial.imprimirArbol(arbol);
    parcial.imprimirArbolListas(arbol2);
  }
}
