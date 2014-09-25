package heap;

import java.util.ArrayList;
import java.util.List;

import binarytree.BinaryTree;

public class Heap extends BinaryTree {
	
	private List<Integer> heapArray = new ArrayList<>();
	private List<HeapVertex> vertexArray = new ArrayList<>();
	private int heapSize;
	
	public Heap(List<Integer> heapArray){
		this.heapArray = heapArray;
		for(int i = 0; i < heapArray.size(); i++){
			HeapVertex vertex = new HeapVertex(heapArray.get(i), i);
			vertexArray.add(vertex);
		}
		root = vertexArray.get(0);
		for(int j = 0; j < vertexArray.size(); j++){
			if(Math.floor((j-1/2)) > 0){
				vertexArray.get(j).setParent(vertexArray.get((int) Math.floor((j-1/2))));
			}
			if((2*j + 1) < vertexArray.size()){
				vertexArray.get(j).setLeftChild(vertexArray.get((2*j + 1)));
			}
			if((2*j + 2) < vertexArray.size()){
				vertexArray.get(j).setRightChild(vertexArray.get((2*j + 2)));
			}
		}
	}

	private void maxHeapify(int i) {
		int largest = i;
		if((2*i + 1) <= heapSize && heapArray.get((2*i + 1)) > heapArray.get(i)){
			largest = 2*i + 1;
		}
		if((2*i + 2) <= heapSize && heapArray.get((2*i + 2)) > heapArray.get(largest)){
			largest = 2*i + 2;
		}
		if(largest != i){
			swap(i, largest);
			maxHeapify(largest);
		}
	}
	
	private void swap(int i, int j) {
		int temp = heapArray.get(i);
		heapArray.set(i, heapArray.get(j));
		heapArray.set(j, temp);
		
		HeapVertex tempVertex = vertexArray.get(i);
		
		vertexArray.get(i).setParent(vertexArray.get(j).getParent());
		vertexArray.get(i).setLeftChild(vertexArray.get(j).getLeftChild());
		vertexArray.get(i).setRightChild(vertexArray.get(j).getRightChild());
		vertexArray.get(i).setIndex(vertexArray.get(j).getIndex());
		vertexArray.get(j).setParent(tempVertex.getParent());
		vertexArray.get(j).setLeftChild(tempVertex.getLeftChild());
		vertexArray.get(j).setRightChild(tempVertex.getRightChild());
		vertexArray.get(j).setIndex(tempVertex.getIndex());
		
		vertexArray.set(i, vertexArray.get(j));
		vertexArray.set(j, tempVertex);
	}

	private void buildMaxHeap(){
		heapSize = heapArray.size()-1;
		for(int i = heapSize; i >= 0; i--){
			maxHeapify(i);
		}
	}
	
	public void heapSort(){
		buildMaxHeap();
		for(int i = heapSize; i > 0; i--){
			swap(0, i);
			heapSize--;
			maxHeapify(0);
		}
		printHeapArray();
	}

	private void printHeapArray() {
		System.out.println();
		for(int i = 0; i < heapArray.size(); i++){
			System.out.print(heapArray.get(i)+ " ");
		}
		System.out.println();
	}
}
