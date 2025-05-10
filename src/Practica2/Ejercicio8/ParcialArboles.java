package Practica2.Ejercicio8;

import Practica2.Ejercicio1y2.BinaryTree;

public class ParcialArboles {

  public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
    return ((arbol1 != null && !arbol1.isEmpty()) && (arbol2 != null && !arbol2.isEmpty()))
        ? esPrefijoRec(arbol1, arbol2)
        : false;
  }

  private boolean esPrefijoRec(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {

    if (arbol1 == null)
      return true;

    if (arbol2 == null)
      return false;

    if (!arbol1.getData().equals(arbol2.getData())) {
      return false;
    }

    boolean prefijoIzquierdo = true;
    Boolean prefijoDerecho = true;
    if (arbol1.hasLeftChild())
      prefijoIzquierdo = esPrefijoRec(arbol1.getLeftChild(), arbol2.getLeftChild());
    if (arbol1.hasRightChild() && prefijoIzquierdo)
      prefijoDerecho = esPrefijoRec(arbol1.getRightChild(), arbol2.getRightChild());
    return prefijoIzquierdo && prefijoDerecho;
  }

  public static void main(String[] args) {

    //Arbol 1
    BinaryTree<Integer> ab1 = new BinaryTree<Integer>(65);

    BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(37);
    BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(81);

    hijoIzquierdo.addRightChild(new BinaryTree<Integer>(47));
    hijoDerecho.addRightChild(new BinaryTree<Integer>(93));

    ab1.addLeftChild(hijoIzquierdo);
    ab1.addRightChild(hijoDerecho);

    //Arbol 2
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

    hijoDerecho2.getRightChild().addLeftChild(new BinaryTree<Integer>(85));
    hijoDerecho2.getRightChild().addRightChild(new BinaryTree<Integer>(94));

    ab2.addLeftChild(hijoIzquierdo2);
    ab2.addRightChild(hijoDerecho2);
    
    //Arbol 3
    BinaryTree<Integer> ab3 = new BinaryTree<Integer>(65);
    BinaryTree<Integer> hijoIzquierdo3 = new BinaryTree<Integer>(37);
    BinaryTree<Integer> hijoDerecho3 = new BinaryTree<Integer>(81);

    hijoIzquierdo3.addLeftChild(new BinaryTree<Integer>(22));
    hijoIzquierdo3.addRightChild(new BinaryTree<Integer>(47));

    hijoIzquierdo3.getLeftChild().addLeftChild(new BinaryTree<Integer>(11));
    hijoIzquierdo3.getLeftChild().addRightChild(new BinaryTree<Integer>(29));

    hijoDerecho3.addLeftChild(new BinaryTree<Integer>(76));

    ab3.addLeftChild(hijoIzquierdo3);
    ab3.addRightChild(hijoDerecho3);

    //Arbol 4
    BinaryTree<Integer> ab4 = new BinaryTree<Integer>(65);
    BinaryTree<Integer> hijoIzquierdo4 = new BinaryTree<Integer>(62);
    BinaryTree<Integer> hijoDerecho4 = new BinaryTree<Integer>(81);

    hijoIzquierdo4.addLeftChild(new BinaryTree<Integer>(22));
    hijoIzquierdo4.addRightChild(new BinaryTree<Integer>(47));

    hijoIzquierdo4.getLeftChild().addLeftChild(new BinaryTree<Integer>(11));
    hijoIzquierdo4.getLeftChild().addRightChild(new BinaryTree<Integer>(29));
    ;

    hijoDerecho4.addLeftChild(new BinaryTree<Integer>(76));
    hijoDerecho4.addRightChild(new BinaryTree<Integer>(93));

    hijoDerecho4.getRightChild().addLeftChild(new BinaryTree<Integer>(85));
    hijoDerecho4.getRightChild().addRightChild(new BinaryTree<Integer>(94));

    ab4.addLeftChild(hijoIzquierdo4);
    ab4.addRightChild(hijoDerecho4);

    ParcialArboles pA = new ParcialArboles();

    System.out.println("¿El Arbol 1 es prefijo del arbol 2? " + (pA.esPrefijo(ab1, ab2) ? "Si" : "No"));

    System.out.println("¿El Arbol 1 es prefijo del arbol 3? " + (pA.esPrefijo(ab1, ab3) ? "Si" : "No"));

    System.out.println("¿El Arbol 1 es prefijo del arbol 4? " + (pA.esPrefijo(ab1, ab4) ? "Si" : "No"));

  }

}
