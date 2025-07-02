package Parciales;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import TP3.Ejercicio1y2.GeneralTree;

public class ParcialArboles {

  public static List<Integer> caminoSignoAlternante(GeneralTree<Integer> arbol) {
    List<Integer> resultado = new LinkedList<Integer>();
    if (arbol != null && !arbol.isEmpty()) {
      List<Integer> caminoActual = new LinkedList<Integer>();
      int[] max = new int[1];
      max[0] = Integer.MIN_VALUE;
      caminoRecursivo(arbol, caminoActual, resultado, null, max);
    }
    return resultado;
  }

  private static String signoValido(Integer num) {
    return num >= 0 ? "positivo" : "negativo";
  }

  private static void caminoRecursivo(GeneralTree<Integer> nodo, List<Integer> caminoActual,
      List<Integer> resultado, String signoAnterior, int[] max) {

    if (nodo == null || nodo.isEmpty()) {
      return;
    }

    // Agregar el nodo actual al camino
    caminoActual.add(nodo.getData());
    String signoActual = signoValido(nodo.getData());

    // Verificar si el signo alterna correctamente
    Boolean esSignoValido = signoAnterior == null || !signoActual.equals(signoAnterior);

    if (esSignoValido) {
      // Si es una hoja, evaluar el costo del camino
      if (nodo.isLeaf()) {
        int costoActual = 0;
        for (int i = 0; i < caminoActual.size(); i++) {
          costoActual += caminoActual.get(i);
        }
        if (costoActual > max[0]) {
          max[0] = costoActual;
          resultado.clear();
          resultado.addAll(caminoActual);
        }
      } else {
        // Continuar la búsqueda en los hijos
        if (nodo.hasChildren()) {
          List<GeneralTree<Integer>> hijos = nodo.getChildren();
          Iterator<GeneralTree<Integer>> It = hijos.iterator();
          while (It.hasNext()) {
            caminoRecursivo(It.next(), caminoActual, resultado, signoActual, max);
          }
        }
      }
    }

    // Backtracking: remover el nodo actual del camino
    caminoActual.remove(caminoActual.size() - 1);
  }

  public static void main(String args[]) {
    // Crear el árbol de ejemplo
    GeneralTree<Integer> raiz = new GeneralTree<Integer>(5);
    GeneralTree<Integer> n2 = new GeneralTree<Integer>(-2);
    GeneralTree<Integer> n3 = new GeneralTree<Integer>(-4);
    GeneralTree<Integer> n4 = new GeneralTree<Integer>(7);
    GeneralTree<Integer> n5 = new GeneralTree<Integer>(-5);
    GeneralTree<Integer> n6 = new GeneralTree<Integer>(8);
    GeneralTree<Integer> n7 = new GeneralTree<Integer>(6);
    GeneralTree<Integer> n8 = new GeneralTree<Integer>(-1);

    raiz.addChild(n2);
    raiz.addChild(n3);
    n2.addChild(n4);
    n2.addChild(n5);
    n2.addChild(n6);
    n3.addChild(n7);
    n6.addChild(n8);

    List<Integer> resultado = caminoSignoAlternante(raiz);

    System.out.println("Camino con signo alternante de mayor costo:");
    for (Integer num : resultado) {
      System.out.print(num + " ");
    }
    System.out.println();

    // Mostrar el costo total
    int costo = 0;
    for (Integer num : resultado) {
      costo += num;
    }
    System.out.println("Costo total: " + costo);
  }
}