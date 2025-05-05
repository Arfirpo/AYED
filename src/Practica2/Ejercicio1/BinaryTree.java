package Practica2.Ejercicio1;

import Practica1.Ejercicio8.Queue;

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

	// recorrido por niveles
	public void imprimirEntreNiveles(int n, int m) {
		if (this.isEmpty() || n < 0 || m < n)
			return;
		BinaryTree<T> ab = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		int nivelActual = 0;
		cola.enqueue(this);  //encolo la raiz
		cola.enqueue(null); //encolo null (marcando el fin del nivel 0)
		while (!cola.isEmpty()) {
			int nodoNivel = cola.size();
			if (nivelActual >= n && nivelActual <= m) {
				for (int i = 0; i < nodoNivel; i++) {
					ab = cola.dequeue();
					System.out.println(ab.getData() + " | ");
					if (ab.hasLeftChild()) {
						cola.enqueue(ab.getLeftChild());
					}
					if (ab.hasRightChild()) {
						cola.enqueue(ab.getRightChild());
					}
				}
			} else {
				for (int i = 0; i < nodoNivel; i++) {
					cola.dequeue();
				}
			}
			nivelActual++;
			System.out.println("");
		}
	}

}
