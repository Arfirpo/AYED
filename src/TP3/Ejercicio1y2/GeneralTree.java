package TP3.Ejercicio1y2;

import java.util.LinkedList;
import java.util.List;

import TP1.Ejercicio8.Queue;

public class GeneralTree<T> {

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

	public GeneralTree() {

	}

	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}

	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}

	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}

	public boolean hasChildren() {
		return !this.children.isEmpty();
	}

	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}

	public int altura() {
		if (this == null || this.isEmpty())
			return 0;
		return alturaRec(this);
	}

	private int alturaRec(GeneralTree<T> nodo) {
		if (nodo == null || nodo.isEmpty())
			return 0;
		List<GeneralTree<T>> children = nodo.getChildren();
		if (children.isEmpty())
			return 0;
		int maxAlt = 0;
		for (GeneralTree<T> child : children) {
			int altura = alturaRec(child);
			if (altura > maxAlt)
				maxAlt = altura;
		}
		return maxAlt + 1;
	}

	public int nivel(T dato) {
		if (this == null || this.isEmpty())
			return -1;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		boolean esta = false;
		int nivel = 0;
		while (!esta && !cola.isEmpty()) {
			GeneralTree<T> nodoActual = cola.dequeue();
			if (nodoActual != null) {
				esta = nodoActual.getData().equals(dato);
				if (!esta) {
					List<GeneralTree<T>> children = nodoActual.getChildren();
					if (!children.isEmpty()) {
						children.forEach(child -> cola.enqueue(child));
					}
				}
			} else if (!cola.isEmpty()) {
				nivel++;
				cola.enqueue(null);
			}
		}
		return (esta) ? nivel : -1;
	}

	public int ancho() {
		if (this == null || this.isEmpty())
			return 0;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		int maxAncho = 1;
		while (!cola.isEmpty()) {
			int anchoNivel = cola.size();
			if (anchoNivel > maxAncho)
				maxAncho = anchoNivel;
			for (int i = 0; i < anchoNivel; i++) {
				GeneralTree<T> nodoActual = cola.dequeue();
				List<GeneralTree<T>> children = nodoActual.getChildren();
				children.forEach(child -> cola.enqueue(child));
			}
		}
		return maxAncho;
	}

	public void imprimirArbolPreOrden() {
		if (this.getData() == null)
			return;
		System.out.print(this.getData() + " ");
		List<GeneralTree<T>> children = this.getChildren();
		if (!children.isEmpty()) {
			children.forEach(child -> child.imprimirArbolPreOrden());
		}
	}

	public void imprimirArbolInOrden() {
		if (this.getData() == null)
			return;
		List<GeneralTree<T>> children = this.getChildren();
		if (!children.isEmpty())
			children.get(0).imprimirArbolInOrden();
		System.out.print(this.getData() + " ");
		if (children.size() > 1)
			for (int i = 1; i < children.size(); i++) {
				children.get(i).imprimirArbolInOrden();
			}
	}

	public void imprimirArbolPostOrden() {
		if (this.getData() == null)
			return;
		List<GeneralTree<T>> children = this.getChildren();
		if (!children.isEmpty())
			children.forEach(child -> child.imprimirArbolPostOrden());
		System.out.print(this.getData() + " ");
	}

	public void imprimirArbolPorNiveles() {
		if (this == null || this.isEmpty())
			return;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			GeneralTree<T> nodoActual = cola.dequeue();
			if (nodoActual != null) {
				System.out.print(nodoActual.getData() + " ");
				List<GeneralTree<T>> children = nodoActual.getChildren();
				if (!children.isEmpty())
					children.forEach(child -> cola.enqueue(child));
			} else if (!cola.isEmpty())
				cola.enqueue(null);
		}
	}

	public boolean esAncestro(T a, T b) {
		return (this == null || this.isEmpty()) ? false : esAncestroRec(this, a, b);
	}

	private boolean esAncestroRec(GeneralTree<T> nodo, T a, T b) {
		if (nodo == null || nodo.isEmpty())
			return false;
		boolean estaA = false;
		boolean estaB;
		if (nodo.getData().equals(a)) {
			estaA = true;
			List<GeneralTree<T>> children = nodo.getChildren();
			estaB = false;
			int i = 0;
			while (!estaB && i < children.size()) {
				estaB = buscarB(children.get(i), b);
				i++;
			}

		}

		return estaA && estaB;
	}
}
