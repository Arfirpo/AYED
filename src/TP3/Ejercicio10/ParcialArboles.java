package TP3.Ejercicio10;

import java.util.LinkedList;
import java.util.List;

import TP3.Ejercicio1y2.GeneralTree;

public class ParcialArboles {

  public static List<Integer> resolver(GeneralTree<Integer> arbol) {
    if (arbol == null || arbol.isEmpty())
      return new LinkedList<Integer>();
    List<Integer> caminoAct = new LinkedList<Integer>();
    List<Integer> caminoMax = new LinkedList<Integer>();
    resolverRec(arbol, caminoAct, caminoMax, 0,0,0);
    return caminoMax;
  }

  private static void resolverRec(GeneralTree<Integer> nodo, List<Integer> caminoAct, List<Integer> caminoMax,
      int nivel,int cant, int cantMax) {
    if (nodo == null || nodo.isEmpty())
      return;

    if (nodo.getData() == 1) 
      caminoAct.add(nodo.getData());
      cant += 
    

    if (nodo.isLeaf()) {
      int act = 0;
      int max = 0;
      for (int i = 0; i < caminoAct.size(); i++) {
        
      }
      return;
    }
    nivel++;
    List<GeneralTree<Integer>> children = nodo.getChildren();
    for (GeneralTree<Integer> child : children) {
      resolverRec(child, caminoAct, caminoMax, nivel);
      caminoAct.remove(caminoAct.size() - 1);
    }

  }
}
