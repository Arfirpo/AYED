package Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio7incisoJ {
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    ArrayList<Integer> array1 = new ArrayList<Integer>();
    ArrayList<Integer> array2 = new ArrayList<Integer>();
    Controladores.cargarArray(array1, s);
    Controladores.cargarArray(array2, s);
    
  }
}
