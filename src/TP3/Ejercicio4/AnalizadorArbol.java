package TP3.Ejercicio4;

import java.util.LinkedList;
import java.util.List;

import TP1.Ejercicio8.Queue;
import TP3.Ejercicio1y2.GeneralTree;

public class AnalizadorArbol {

  public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
    if (arbol == null || arbol.isEmpty())
      return 0.00;
    Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
    cola.enqueue(arbol);
    double maxProm = 0;
    while (!cola.isEmpty()) {
      double promNivel = 0;
      int nodosNivel = cola.size();
      for (int i = 0; i < nodosNivel; i++) {
        GeneralTree<AreaEmpresa> nodoActual = cola.dequeue();
        promNivel += nodoActual.getData().getRetardo();
        List<GeneralTree<AreaEmpresa>> children = nodoActual.getChildren();
        children.forEach(child -> cola.enqueue(child));
      }
      promNivel = promNivel / nodosNivel;
      if (promNivel > maxProm) {
        maxProm = promNivel;
      }
    }
    return maxProm;
  }

  public static void main(String[] args) {

    AnalizadorArbol anArb = new AnalizadorArbol();

    // nodo 1
    AreaEmpresa A = new AreaEmpresa("A", 4);
    AreaEmpresa B = new AreaEmpresa("B", 7);
    AreaEmpresa C = new AreaEmpresa("C", 5);
    List<GeneralTree<AreaEmpresa>> children1 = new LinkedList<GeneralTree<AreaEmpresa>>();
    children1.add(new GeneralTree<AreaEmpresa>(A));
    children1.add(new GeneralTree<AreaEmpresa>(B));
    children1.add(new GeneralTree<AreaEmpresa>(C));
    // nodo 2
    AreaEmpresa D = new AreaEmpresa("D", 6);
    AreaEmpresa E = new AreaEmpresa("E", 10);
    AreaEmpresa F = new AreaEmpresa("F", 18);
    List<GeneralTree<AreaEmpresa>> children2 = new LinkedList<GeneralTree<AreaEmpresa>>();
    children2.add(new GeneralTree<AreaEmpresa>(D));
    children2.add(new GeneralTree<AreaEmpresa>(E));
    children2.add(new GeneralTree<AreaEmpresa>(F));
    // nodo 3
    AreaEmpresa G = new AreaEmpresa("G", 9);
    AreaEmpresa H = new AreaEmpresa("H", 12);
    AreaEmpresa I = new AreaEmpresa("I", 19);
    List<GeneralTree<AreaEmpresa>> children3 = new LinkedList<GeneralTree<AreaEmpresa>>();
    children3.add(new GeneralTree<AreaEmpresa>(G));
    children3.add(new GeneralTree<AreaEmpresa>(H));
    children3.add(new GeneralTree<AreaEmpresa>(I));
    // Raiz
    AreaEmpresa J = new AreaEmpresa("J", 13);
    GeneralTree<AreaEmpresa> c3 = new GeneralTree<AreaEmpresa>(J, children1);
    AreaEmpresa K = new AreaEmpresa("K", 25);
    GeneralTree<AreaEmpresa> c2 = new GeneralTree<AreaEmpresa>(K, children2);
    AreaEmpresa L = new AreaEmpresa("L", 10);
    GeneralTree<AreaEmpresa> c1 = new GeneralTree<AreaEmpresa>(L, children3);

    List<GeneralTree<AreaEmpresa>> children = new LinkedList<GeneralTree<AreaEmpresa>>();
    children.add(c1);
    children.add(c2);
    children.add(c3);

    AreaEmpresa M = new AreaEmpresa("M", 14);
    GeneralTree<AreaEmpresa> Empresa = new GeneralTree<AreaEmpresa>(M, children);

    System.out.println("El Mayor promedio por nivel del arbol ingresado es: " + anArb.devolverMaximoPromedio(Empresa));

  }
}
