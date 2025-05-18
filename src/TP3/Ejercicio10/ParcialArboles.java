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
    int[] cantMax = new int[1];
    cantMax[0] = Integer.MIN_VALUE;
    resolverRec(arbol, caminoAct, caminoMax, 0, 0, cantMax);
    return caminoMax;
  }

  private static void resolverRec(GeneralTree<Integer> nodo, List<Integer> caminoAct, List<Integer> caminoMax,
      int nivel, int cant, int[] cantMax) {
    if (nodo == null || nodo.isEmpty())
      return;

    if (nodo.getData() == 1)
      caminoAct.add(nodo.getData());

    cant += nodo.getData() * nivel;

    if (nodo.isLeaf()) {
      if (cant > cantMax[0]) {
        cantMax[0] = cant;
        caminoMax.clear();
        caminoMax.addAll(caminoAct);
      }
    }

    else {
      nivel++;
      List<GeneralTree<Integer>> children = nodo.getChildren();
      for (GeneralTree<Integer> child : children) {
        resolverRec(child, caminoAct, caminoMax, nivel, cant, cantMax);
      }
      if (!caminoAct.isEmpty())
        caminoAct.remove(caminoAct.size() - 1);
    }
  }

  public static void main(String[] args) {

    GeneralTree<Integer> raiz = new GeneralTree<Integer>(1);

    GeneralTree<Integer> n11 = new GeneralTree<Integer>(0);
    GeneralTree<Integer> n12 = new GeneralTree<Integer>(1);
    GeneralTree<Integer> n13 = new GeneralTree<Integer>(1);

    GeneralTree<Integer> n21 = new GeneralTree<Integer>(1);
    GeneralTree<Integer> n22 = new GeneralTree<Integer>(1);
    GeneralTree<Integer> n23 = new GeneralTree<Integer>(1);
    GeneralTree<Integer> n24 = new GeneralTree<Integer>(0);
    GeneralTree<Integer> n25 = new GeneralTree<Integer>(0);

    GeneralTree<Integer> n31 = new GeneralTree<Integer>(1);
    GeneralTree<Integer> n32 = new GeneralTree<Integer>(1);
    GeneralTree<Integer> n33 = new GeneralTree<Integer>(1);
    GeneralTree<Integer> n34 = new GeneralTree<Integer>(0);
    GeneralTree<Integer> n35 = new GeneralTree<Integer>(0);

    GeneralTree<Integer> n41 = new GeneralTree<Integer>(1);
    GeneralTree<Integer> n42 = new GeneralTree<Integer>(0);
    GeneralTree<Integer> n43 = new GeneralTree<Integer>(0);

    raiz.addChild(n11);
    raiz.addChild(n12);
    raiz.addChild(n13);

    n11.addChild(n21);
    n11.addChild(n22);

    n12.addChild(n23);
    n12.addChild(n24);

    n13.addChild(n25);

    n21.addChild(n31);
    n21.addChild(n32);
    n21.addChild(n33);

    n24.addChild(n34);

    n25.addChild(n35);

    n34.addChild(n41);

    n35.addChild(n42);
    n35.addChild(n43);

    List<Integer> resultado = resolver(raiz);
    System.out.print("El camino filtrado de valor maximo es: ");
    for (int i = 0; i < resultado.size(); i++) {
      if (i < resultado.size() - 1) {
        System.out.print(resultado.get(i) + " » ");
      } else {
        System.out.print(resultado.get(i) + ".");
      }
    }

  }

}
