package TP3.Ejercicio1y2;

import java.util.LinkedList;
import java.util.List;

import TP1.Ejercicio8.Queue;

public class RecorridosAG {

	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> arbol, Integer n) {
		if (arbol == null || arbol.isEmpty())
			return new LinkedList<Integer>();
		List<Integer> resultado = new LinkedList<Integer>();
		preOrden(arbol, resultado, n);
		return resultado;
	}

	private void preOrden(GeneralTree<Integer> nodo, List<Integer> lista, Integer n) {
		if (nodo == null || nodo.isEmpty())
			return;
		if ((nodo.getData() % 2 != 0) && (nodo.getData() > n))
			lista.add(nodo.getData());
		List<GeneralTree<Integer>> children = nodo.getChildren();
		if (!children.isEmpty()) {
			children.forEach(child -> preOrden(child, lista, n));
		}
	}

	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> arbol, Integer n) {
		if (arbol == null || arbol.isEmpty())
			return new LinkedList<Integer>();
		List<Integer> resultado = new LinkedList<Integer>();
		inOrden(arbol, resultado, n);
		return resultado;
	}

	private void inOrden(GeneralTree<Integer> nodo, List<Integer> lista, Integer n) {
		if (nodo == null || nodo.isEmpty())
			return;

		List<GeneralTree<Integer>> children = nodo.getChildren();
		if (!children.isEmpty())
			inOrden(children.get(0), lista, n);

		if ((nodo.getData() % 2 != 0) && (nodo.getData() > n))
			lista.add(nodo.getData());

		if (children.size() > 1) {
			for (int i = 1; i < children.size(); i++) {
				inOrden(children.get(i), lista, n);
			}
		}
	}

	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> arbol, Integer n) {
		if (arbol == null || arbol.isEmpty())
			return new LinkedList<Integer>();
		List<Integer> resultado = new LinkedList<Integer>();
		postOrden(arbol, resultado, n);
		return resultado;
	}

	private void postOrden(GeneralTree<Integer> nodo, List<Integer> lista, Integer n) {
		if (nodo == null || nodo.isEmpty())
			return;

		List<GeneralTree<Integer>> children = nodo.getChildren();
		if (!children.isEmpty())
			children.forEach(child -> postOrden(child, lista, n));

		if ((nodo.getData() % 2 != 0) && (nodo.getData() > n))
			lista.add(nodo.getData());
	}

	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> arbol, Integer n) {
		if (arbol == null || arbol.isEmpty())
			return new LinkedList<Integer>();
		List<Integer> lista = new LinkedList<Integer>();
		porNiveles(arbol, lista, n);
		return lista;
	}

	private void porNiveles(GeneralTree<Integer> nodo, List<Integer> lista, Integer n) {
		if (nodo == null || nodo.isEmpty())
			return;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(nodo);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			GeneralTree<Integer> nodoActual = cola.dequeue();
			if (nodoActual != null) {
				if ((nodoActual.getData() % 2 == 1) && (nodoActual.getData() > n))
					lista.add(nodoActual.getData());
				List<GeneralTree<Integer>> children = nodoActual.getChildren();
				if (!children.isEmpty()) {
					children.forEach(child -> cola.enqueue(child));
				}
			} else if (!cola.isEmpty()) {
				cola.enqueue(null);
			}
		}
	}

	public static void main(String[] args) {

		GeneralTree<Integer> ag1 = new GeneralTree<Integer>(1);

		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(21));
		children2.add(new GeneralTree<Integer>(22));
		children2.add(new GeneralTree<Integer>(23));
		GeneralTree<Integer> ag2 = new GeneralTree<Integer>(2, children2);

		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(31));
		children3.add(new GeneralTree<Integer>(32));
		GeneralTree<Integer> ag3 = new GeneralTree<Integer>(3, children3);

		List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
		children.add(ag1);
		children.add(ag2);
		children.add(ag3);

		GeneralTree<Integer> ag = new GeneralTree<Integer>(0, children);

		RecorridosAG recorrido = new RecorridosAG();

		List<Integer> res1 = recorrido.numerosImparesMayoresQuePreOrden(ag, 1);
		List<Integer> res2 = recorrido.numerosImparesMayoresQueInOrden(ag, 1);
		List<Integer> res3 = recorrido.numerosImparesMayoresQuePostOrden(ag, 1);
		List<Integer> res4 = recorrido.numerosImparesMayoresQuePorNiveles(ag, 1);

		// Recorridos con condicion.
		System.out.print("Pre Orden - Lista de numeros impares mayores que 1: ");
		res1.forEach(num -> System.out.print(res1.indexOf(num) < res1.size() - 1 ? num + ", " : num + "."));
		System.out.println();
		System.out.print("In Orden - Lista de numeros impares mayores que 1: ");
		res2.forEach(num -> System.out.print(res2.indexOf(num) < res2.size() - 1 ? num + ", " : num + "."));
		System.out.println();
		System.out.print("Post Orden - Lista de numeros impares mayores que 1: ");
		res3.forEach(num -> System.out.print(res3.indexOf(num) < res3.size() - 1 ? num + ", " : num + "."));
		System.out.println();
		System.out.print("Por Niveles - Lista de numeros impares mayores que 1: ");
		res4.forEach(num -> System.out.print(res4.indexOf(num) < res4.size() - 1 ? num + ", " : num + "."));

		System.out.println();
		System.out.println();

		// Recorridos sin condicion.
		System.out.print("Impresion de arbol General (sin condicion) - Pre Orden: ");
		ag.imprimirArbolPreOrden();
		System.out.println();
		System.out.print("Impresion de arbol General (sin condicion) - In Orden: ");
		ag.imprimirArbolInOrden();
		System.out.println();
		System.out.print("Impresion de arbol General (sin condicion) - Post Orden: ");
		ag.imprimirArbolPostOrden();
		System.out.println();
		System.out.print("Impresion de arbol General (sin condicion) - Por Niveles: ");
		ag.imprimirArbolPorNiveles();
	}
}
