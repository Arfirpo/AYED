package TP2.Ejercicio4;

import TP1.Ejercicio8.Queue;
import TP2.Ejercicio1y2.BinaryTree;

public class RedBinariaLlena {

  public static int retardoReenvio(BinaryTree<Integer> ab) {
    int maxReenvio = 0;
    int reenvioNivel = 0;
    if (ab.isEmpty())
      return -1;
    BinaryTree<Integer> nodoActual = null;
    Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
    cola.enqueue(ab);
    cola.enqueue(null);
    while (!cola.isEmpty()) {
      nodoActual = cola.dequeue();
      if (nodoActual != null) {
        if (nodoActual.getData() > reenvioNivel)
          reenvioNivel = nodoActual.getData();
        if (nodoActual.hasLeftChild())
          cola.enqueue(nodoActual.getLeftChild());
        if (nodoActual.hasRightChild())
          cola.enqueue(nodoActual.getRightChild());
      } else {
        maxReenvio += reenvioNivel;
        reenvioNivel = -1;
        if (!cola.isEmpty()) {
          cola.enqueue(null);
        }
      }
    }
    return maxReenvio;
  }

  public static void main(String[] args) {
    BinaryTree<Integer> arbol = new BinaryTree<Integer>(10);

    BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(2);

    hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(5));
    hijoIzquierdo.addRightChild(new BinaryTree<Integer>(4));

    hijoIzquierdo.getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
    hijoIzquierdo.getLeftChild().addRightChild(new BinaryTree<Integer>(8));

    hijoIzquierdo.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
    hijoIzquierdo.getRightChild().addRightChild(new BinaryTree<Integer>(6));

    BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(3);

    hijoDerecho.addLeftChild(new BinaryTree<Integer>(9));
    hijoDerecho.addRightChild(new BinaryTree<Integer>(8));

    hijoDerecho.getLeftChild().addLeftChild(new BinaryTree<Integer>(12));
    hijoDerecho.getLeftChild().addRightChild(new BinaryTree<Integer>(8));

    hijoDerecho.getRightChild().addLeftChild(new BinaryTree<Integer>(2));
    hijoDerecho.getRightChild().addRightChild(new BinaryTree<Integer>(1));

    arbol.addLeftChild(hijoIzquierdo);
    arbol.addRightChild(hijoDerecho);

    System.out.println(retardoReenvio(arbol));
  }
}
