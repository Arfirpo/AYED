package Practica2.Ejercicio5;

import Practica2.Ejercicio1y2.BinaryTree;

public class ProfundidadArbolBinario {
  private BinaryTree<Integer> arbol;

  public ProfundidadArbolBinario(int dato) {
    this.arbol = new BinaryTree<Integer>(dato);
  }

  public int sumaElementosProfundidad(int profundidad) {
    if(profundidad < 0) return 0;
    if(this.arbol == null || this.arbol.isEmpty()) return 0;
    return sumaRecursiva(arbol, profundidad, 0)
  }

  private int sumaRecursiva(BinaryTree<Integer> nodo, int profundidad, int nivel) {
    if (nodo == null || nodo.isEmpty()) {
      return 0;
    }
    if(nivel == profundidad){
      return nodo.getData();
    }

    if(nivel < profundidad){
      int sumaIzq = 0;
      int sumaDer = 0;
      
    }
  }
}
