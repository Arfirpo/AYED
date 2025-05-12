package TP1.Ejercicio7;

import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio7incisoH {

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

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> array = new ArrayList<Integer>();
		cargarArray(array, s);
		s.close();
		System.out.println("***Array original***");
		imprimirArrayList(array);
		invertirArrayList(array);
	}

}
