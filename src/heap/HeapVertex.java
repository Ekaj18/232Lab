package heap;

import binarytree.BinaryTreeVertex;

public class HeapVertex extends BinaryTreeVertex {
	
	private int index;
	public HeapVertex(int value, int index) {
		super(value);
		this.index = index;
	}
	
	@Override
	public String toString(){
		return "Vertex with value " + value + "and index " + index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
