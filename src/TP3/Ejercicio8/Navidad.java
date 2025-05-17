package TP3.Ejercicio8;

import java.util.List;

import TP3.Ejercicio1y2.GeneralTree;

/*
Considere un árbol general. Recordemos que el vértice u se llama hijo del vértice v y el vértice v se llama padre del vértice u si existe una arista dirigida de v a u. El árbol tiene un vértice distinguido llamado raíz, que es el único vértice que no tiene padre. Un vértice se llama hoja si no tiene hijos y tiene padre. Llamaremos abeto a un árbol si cada vértice no hoja tiene al menos 3 hijos hojas.
Dado un árbol general, compruebe si es un abeto.
 */

public class Navidad {
  private GeneralTree<Integer> abeto;

  public Navidad(GeneralTree<Integer> abeto) {
    this.abeto = abeto;
  }

  public void setAbeto(GeneralTree<Integer> abeto) {
    this.abeto = abeto;
  }

  public GeneralTree<Integer> getAbeto() {
    return abeto;
  }

  public String esAbetoNavideño() {
    if (this.abeto == null || this.abeto.isEmpty())
      return "No";
    if (this.abeto.isLeaf())
      return "No";
    return esAbetoNavideñoRec(this.abeto) ? "Si" : "No";
  }

  private boolean esAbetoNavideñoRec(GeneralTree<Integer> nodo) {

    if (nodo.isLeaf())
      return true;

    List<GeneralTree<Integer>> children = nodo.getChildren();
    int cHojas = 0;

    for (GeneralTree<Integer> child : children) {
      if (child.isLeaf())
        cHojas++;
    }
    if (cHojas < 3)
      return false;

    for (GeneralTree<Integer> child : children) {
      if (!child.isLeaf() && !esAbetoNavideñoRec(child))
        return false;
    }
    return true;
  }
}
