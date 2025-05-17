package TP3.Ejercicio9;

import java.util.List;

import TP3.Ejercicio1y2.GeneralTree;

public class ParcialArboles {

  public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
    return (arbol == null || arbol.isEmpty()) ? false : esDeSeleccionRec(arbol);
  }

  private static boolean esDeSeleccionRec(GeneralTree<Integer> nodo) {
    if (nodo == null || nodo.isEmpty())
      return false;

    if (nodo.isLeaf())
      return true;

    List<GeneralTree<Integer>> children = nodo.getChildren();
    int minNodo = Integer.MAX_VALUE;
    for (GeneralTree<Integer> child : children) {
      if (child.getData() < minNodo)
        minNodo = child.getData();
    }
    if (nodo.getData() != minNodo)
      return false;

    for (GeneralTree<Integer> child : children) {
      if (!child.isLeaf() && !esDeSeleccionRec(child))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {

    GeneralTree<Integer> raiz = new GeneralTree<Integer>(12);

    GeneralTree<Integer> nodo21 = new GeneralTree<Integer>(12);
    GeneralTree<Integer> nodo22 = new GeneralTree<Integer>(25);

    GeneralTree<Integer> nodo31 = new GeneralTree<Integer>(35);
    GeneralTree<Integer> nodo32 = new GeneralTree<Integer>(12);
    GeneralTree<Integer> nodo33 = new GeneralTree<Integer>(25);

    GeneralTree<Integer> nodo41 = new GeneralTree<Integer>(35);
    GeneralTree<Integer> nodo42 = new GeneralTree<Integer>(14);
    GeneralTree<Integer> nodo43 = new GeneralTree<Integer>(12);
    GeneralTree<Integer> nodo44 = new GeneralTree<Integer>(33);

    GeneralTree<Integer> nodo51 = new GeneralTree<Integer>(35);
    GeneralTree<Integer> nodo52 = new GeneralTree<Integer>(35);
    GeneralTree<Integer> nodo53 = new GeneralTree<Integer>(83);
    GeneralTree<Integer> nodo54 = new GeneralTree<Integer>(90);
    GeneralTree<Integer> nodo55 = new GeneralTree<Integer>(33);

    nodo41.addChild(nodo51);

    nodo44.addChild(nodo52);
    nodo44.addChild(nodo53);
    nodo44.addChild(nodo54);
    nodo44.addChild(nodo55);

    nodo31.addChild(nodo41);

    nodo32.addChild(nodo42);
    nodo32.addChild(nodo43);
    nodo32.addChild(nodo44);

    nodo21.addChild(nodo31);
    nodo21.addChild(nodo32);

    nodo22.addChild(nodo33);

    raiz.addChild(nodo21);
    raiz.addChild(nodo22);

    System.out.print("¿El arbol dado es de selección? " + (esDeSeleccion(raiz) ? "Si." : "No."));

    System.out.println();

    // Segundo Arbol de Prueba
    GeneralTree<Integer> padre = new GeneralTree<Integer>(12);

    GeneralTree<Integer> n21 = new GeneralTree<Integer>(12);
    GeneralTree<Integer> n22 = new GeneralTree<Integer>(25);

    GeneralTree<Integer> n31 = new GeneralTree<Integer>(35);
    GeneralTree<Integer> n32 = new GeneralTree<Integer>(18);
    GeneralTree<Integer> n33 = new GeneralTree<Integer>(25);

    GeneralTree<Integer> n41 = new GeneralTree<Integer>(35);
    GeneralTree<Integer> n42 = new GeneralTree<Integer>(14);
    GeneralTree<Integer> n43 = new GeneralTree<Integer>(18);
    GeneralTree<Integer> n44 = new GeneralTree<Integer>(33);

    GeneralTree<Integer> n51 = new GeneralTree<Integer>(35);
    GeneralTree<Integer> n52 = new GeneralTree<Integer>(35);
    GeneralTree<Integer> n53 = new GeneralTree<Integer>(83);
    GeneralTree<Integer> n54 = new GeneralTree<Integer>(90);
    GeneralTree<Integer> n55 = new GeneralTree<Integer>(33);

    n41.addChild(n51);

    n44.addChild(n52);
    n44.addChild(n53);
    n44.addChild(n54);
    n44.addChild(n55);
    
    n31.addChild(n41);
    n32.addChild(n42);
    n32.addChild(n43);
    n32.addChild(n44);
    
    n21.addChild(n31);
    n21.addChild(n32);
    
    n22.addChild(n33);
    
    padre.addChild(n21);
    padre.addChild(n22);

    System.out.print("¿El arbol dado es de selección? " + (esDeSeleccion(padre) ? "Si." : "No."));

  }

}
