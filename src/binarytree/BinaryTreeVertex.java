package binarytree;

import graph.Vertex;

public class BinaryTreeVertex extends Vertex{
	
	private BinaryTreeVertex leftChild = null;
	private BinaryTreeVertex rightChild = null;
	private BinaryTreeVertex parent = null;
	
	public BinaryTreeVertex(int value) {
		super(value);
	}

	public BinaryTreeVertex getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeVertex leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTreeVertex getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeVertex rightChild) {
		this.rightChild = rightChild;
	}

	public BinaryTreeVertex getParent() {
		return parent;
	}

	public void setParent(BinaryTreeVertex parent) {
		this.parent = parent;
	}
	
}
