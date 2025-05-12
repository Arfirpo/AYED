package TP1.Ejercicio7;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ejercicio7incisioG {

	private static void calcularRecursivo(List<Integer> sucesion, int n) {
		sucesion.add(n);
		if (n > 1) {
			if (n % 2 == 0) calcularRecursivo(sucesion, n / 2);
			else calcularRecursivo(sucesion, 3 * n + 1);
		}
	}

	public static List<Integer> calcularSucesion(int n) {
		List<Integer> sucesion = new LinkedList<Integer>();
		calcularRecursivo(sucesion, n);
		return sucesion;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Ingrese un numero: ");
		List<Integer> sucesion = calcularSucesion(s.nextInt());
		s.close();
		System.out.println();
		System.out.println("Sucesión Numerica obtenida");
		
		int size = sucesion.size();
		for (int i = 0; i < size; i++) {
			System.out.print(sucesion.get(i) + (i < size -1 ? " » " : "."));
		}
	}
}
