package com.nishant.graphAssignment;

import java.util.LinkedList;
import java.util.Set;

public interface Graph {
    public int vertexCount();
    public boolean existsEdge(int fromVertex, int toVertex);
    public Set<Integer> neighbors(int fromVertex);
}
