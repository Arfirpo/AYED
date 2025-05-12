
/*Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() que
devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
árbol (divisibles por 2).
a) Implemente el método realizando un recorrido InOrden.
b) Implemente el método realizando un recorrido PostOrden. 
*/
package TP2.Ejercicio3;

import java.util.ArrayList;

import TP2.Ejercicio1y2.BinaryTree;

public class ContadorArbol {

  private BinaryTree<Integer> arbol;

  public ContadorArbol() {
    this.arbol = new BinaryTree<Integer>();
  }

  public ContadorArbol(BinaryTree<Integer> arbol) {
    this.arbol = arbol;
  }

  public ArrayList<Integer> numerosParesInOrden(BinaryTree<Integer> arbol) {
    ArrayList<Integer> resultado = new ArrayList<Integer>();
    numerosParesInOrdenRec(arbol, resultado);
    return resultado;
  }

  private void numerosParesInOrdenRec(BinaryTree<Integer> nodo, ArrayList<Integer> lista) {
    if (nodo == null || nodo.isEmpty())
      return;
    if (nodo.hasLeftChild())
      numerosParesInOrdenRec(nodo.getLeftChild(), lista);
    if (nodo.getData() % 2 == 0)
      lista.add(nodo.getData());
    if (nodo.hasRightChild())
      numerosParesInOrdenRec(nodo.getRightChild(), lista);
  }

  public ArrayList<Integer> numerosParesPostOrden(BinaryTree<Integer> arbol) {
    ArrayList<Integer> resultado = new ArrayList<Integer>();
    numerosParesPostOrdenRec(arbol, resultado);
    return resultado;
  }

  private void numerosParesPostOrdenRec(BinaryTree<Integer> nodo, ArrayList<Integer> lista) {
    if (nodo == null || nodo.isEmpty())
      return;
    if (nodo.hasLeftChild())
      numerosParesInOrdenRec(nodo.getLeftChild(), lista);
    if (nodo.hasRightChild())
      numerosParesInOrdenRec(nodo.getRightChild(), lista);
    if (nodo.getData() % 2 == 0)
      lista.add(nodo.getData());
  }

  public void setArbol(BinaryTree<Integer> arbol) {
    this.arbol = arbol;
  }

  public BinaryTree<Integer> getArbol() {
    return this.arbol;
  }
}
