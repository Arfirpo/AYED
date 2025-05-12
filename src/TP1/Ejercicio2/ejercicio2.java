package TP1.Ejercicio2;

import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el numero");
        int num = s.nextInt();
        int arreglo[] = Clase2.vectorMultiplosN(num);
        for (int i = 0; i < num; i++) {
            System.out.println(arreglo[i] + " | ");
        }
        s.close();
    }
}
