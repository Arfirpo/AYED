package TP2.Ejercicio7;

import TP2.Ejercicio1y2.BinaryTree;

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
    return (this.arbol != null || !this.arbol.isEmpty()) ? isLeftTreeRecursive(this.arbol, num) : false;
  }

  private boolean isLeftTreeRecursive(BinaryTree<Integer> nodo, int num) {
    
    if (nodo == null || nodo.isEmpty())
      return false;

    else if (nodo.getData() == num) {
      int cantLeft = 0;
      int cantRight = 0;
      if (nodo.hasLeftChild())
        cantLeft = contadorHijosUnicos(nodo.getLeftChild());
      else
        cantLeft = -1;
      if (nodo.hasRightChild())
        cantRight = contadorHijosUnicos(nodo.getRightChild());
      else
        cantRight = -1;
      return cantLeft > cantRight;
    }
    
    boolean estaIzq = false;
    boolean estaDer = false;
    if (nodo.hasLeftChild()) {
      estaIzq = isLeftTreeRecursive(nodo.getLeftChild(), num);
    }
    if (!estaIzq && nodo.hasRightChild())
      estaDer = isLeftTreeRecursive(nodo.getRightChild(), num);
    return estaIzq || estaDer;
  }

  private int contadorHijosUnicos(BinaryTree<Integer> nodo) {
    if (nodo == null || nodo.isEmpty())
      return 0;
    int cant = 0;
    if (nodo.hasLeftChild() && !nodo.hasRightChild()
        || !nodo.hasLeftChild() && nodo.hasRightChild()) {
      cant = 1;
    }
    int cantIzq = 0;
    int cantDer = 0;
    if (nodo.hasLeftChild())
      cantIzq = contadorHijosUnicos(nodo.getLeftChild());
    if (nodo.hasRightChild())
      cantDer = contadorHijosUnicos(nodo.getRightChild());
    return cant + cantIzq + cantDer;
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
    System.out.println("¿EL subarbol con el nodo " + 7 + " es arbol izquierdo? " + pA.isLeftTree(7));
    System.out.println("¿EL subarbol con el nodo " + 2 + " es arbol izquierdo? " + pA.isLeftTree(2));
    System.out.println("¿EL subarbol con el nodo " + -5 + " es arbol izquierdo? " + pA.isLeftTree(-5));
    System.out.println("¿EL subarbol con el nodo " + 19 + " es arbol izquierdo? " + pA.isLeftTree(19));
    System.out.println("¿EL subarbol con el nodo " + -3 + " es arbol izquierdo? " + pA.isLeftTree(-3));
  }
}
