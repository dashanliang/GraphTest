package com.test.data;


public class Node {

	public Node() {
	}

	public Node(String key, double[][] dataGraph, String cost) {
		this.key = key;
		this.dataGraph = dataGraph;
		this.cost = cost;
	}

	private String key;

	private double[][] dataGraph;

	private String cost;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public double[][] getDataGraph() {
		return dataGraph;
	}

	public void setDataGraph(double[][] dataGraph) {
		this.dataGraph = dataGraph;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
}