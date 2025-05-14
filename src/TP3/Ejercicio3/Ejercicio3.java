package TP3.Ejercicio3;

import java.util.LinkedList;
import java.util.List;

import TP3.Ejercicio1y2.GeneralTree;

public class Ejercicio3 {
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

		System.out.println("El arbol ingresado tiene altura: " + ag.altura());
		System.out.println("El dato 1 tiene nivel: " + ag.nivel(1));
		System.out.println("El dato 4 tiene nivel: " + ag.nivel(4));
		System.out.println("El dato 8 tiene nivel: " + ag.nivel(8));
		System.out.println("El dato 11 tiene nivel: " + ag.nivel(11));
	}
}
