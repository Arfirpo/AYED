package TP3.Ejercicio8;

import TP3.Ejercicio1y2.GeneralTree;

public class Ejercicio8 {
  public static void main(String[] args) {
    GeneralTree<Integer> nodo1 = new GeneralTree<Integer>(1);
    GeneralTree<Integer> nodo2 = new GeneralTree<Integer>(2);
    GeneralTree<Integer> nodo3 = new GeneralTree<Integer>(3);
    GeneralTree<Integer> nodo4 = new GeneralTree<Integer>(4);

    nodo1.addChild(nodo2);
    nodo1.addChild(nodo3);
    nodo1.addChild(nodo4);

    Navidad n = new Navidad(nodo1);

    System.out.print("¿Es el arbol analizado un abeto navideño? ");
    System.out.print(n.esAbetoNavideño());

    System.out.println();

    GeneralTree<Integer> nodo5 = new GeneralTree<Integer>(5);
    GeneralTree<Integer> nodo6 = new GeneralTree<Integer>(6);
    GeneralTree<Integer> nodo7 = new GeneralTree<Integer>(7);

    nodo2.addChild(nodo5);
    nodo2.addChild(nodo6);
    nodo2.addChild(nodo7);

    Navidad n2 = new Navidad(nodo1);

    System.out.print("¿Es el arbol analizado un abeto navideño? ");
    System.out.print(n2.esAbetoNavideño());
    System.out.println();

    GeneralTree<Integer> nodoA = new GeneralTree<Integer>(1);
    GeneralTree<Integer> nodoA1 = new GeneralTree<Integer>(2);
    GeneralTree<Integer> nodoA2 = new GeneralTree<Integer>(3);
    GeneralTree<Integer> nodoA3 = new GeneralTree<Integer>(4);
    GeneralTree<Integer> nodoA4 = new GeneralTree<Integer>(5);
    GeneralTree<Integer> nodoA2a = new GeneralTree<Integer>(6);
    GeneralTree<Integer> nodoA2b = new GeneralTree<Integer>(7);
    GeneralTree<Integer> nodoA2c = new GeneralTree<Integer>(8);

    nodoA.addChild(nodoA1);
    nodoA.addChild(nodoA2);
    nodoA.addChild(nodoA3);
    nodoA.addChild(nodoA4);

    nodoA2.addChild(nodoA2a);
    nodoA2.addChild(nodoA2b);
    nodoA2.addChild(nodoA2c);

    Navidad n3 = new Navidad(nodoA);

    System.out.print("¿Es el arbol analizado un abeto navideño? ");
    System.out.print(n3.esAbetoNavideño());

  }
}
