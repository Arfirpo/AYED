package Practica2.Ejercicio5;

import Practica2.Ejercicio1y2.BinaryTree;

public class ProfundidadArbolBinario {
  private BinaryTree<Integer> arbol;

  public ProfundidadArbolBinario(int dato) {
    this.arbol = new BinaryTree<Integer>(dato);
  }

  public ProfundidadArbolBinario(BinaryTree<Integer> arbol) {
    this.setArbol(arbol);
  }

  public int sumaElementosProfundidad(int profundidad) {
    if (profundidad < 0)
      return 0;
    if (this.arbol == null || this.arbol.isEmpty())
      return 0;
    return sumaRecursiva(arbol, profundidad, 0);
  }

  private int sumaRecursiva(BinaryTree<Integer> nodo, int profundidad, int nivel) {
    if (nodo == null || nodo.isEmpty()) {
      return 0;
    }
    if (nivel == profundidad) {
      return nodo.getData();
    }

    if (nivel < profundidad) {
      int sumaIzq = 0;
      int sumaDer = 0;
      if (nodo.hasLeftChild())
        sumaIzq = sumaRecursiva(nodo.getLeftChild(), profundidad, nivel + 1);
      if (nodo.hasRightChild())
        sumaDer = sumaRecursiva(nodo.getRightChild(), profundidad, nivel + 1);
      return sumaIzq + sumaDer;
    }

    return 0;
  }

  public BinaryTree<Integer> getArbol() {
    return arbol;
  }

  public void setArbol(BinaryTree<Integer> arbol) {
    this.arbol = arbol;
  }

  public static void main(String[] args) {
    //raiz
    BinaryTree<Integer> arbol = new BinaryTree<Integer>(10);
    //nivel 1
    BinaryTree<Integer> hijoIzquierdo = new BinaryTree<>(15);
    BinaryTree<Integer> hijoDerecho = new BinaryTree<>(34);
    //nivel 2
    hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(28));
    hijoIzquierdo.addRightChild(new BinaryTree<Integer>(91));
    hijoDerecho.addLeftChild(new BinaryTree<Integer>(52));
    hijoDerecho.addRightChild(new BinaryTree<Integer>(37));
    
    arbol.addLeftChild(hijoIzquierdo);
    arbol.addRightChild(hijoDerecho);

    ProfundidadArbolBinario ab = new ProfundidadArbolBinario(arbol);
    System.out.println("La suma de los nodos de profundidad " + 0 + " es: " + ab.sumaElementosProfundidad(0));
    System.out.println("La suma de los nodos de profundidad " + 1 + " es: " + ab.sumaElementosProfundidad(1));
    System.out.println("La suma de los nodos de profundidad " + 2 + " es: " + ab.sumaElementosProfundidad(2));
  }

}
