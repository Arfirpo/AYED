package TP3.Ejercicio6;

import java.util.List;

import TP3.Ejercicio1y2.GeneralTree;

public class RedDeAguaPotable {
  private GeneralTree<Character> red;

  public RedDeAguaPotable() {
    this.red = new GeneralTree<Character>();
  }

  public RedDeAguaPotable(Character c) {
    this.red = new GeneralTree<Character>(c);
  }

  public void setRed(GeneralTree<Character> red) {
    this.red = red;
  }

  public GeneralTree<Character> getRed() {
    return red;
  }

  public double minimoCaudal(double caudal) {
    if (this.red == null || this.red.isEmpty())
      return 0.00;

    if (this.red.isLeaf())
      return caudal;

    double minCaudal = Double.MAX_VALUE;
    List<GeneralTree<Character>> children = this.red.getChildren();
    int caños = children.size();
    for (GeneralTree<Character> child : children) {
      double minChild = minimoCaudalRec(child, caudal / caños);
      if (minChild < minCaudal)
        minCaudal = minChild;
    }
    return minCaudal;
  }

  private double minimoCaudalRec(GeneralTree<Character> nodo, double caudal) {
    if (nodo == null || nodo.isEmpty())
      return 0.00;
    if (nodo.isLeaf())
      return caudal;
    List<GeneralTree<Character>> children = nodo.getChildren();
    int caños = children.size();
    double minCaudal = Double.MAX_VALUE;
    for (GeneralTree<Character> child : children) {
      double minChild = minimoCaudalRec(child, caudal / caños);
      if (minChild < minCaudal)
        minCaudal = minChild;
    }
    return minCaudal;
  }

}
