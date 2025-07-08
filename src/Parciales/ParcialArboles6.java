package Parciales;

import TP2.Ejercicio1y2.BinaryTree;

public class ParcialArboles6 {

  public static BinaryTree<int[]> sumAndDif(BinaryTree<Integer> arbol) {
    BinaryTree<int[]> resultado = new BinaryTree<int[]>();
    if (arbol != null && !arbol.isEmpty()) {
      sumAndDifRec(arbol, resultado, 0, 0);
    }
    return resultado;
  }

  private static void sumAndDifRec(BinaryTree<Integer> nodo, BinaryTree<int[]> resultado, int valorPadre,
      int acumulado) {

    int[] valoresNodo = new int[2];
    acumulado += nodo.getData();
    valoresNodo[0] = acumulado;
    valoresNodo[1] = nodo.getData() - valorPadre;
    resultado.setData(valoresNodo);

    if (!nodo.isLeaf()) {

      if (nodo.hasLeftChild()) {
        BinaryTree<int[]> hijoIzquierdo = new BinaryTree<int[]>();
        sumAndDifRec(nodo.getLeftChild(), hijoIzquierdo, nodo.getData(), acumulado);
        resultado.addLeftChild(hijoIzquierdo);
      }

      if (nodo.hasRightChild()) {
        BinaryTree<int[]> hijoDerecho = new BinaryTree<int[]>();
        sumAndDifRec(nodo.getRightChild(), hijoDerecho, nodo.getData(), acumulado);
        resultado.addRightChild(hijoDerecho);
      }
    }

  }

  public static void imprimirPreordenA(BinaryTree<int[]> arbol) {
    int[] valoresAct = arbol.getData();
    System.out.println("[" + valoresAct[0] + " | " + valoresAct[1] + "]");

    if(arbol.hasLeftChild()){
      imprimirPreordenA(arbol.getLeftChild());
    }
    if(arbol.hasRightChild()){
      imprimirPreordenA(arbol.getRightChild());
    }
  }

  public static void main(String[] args) {

    BinaryTree<Integer> raiz = new BinaryTree<Integer>(20);

    BinaryTree<Integer> n11 = new BinaryTree<Integer>(5);
    BinaryTree<Integer> n12 = new BinaryTree<Integer>(30);

    BinaryTree<Integer> n21 = new BinaryTree<Integer>(-5);
    BinaryTree<Integer> n22 = new BinaryTree<Integer>(10);
    BinaryTree<Integer> n23 = new BinaryTree<Integer>(50);
    BinaryTree<Integer> n24 = new BinaryTree<Integer>(-9);

    BinaryTree<Integer> n31 = new BinaryTree<Integer>(1);
    BinaryTree<Integer> n32 = new BinaryTree<Integer>(4);

    BinaryTree<Integer> n41 = new BinaryTree<Integer>(6);

    raiz.addLeftChild(n11);
    raiz.addRightChild(n12);

    n11.addLeftChild(n21);
    n11.addRightChild(n22);

    n12.addLeftChild(n23);
    n12.addRightChild(n24);

    n22.addLeftChild(n31);

    n23.addRightChild(n32);

    n32.addRightChild(n41);

    BinaryTree<int[]> resultado = sumAndDif(raiz);

    imprimirPreordenA(resultado);
  }
}
