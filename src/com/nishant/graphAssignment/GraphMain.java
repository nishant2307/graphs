package com.nishant.graphAssignment;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class GraphMain {

	public static void main(String[] args) {
		GraphImpl gImpl = new GraphImpl(5);
		GraphImpl.addEdge(gImpl, 0, 1);
		GraphImpl.addEdge(gImpl, 0, 2);
		GraphImpl.addEdge(gImpl, 1, 3);
		GraphImpl.addEdge(gImpl, 2, 4);
		GraphImpl.addEdge(gImpl, 0, 0);
		//System.out.println("Done");
		if(GraphUtil.isSimple(gImpl, 0, 1)) {
		System.out.println("It is a simple graph");
		}
		else {
			System.out.println("Not a simple graph");
		}
		if(GraphUtil.isSimpleAndConnected(gImpl, 0, 4)) {
			System.out.println("Is connected");
		}
		else {
			System.out.println("Is not connected");
		}
	}
}
