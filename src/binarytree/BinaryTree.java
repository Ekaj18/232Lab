package binarytree;

import graph.*;

public class BinaryTree extends Graph {
	
	protected BinaryTreeVertex root = null;;

	public BinaryTreeVertex getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeVertex root) {
		this.root = root;
	}
	
	public BinaryTreeVertex iterativeSearch(int value){
		BinaryTreeVertex vertex = root;
		while(vertex != null && vertex.getValue() != value){
			if(vertex.getValue() > value){
				vertex = vertex.getLeftChild();
			}
			else{
				vertex = vertex.getRightChild();
			}
		}
		return vertex;
	}
	
	public BinaryTreeVertex recursiveSearch(int value){
		return recursiveSearchLogic(value, root);
	}

	private BinaryTreeVertex recursiveSearchLogic(int value, BinaryTreeVertex vertex) {
		if(vertex == null || vertex.getValue() == value){
			return vertex;
		}
		else if(vertex.getValue() > value){
			return recursiveSearchLogic(value, vertex.getLeftChild());
		}
		else{
			return recursiveSearchLogic(value, vertex.getRightChild());
		}
	}
	
	public void insert(BinaryTreeVertex vertexToAdd){
		addVertex(vertexToAdd);
		BinaryTreeVertex curVertex = root;
		BinaryTreeVertex tempVertex = null;
		while(curVertex != null){
			tempVertex = curVertex;
			if(curVertex.getValue() > vertexToAdd.getValue()){
				curVertex = curVertex.getLeftChild();
			}
			else{
				curVertex = curVertex.getRightChild();
			}
		}
		vertexToAdd.setParent(tempVertex);
		if(tempVertex == null){
			root = tempVertex;
		}
		else if(tempVertex.getValue() > vertexToAdd.getValue()){
			tempVertex.setLeftChild(vertexToAdd);
		}
		else{
			tempVertex.setRightChild(vertexToAdd);
		}
	}
	
	public void transplant(BinaryTreeVertex vertex1, BinaryTreeVertex vertex2){
		if(vertex1.getParent() == null){
			root = vertex2;
		}
		else if(vertex1.getParent().getLeftChild() == vertex1){
			vertex1.getParent().setLeftChild(vertex2);
		}
		else{
			vertex1.getParent().setRightChild(vertex2);
		}
		if(vertex2 != null){
			vertex2.setParent(vertex1.getParent());
		}
	}
	
	public void delete(BinaryTreeVertex vertex){
		removeVertex(vertex);
		if(vertex.getLeftChild() == null){
			transplant(vertex, vertex.getRightChild());
		}
		else if(vertex.getRightChild()== null){
			transplant(vertex, vertex.getLeftChild());
		}
		else{
			BinaryTreeVertex tempVertex = vertex.getRightChild();
			while(tempVertex.getLeftChild() != null){
				tempVertex = tempVertex.getLeftChild();
			}
			if(tempVertex.getParent() != vertex){
				transplant(tempVertex, tempVertex.getRightChild());
				tempVertex.setRightChild(vertex.getRightChild());
				tempVertex.getRightChild().setParent(tempVertex);
			}
			transplant(vertex, tempVertex);
			tempVertex.setLeftChild(vertex.getLeftChild());
			tempVertex.getLeftChild().setParent(tempVertex);
		}
	}
	
	public void populateEdgeList(){
		clearEdgeList();
		traverseEdges(root);
	}

	private void traverseEdges(BinaryTreeVertex curVertex){
		if(curVertex.getLeftChild() != null){
			addEdge(new Edge(curVertex, curVertex.getLeftChild()));
			traverseEdges(curVertex.getLeftChild());
		}
		if(curVertex.getRightChild() != null){
			addEdge(new Edge(curVertex, curVertex.getRightChild()));
			traverseEdges(curVertex.getRightChild());
		}
	}
}
