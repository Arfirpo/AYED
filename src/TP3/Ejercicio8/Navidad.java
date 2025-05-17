package TP3.Ejercicio8;

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

  public String esAbeto() {
    return "";
  }
}
