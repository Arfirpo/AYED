package Practica2.Ejercicio1;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;

	//constructores
	public BinaryTree(){
		super();
	}

	public BinaryTree(T dato){
		this.data = dato;
		this.leftChild = null;
		this.rightChild = null;
	}


	//metodos

	public T getData(){
		return this.data;
	}

	public void setData(T dato){
		this.data = dato;
	}

	public BinaryTree<T> getLeftChild(){
		return this.leftChild;
	}

	public BinaryTree<T> getRightChild(){
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> ab){
		this.leftChild = ab;
	}

	public void addRightChild(BinaryTree<T> ab){
		this.rightChild = ab;
	}

	public void removeLeftChild(){
		this.leftChild = null;
	}

	public void removeRightChild(){
		this.rightChild = null;
	}

	public boolean hasLeftChild(){
		return this.leftChild != null;
	}

	public boolean hasRightChild(){
		return this.rightChild != null;
	}

	public boolean isLeaf(){
		return (!this.hasLeftChild() && !this.hasRightChild());
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}
}
