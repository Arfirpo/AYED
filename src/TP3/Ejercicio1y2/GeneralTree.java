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
		return 0;
	}

	public int ancho() {

		return 0;
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
}
