package com.example.danishtalpod;

import java.util.ArrayList;
import java.util.List;


public class Graph {

	private ArrayList<ArrayList<BoardingCard>> graph;
	private int V;
	
	public Graph(int nodes)
	{
		V = nodes;
		graph = new ArrayList<ArrayList<BoardingCard>>();
		for(int i=0; i<V; i++)
		{
			graph.add(new ArrayList<BoardingCard>());
		}
	}
	
	public List<BoardingCard> getNeighbours(int source)
	{
		return graph.get(source);
	}
	
	public void addEdge(int source, BoardingCard card)
	{
		graph.get(source).add(card);
	}
	
	public void deleteEdge(int source, int destination)
	{
		graph.get(source).remove(destination);
	}
}
