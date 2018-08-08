package com.nishant.graphAssignment;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class GraphImpl implements Graph {
	private int vertexCount;
	private LinkedList<Integer> vertexs[];

	public GraphImpl(int vertexCount) {
		this.vertexCount = vertexCount;
		this.vertexs = new LinkedList[this.vertexCount];
		for (int index = 0; index < this.vertexCount; index++) {
			this.vertexs[index] = new LinkedList<Integer>();
		}
	}

	public void setVertexs(LinkedList<Integer>[] vertexs) {
		this.vertexs = vertexs;
	}

	@Override
	public int vertexCount() {
		return this.vertexCount;
	}

	@Override
	public boolean existsEdge(int fromVertex, int toVertex) {
		if (this.validateVertexes(fromVertex, toVertex)) {
			//System.out.println("In here");
			Set<Integer> neighbourVertexes = this.neighbors(fromVertex);
			for (int vertex : neighbourVertexes) {
				if (vertex == toVertex) {
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public Set<Integer> neighbors(int fromVertex) {
		Set<Integer> neighbourVertexes = new HashSet<>();
		//System.out.println("from neighbours");
		//System.out.println(this.vertexs[fromVertex]);
		for (int neighbourVertex : this.vertexs[fromVertex]) {
			//System.out.println(neighbourVertex);
			neighbourVertexes.add(neighbourVertex);
		}
		return neighbourVertexes;
	}

	public static boolean addEdge(GraphImpl graph, int fromVertex, int toVertex) {
	
			if (graph.validateVertexes(fromVertex, toVertex)) {
				graph.vertexs[fromVertex].add(toVertex);
				return true;
		}
		return false;
	}
 
	public boolean validateVertexes(int... vertexes) {
		for (int vertex : vertexes) {
			if (!(vertex >= 0 && vertex < this.vertexCount)) {
				return false;
			}
		}
		return true;
	}

	public LinkedList<Integer>[] getVertexs() {
		return vertexs;
	}
}
