package TP2.Ejercicio1y2;

import TP1.Ejercicio8.Queue;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;

	// constructores
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	// metodos

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTree<T> getLeftChild() {
		return this.leftChild;
	}

	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> ab) {
		this.leftChild = ab;
	}

	public void addRightChild(BinaryTree<T> ab) {
		this.rightChild = ab;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean hasLeftChild() {
		return this.leftChild != null;
	}

	public boolean hasRightChild() {
		return this.rightChild != null;
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());
	}

	public boolean isEmpty() {
		return (this.isLeaf() && this.getData() == null);
	}

	@Override
	public String toString() {
		return this.getData().toString();
	}

	public int contarHojas() {
		int leftLeafs = 0;
		int rightLeafs = 0;

		if (this.isEmpty())
			return 0;

		else if (this.isLeaf())
			return 1;

		else {
			if (this.hasLeftChild())
				leftLeafs = this.getLeftChild().contarHojas();
			if (this.hasRightChild())
				rightLeafs = this.getRightChild().contarHojas();
			return leftLeafs + rightLeafs;
		}
	}

	public BinaryTree<T> espejo() {
		BinaryTree<T> abEspejo = new BinaryTree<T>(this.getData());
		if (this.hasLeftChild())
			abEspejo.addRightChild(this.getLeftChild());
		if (this.hasRightChild())
			abEspejo.addLeftChild(this.getRightChild());
		return abEspejo;
	}

	// recorrido preorden
	public void imprimirPreOrden() {
		System.out.println(this.getData());
		if (this.hasLeftChild())
			this.getLeftChild().imprimirPreOrden();
		if (this.hasRightChild())
			this.getRightChild().imprimirPreOrden();
	}

	// recorrido inOrden
	public void imprimirInOrden() {
		if (this.hasLeftChild())
			this.getLeftChild().imprimirInOrden();
		System.out.println(this.getData());
		if (this.hasRightChild())
			this.getRightChild().imprimirInOrden();
	}

	// recorrido postOrden
	public void imprimirPostOrden() {
		if (this.hasLeftChild())
			this.getLeftChild().imprimirInOrden();
		if (this.hasRightChild())
			this.getRightChild().imprimirInOrden();
		System.out.println(this.getData());
	}

	// recorrido por niveles
	public void imprimirEntreNiveles(int n, int m) {
		if (this.isEmpty() || n < 0 || m < n)
			return;
		BinaryTree<T> nodoActual = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		int nivelActual = 0;
		cola.enqueue(this); // encolo la raiz
		cola.enqueue(null); // encolo null (marcando el fin del nivel 0)
		while (!cola.isEmpty()) {
			nodoActual = cola.dequeue();
			if (nodoActual != null) {
				if (nivelActual >= n && nivelActual <= m) { // si estamos dentro del rango buscado
					System.out.println(nodoActual.getData() + " | ");
				}
				if (nodoActual.hasLeftChild()) {
					cola.enqueue(nodoActual.getLeftChild());
				}
				if (nodoActual.hasRightChild()) {
					cola.enqueue(nodoActual.getRightChild());
				}
			} else if (!cola.isEmpty()) {
				System.out.println();
				nivelActual++;
				cola.enqueue(null); // marco el fin del nivel
			} else {
				nivelActual++;
			}
		}
	}
}
