package Practica1.Ejercicio7;

import java.util.LinkedList;
import java.util.Scanner;

public class ejercicio7incisoI {

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

  public static void main(String[] args) {
    LinkedList<Integer> lista = new LinkedList<Integer>();
    Scanner s = new Scanner(System.in);
    cargarLista(lista, s);
    s.close();
    System.out.println("Lista de numeros");
    imprimirLista(lista);
    System.out.println();
    System.out.println("La suma de los numeros de la lista es: " + sumarLinkedList(lista));
  }
}
