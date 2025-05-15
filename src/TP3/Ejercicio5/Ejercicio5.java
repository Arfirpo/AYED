package TP3.Ejercicio5;

import java.util.LinkedList;
import java.util.List;

import TP3.Ejercicio1y2.GeneralTree;

public class Ejercicio5 {
  public static void main(String[] args) {
    List<GeneralTree<Integer>> children4 = new LinkedList<GeneralTree<Integer>>();
    children4.add(new GeneralTree<Integer>(10));
    GeneralTree<Integer> nodo2C = new GeneralTree<Integer>(4, children4);

    List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
    children3.add(new GeneralTree<Integer>(7));
    children3.add(new GeneralTree<Integer>(8));
    children3.add(new GeneralTree<Integer>(9));
    GeneralTree<Integer> nodo2B = new GeneralTree<Integer>(3, children3);

    children3.get(2).addChild(new GeneralTree<Integer>(11));

    List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
    children2.add(new GeneralTree<Integer>(5));
    children2.add(new GeneralTree<Integer>(6));
    GeneralTree<Integer> nodo2A = new GeneralTree<Integer>(2, children2);

    List<GeneralTree<Integer>> children1 = new LinkedList<GeneralTree<Integer>>();
    children1.add(nodo2A);
    children1.add(nodo2B);
    children1.add(nodo2C);

    GeneralTree<Integer> ag = new GeneralTree<Integer>(1, children1);

    System.out.println(
        "¿El nodo con numero 11 es ancestro del que tiene nodo 1? : " + (ag.esAncestro(11, 1) ? "Si." : "No."));
    System.out.println(
        "¿El nodo con numero 1 es ancestro del que tiene nodo 11? : " + (ag.esAncestro(1, 11) ? "Si." : "No."));
  }
}
