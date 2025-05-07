package Practica2.Ejercicio5;

import Practica2.Ejercicio1y2.BinaryTree;

public class ProfundidadArbolBinario {
  private BinaryTree<Integer> arbol;

  public ProfundidadArbolBinario(int dato) {
    this.arbol = new BinaryTree<Integer>(dato);
  }

  public int sumaElementosProfundidad(int profundidad) {
    int suma = 0;
    int nivel = 0;
    return !this.arbol.isEmpty() ? suma = sumaRecursiva(arbol, profundidad, nivel, suma) : 0;
  }

  private int sumaRecursiva(BinaryTree<Integer> arbol, int profundidad, int nivel, int suma) {
    if (nivel >= 0 && nivel < profundidad) {
      if (arbol.hasLeftChild())
        sumaRecursiva(arbol.getLeftChild(), profundidad, nivel++, suma);
      if (arbol.hasRightChild())
        sumaRecursiva(arbol.getRightChild(), profundidad, nivel++, suma);
    } else if (nivel == profundidad) {
      return suma += arbol.getData();
    }
    return suma;
  }
}
