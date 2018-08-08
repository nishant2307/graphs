package com.nishant.graphAssignment;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class GraphUtil implements Graph{
	private int vertexCount;
	private LinkedList<Integer> vertexs[];
	
	public GraphUtil(int vertexCount) {
		this.vertexCount = vertexCount;
		this.vertexs = new LinkedList[this.vertexCount];
		for (int index = 0; index < this.vertexCount; index++) {
			this.vertexs[index] = new LinkedList<Integer>();
		}
	}

	@Override
	public int vertexCount() {
		// TODO Auto-generated method stub
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

	public static boolean addEdge(Graph graph, int fromVertex, int toVertex) {
		
		if (((GraphUtil)graph).validateVertexes(fromVertex, toVertex)) {
			((GraphUtil)graph).vertexs[fromVertex].add(toVertex);
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

    /**
     * A Graph g is considered simple if and only if the following
     * Conditions apply:
     * For all integer x, !g.existsEdge(x, x) [No self-loops!]
     * For all integer pairs (x,y), g.existsEdge(x,y) if and only if g.existsEdge(y,x). [Undirected graph!]
     */
    public static boolean isSimple(Graph g) {
    	//Modified code
    	for(int index = 0;index<((GraphUtil)g).vertexs.length;index++) {
    			if(g.neighbors(index).contains(index)) {
    				return false;
    			}
    	}
        return true;
    }


    /**
     * A Graph g is considered â€œconnectedâ€? (or â€œstrongly connectedâ€?) if
     * and only if for every pair of vertices (x, y), there is a â€œpathâ€?
     * from vertex x to vertex y. A â€œpathâ€? from a vertex x to vertex y
     * Is a sequence of vertices starting with x as the first element
     * of the sequence and y as the last element, e.g. (x, v1, v2, .. y)
     * such that for every adjacent ordered pair of vertices (v, w) in
     * the sequence, we can assert g.existsEdge(v, w).
     * <p>
     * For a graph g to pass this test, it must be both â€œsimpleâ€?
     * (as defined for the previous method) and â€œconnectedâ€?.
     */
    public static boolean isSimpleAndConnected(Graph g) {
        return breadthFirstTraversal(g);
    }

    private static boolean breadthFirstTraversal(Graph g) {
    	if(!isSimple(g)) {
    		return false;
    	}
    	//New condition
    	for(int index = 0;index<((GraphUtil)g).vertexs.length;index++) {
			if(((GraphUtil)g).vertexs[index].size() == 0) {
				return false;
			}
	    }
    	
    	int startElement = 0;
    	int endElement = ((GraphUtil)g).getVertexs().length-1;
        boolean visited[] = new boolean[g.vertexCount()];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[startElement] = true;
        queue.add(startElement);

        while (queue.size() != 0) {
            startElement = queue.poll();
            Iterator<Integer> iterator =(((GraphUtil)g).getVertexs())[startElement].listIterator();
            while (iterator.hasNext()) {
                int currentElemnt = iterator.next();
                if (currentElemnt == endElement) {
                	//System.out.println("Visiting current:"+currentElemnt);
                    return true;
                }
                if (!visited[currentElemnt]) {
                	//System.out.println("1st Visiting current:"+currentElemnt);
                    visited[currentElemnt] = true;
                    queue.add(currentElemnt);
                }
            }
        }
        return false;
    }

}
