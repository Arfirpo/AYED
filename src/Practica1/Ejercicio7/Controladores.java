package Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Controladores {

  public static LinkedList<Integer> cargarLista(LinkedList<Integer> lista, Scanner s) {
    System.out.print("¿De que tamaño sera la lista? ");
    int n = s.nextInt();
    for (int i = 0; i < n; i++) {
      System.out.print("Ingrese un numero: ");
      lista.add(s.nextInt());
    }
    return lista;
  }

  private static int sumarRecursivo(LinkedList<Integer> lista, int index, int suma) {
    if (index < 0) {
      return 0;
    } else {
      suma = lista.get(index) + sumarRecursivo(lista, index - 1, suma);
    }
    return suma;
  }

  public static int sumarLinkedList(LinkedList<Integer> lista) {
    int suma = 0;
    suma += sumarRecursivo(lista, lista.size() - 1, suma);
    return suma;
  }

  public static void imprimirLista(LinkedList<Integer> lista) {
    int size = lista.size();
    for (int i = 0; i < size; i++) {
      System.out.print(lista.get(i) + (i < size - 1 ? " » " : "."));
    }
  }

  public static ArrayList<Integer> cargarArray(ArrayList<Integer> array, Scanner s) {
    for (int i = 0; i < 10; i++) {
      System.out.print("Ingrese un número: ");
      array.add(s.nextInt());
    }
    return array;
  }

  public static void imprimirArrayList(ArrayList<Integer> lista) {
    Integer size = lista.size();
    for (int i = 0; i < size; i++) {
      System.out.print(lista.get(i) + (i < size - 1 ? " » " : "."));
    }
    System.out.println();
  }

  private static void invertirRecursivo(ArrayList<Integer> lista, int posIni, int posFin) {
    if (posIni < posFin) {
      int item = lista.get(posFin);
      lista.set(posFin, lista.get(posIni));
      lista.set(posIni, item);
      invertirRecursivo(lista, posIni + 1, posFin - 1);
    }
  }

  public static void invertirArrayList(ArrayList<Integer> lista) {
    int posIni, posFin;
    posIni = 0;
    posFin = lista.size() - 1;
    invertirRecursivo(lista, posIni, posFin);
    System.out.println("***Array Invertido***");
    imprimirArrayList(lista);
  }

  private static void calcularRecursivo(List<Integer> sucesion, int n) {
    sucesion.add(n);
    if (n > 1) {
      if (n % 2 == 0)
        calcularRecursivo(sucesion, n / 2);
      else
        calcularRecursivo(sucesion, 3 * n + 1);
    }
  }

  public static List<Integer> calcularSucesion(int n) {
    List<Integer> sucesion = new LinkedList<Integer>();
    calcularRecursivo(sucesion, n);
    return sucesion;
  }

  public static ArrayList<Integer> ordenarArray(ArrayList<Integer> array) {
    int item, pos;
    for (int i = 0; i < array.size() - 1; i++) {
      pos = i;
      for (int j = i + 1; j < array.size(); j++) {
        if (array.get(j) < array.get(pos))
          pos = j;
      }
      item = array.get(pos);
      array.set(pos, array.get(i));
      array.set(i, item);
    }
    return array;
  }

  public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> array1, ArrayList<Integer> array2) {
    ArrayList<Integer> arrayCombinado = new ArrayList<Integer>();
    //codigo
    return arrayCombinado;
  }
}
