package Parciales;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import TP3.Ejercicio1y2.GeneralTree;

public class ParcialArboles5 {

  public static List<Integer> resolver(GeneralTree<Integer> arbol) {
    List<Integer> maximoCaminoFiltrado = new LinkedList<Integer>();
    if (arbol != null && !arbol.isEmpty()) {
      resolverRec(arbol, maximoCaminoFiltrado, new LinkedList<Integer>(), Integer.MIN_VALUE, 0, 0);
    }
    return maximoCaminoFiltrado;
  }

  private static int resolverRec(GeneralTree<Integer> nodo, List<Integer> maxCamino, List<Integer> caminoActual,
      int valorMax, int nivelActual, int sumaAct) {

    sumaAct += nodo.getData() * nivelActual;

    if (nodo.getData() != 0)
      caminoActual.add(nodo.getData());

    if (nodo.isLeaf()) {
      if (sumaAct > valorMax) {
        valorMax = sumaAct;
        maxCamino.clear();
        maxCamino.addAll(new LinkedList<Integer>(caminoActual));
      }
      System.out.println("maximo vigente: " + valorMax);
      System.out.println("suma camino actual: " + sumaAct);
    }

    else {
      Iterator<GeneralTree<Integer>> it = nodo.getChildren().iterator();
      while (it.hasNext()) {
        valorMax = resolverRec(it.next(), maxCamino, caminoActual, valorMax, nivelActual + 1, sumaAct);
      }
    }
    if (nodo.getData() != 0)
      caminoActual.remove(caminoActual.size() - 1);

    return valorMax;
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

    System.out.print("[");
    for (int i = 0; i < resultado.size(); i++) {
      if (i < resultado.size() - 1) {
        System.out.print(resultado.get(i) + " - ");
      } else {
        System.out.print(resultado.get(i) + "]");
      }
    }

  }
}
