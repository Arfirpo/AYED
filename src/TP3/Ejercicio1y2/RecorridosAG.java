package TP3.Ejercicio1y2;

import java.util.LinkedList;
import java.util.List;

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

		List<Integer> resultado = recorrido.numerosImparesMayoresQuePreOrden(ag, 1);
		List<Integer> resultado2 = recorrido.numerosImparesMayoresQueInOrden(ag, 1);

		System.out.print("Pre Orden - Lista de numeros impares mayores que 22: ");
		resultado.forEach(num -> System.out.print(resultado.indexOf(num) < resultado.size() - 1 ? num + ", " : num + "."));
		System.out.println();
		System.out.print("In Orden - Lista de numeros impares mayores que 22: ");
		resultado2
				.forEach(num -> System.out.print(resultado2.indexOf(num) < resultado2.size() - 1 ? num + ", " : num + "."));
	}
}
