package TP3.Ejercicio7;

import java.util.List;

import TP3.Ejercicio1y2.GeneralTree;

public class Ejercicio7 {
  public static void main(String[] args) {

    // arbol 1
    GeneralTree<Integer> nodoA = new GeneralTree<Integer>(8);
    GeneralTree<Integer> nodoB = new GeneralTree<Integer>(3);
    GeneralTree<Integer> nodoC = new GeneralTree<Integer>(5);
    GeneralTree<Integer> nodoD = new GeneralTree<Integer>(4);
    GeneralTree<Integer> nodoE = new GeneralTree<Integer>(7);
    GeneralTree<Integer> nodoF = new GeneralTree<Integer>(6);
    GeneralTree<Integer> nodoG = new GeneralTree<Integer>(1);
    GeneralTree<Integer> nodoH = new GeneralTree<Integer>(9);
    GeneralTree<Integer> nodoI = new GeneralTree<Integer>(10);
    GeneralTree<Integer> nodoJ = new GeneralTree<Integer>(2);

    nodoE.addChild(nodoJ);

    nodoC.addChild(nodoG);
    nodoC.addChild(nodoH);
    nodoC.addChild(nodoI);

    nodoB.addChild(nodoD);
    nodoB.addChild(nodoE);
    nodoB.addChild(nodoF);

    nodoA.addChild(nodoB);
    nodoA.addChild(nodoC);

    // arbol 2
    GeneralTree<Integer> nodo1 = new GeneralTree<Integer>(12);
    GeneralTree<Integer> nodo2 = new GeneralTree<Integer>(17);
    GeneralTree<Integer> nodo3 = new GeneralTree<Integer>(9);
    GeneralTree<Integer> nodo4 = new GeneralTree<Integer>(15);
    GeneralTree<Integer> nodo5 = new GeneralTree<Integer>(10);
    GeneralTree<Integer> nodo6 = new GeneralTree<Integer>(6);
    GeneralTree<Integer> nodo7 = new GeneralTree<Integer>(8);
    GeneralTree<Integer> nodo8 = new GeneralTree<Integer>(14);
    GeneralTree<Integer> nodo9 = new GeneralTree<Integer>(18);
    GeneralTree<Integer> nodo10 = new GeneralTree<Integer>(1);
    GeneralTree<Integer> nodo11 = new GeneralTree<Integer>(16);
    GeneralTree<Integer> nodo12 = new GeneralTree<Integer>(7);

    nodo1.addChild(nodo2);
    nodo1.addChild(nodo3);
    nodo1.addChild(nodo4);

    nodo2.addChild(nodo5);
    nodo2.addChild(nodo6);

    nodo6.addChild(nodo10);

    nodo3.addChild(nodo7);

    nodo4.addChild(nodo8);
    nodo4.addChild(nodo9);

    nodo8.addChild(nodo11);
    nodo8.addChild(nodo12);

    Caminos caminos = new Caminos(nodoA);

    List<Integer> resultado = caminos.caminoAHojaMasLejana();
    System.out.print("El primero camino mas largo hasta una hoja es la secuencia: [");
    resultado
        .forEach(child -> System.out
            .print((resultado.indexOf(child) < resultado.size() - 1 ? child + " » " : child)));
    System.out.print("]");

    System.out.println();

    Caminos caminos2 = new Caminos(nodo1);

    List<Integer> resultado2 = caminos2.caminoAHojaMasLejana();
    System.out.print("El primero camino mas largo hasta una hoja es la secuencia: [");
    resultado2
        .forEach(child -> System.out
            .print((resultado2.indexOf(child) < resultado2.size() - 1 ? child + " » " : child)));
    System.out.print("]");

  }
}
