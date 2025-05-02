package Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio7incisoJ {
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    ArrayList<Integer> array1 = new ArrayList<Integer>();
    ArrayList<Integer> array2 = new ArrayList<Integer>();
    System.out.println("***Cargando Array 1***");
    Controladores.cargarArray(array1, s);
    System.out.println();
    System.out.println("***Cargando Array 2***");
    Controladores.cargarArray(array2, s);
    System.out.println();
    System.out.println("***Ordenando Array 1***");
    Controladores.ordenarArray(array1);
    System.out.println("***Ordenando Array 2***");
    Controladores.ordenarArray(array2);
    System.out.println();
    System.out.println("***Array 1***");
    Controladores.imprimirArrayList(array1);
    System.out.println();
    System.out.println("***Array 2***");
    Controladores.imprimirArrayList(array2);
    System.out.println();
    ArrayList<Integer> resultado = Controladores.combinarOrdenado(array1, array2);
    System.out.println("***Array Combinado***");
    Controladores.imprimirArrayList(resultado);
    System.out.println();
  }
}
