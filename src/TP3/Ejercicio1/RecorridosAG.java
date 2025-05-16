package TP3.Ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class RecorridosAG {

  public List<Integer> numerosImparesMayoresQuePreorden(GeneralTree<Integer> a, Integer n) {
    if (a == null || a.isEmpty())
      return new LinkedList<Integer>();

    List<Integer> lista = new LinkedList<Integer>();
    preOrden(a, lista, n);
    return lista;
  }

  private void preOrden(GeneralTree<Integer> a, List<Integer> lista, Integer num) {
    if (a == null || a.isEmpty())
      return;

    if (((a.getData() % 2) != 0) && (a.getData() > num)) {
      lista.add(a.getData());
    }

    List<GeneralTree<Integer>> children = a.getChildren();
    for (GeneralTree<Integer> child : children) {
      preOrden(child, lista, num);
    }
  }

  public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n) {
    if (a == null || a.isEmpty())
      return new LinkedList<>();
    List<Integer> lista = new LinkedList<>();
    inOrden(a, lista, n);
    return lista;
  }

  private void inOrden(GeneralTree<Integer> a, List<Integer> lista, Integer num) {
    if (a == null || a.isEmpty())
      return;

    List<GeneralTree<Integer>> children = a.getChildren();

    // Paso 1: recorrer el primer hijo si existe
    if (!children.isEmpty()) {
      inOrden(children.get(0), lista, num);
    }

    // Paso 2: visitar el nodo padre
    if ((a.getData() % 2 != 0) && (a.getData() > num)) {
      lista.add(a.getData());
    }

    // Paso 3: recorrer el resto de los hijos (desde el índice 1 en adelante)
    for (int i = 1; i < children.size(); i++) {
      inOrden(children.get(i), lista, num);
    }
  }

  public static void main(String[] args) {
    GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);

    List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
    children2.add(new GeneralTree<Integer>(21));
    children2.add(new GeneralTree<Integer>(22));
    children2.add(new GeneralTree<Integer>(23));
    GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);

    List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
    children3.add(new GeneralTree<Integer>(31));
    children3.add(new GeneralTree<Integer>(32));
    GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);

    List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
    children.add(a1);
    children.add(a2);
    children.add(a3);
    GeneralTree<Integer> a = new GeneralTree<Integer>(0, children);

    RecorridosAG r = new RecorridosAG();

    List<Integer> resultado = r.numerosImparesMayoresQuePreorden(a, -1);

    System.out.println("Numeros Impares mayores que -1 : ");

    for (Integer integer : resultado) {
      System.out.println(integer);
    }

    System.out.println();

    List<Integer> resultado2 = r.numerosImparesMayoresQueInOrden(a, -1);

    System.out.println("Numeros impares mayores que -1: ");
    resultado2.forEach(res -> System.out.println(res));
  }
}