package Practica2.ejercicio7;

import Practica2.Ejercicio1y2.BinaryTree;

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

    return (!this.arbol.isEmpty()) && (this.arbol != null) ? isLeftTreeRec(this.arbol, num) : false;
  }

  private boolean isLeftTreeRec(BinaryTree<Integer> nodo, int num) {
    if ((nodo == null) || (nodo.isEmpty()))
      return false;
    if (nodo.getData() == num) {
      int cantIzq = 0;
      int cantDer = 0;
      
      if(nodo.hasLeftChild()){
        cantIzq = contadorHijoUnico(nodo.getLeftChild(), 0)
      } else cantIzq = -1;
      
      if(nodo.hasRightChild()) {
        cantDer = contadorHijoUnico(nodo.getRightChild(), 0);
      } else cantDer = -1;

      return cantIzq > cantDer;
    } 
    else {
      if (nodo.hasLeftChild())
        isLeftTreeRec(nodo.getLeftChild(), num);
      if (nodo.hasRightChild())
        isLeftTreeRec(nodo.getRightChild(), num);
    }
    return false;
  }

  private int contadorHijoUnico(BinaryTree<Integer> nodo, int cant) {
    if (!nodo.isLeaf()) {
      cant += 1 + (nodo.hasLeftChild() && !nodo.hasRightChild() ? contadorHijoUnico(nodo.getLeftChild(), cant)
          : contadorHijoUnico(nodo.getRightChild(), cant + 1));
    }
    return cant;
  }

}
