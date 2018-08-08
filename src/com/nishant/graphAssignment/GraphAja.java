package com.nishant.graphAssignment;

import java.util.LinkedList;
import java.util.Set;

public class GraphAja implements Graph {
LinkedList<Integer> list[] = new LinkedList[4];
	@Override
	public int vertexCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsEdge(int fromVertex, int toVertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Integer> neighbors(int fromVertex) {
		// TODO Auto-generated method stub
		GraphUtil.isSimple(new GraphAja());
		return null;
	}

}
