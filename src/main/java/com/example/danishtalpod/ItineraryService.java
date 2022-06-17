package com.example.danishtalpod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItineraryService {

	@Autowired EuclideanUtility eucUtil;
	private Map<String, Integer> locationsMap;
	private List<Integer> ins;
	private List<Integer> outs;
	private Graph graph;
	private List<BoardingCard> result;
	
	/**
	 * 
	 * @param cards: list of boarding cards
	 * @return: returns the sorted list of boarding cards
	 * 
	 * creates an itinerary by sorting the list of input boarding cards using Euclidean algo.
	 */
	public List<BoardingCard> createItinerary(List<BoardingCard> cards)
	{
		locationsMap = new HashMap<String,Integer>();
		int locationCode = 0;
		for(BoardingCard card : cards)
		{
			if(!locationsMap.containsKey(card.getSource()))
			{
				locationsMap.put(card.getSource(), locationCode);
				locationCode++;
			}
			if(!locationsMap.containsKey(card.getDestination()))
			{
				locationsMap.put(card.getDestination(), locationCode);
				locationCode++;
			}	
		}
		int totalLocations = locationsMap.size();
		
		//list of edges going inside a node
		ins = new ArrayList<Integer>();
		for(int i=0; i<totalLocations; i++)
		{
			ins.add(0);
		}
		//list of edges going outside a node
		outs = new ArrayList<Integer>();
		for(int i=0; i<totalLocations; i++)
		{
			outs.add(0);
		}
		
		graph = new Graph(totalLocations);
		
		for(BoardingCard card : cards)
		{
			int sourceLocationCode = locationsMap.get(card.getSource());
			int destinationLocationCode = locationsMap.get(card.getDestination());
			
			int in = ins.get(destinationLocationCode);
			ins.set(destinationLocationCode, in+1);
			
			int out = outs.get(sourceLocationCode);
			outs.set(sourceLocationCode, out+1);
			
			graph.addEdge(sourceLocationCode, card);
		}
		
		Euclidean euclidean = eucUtil.checkEuclidean(ins, outs);
		if(euclidean.isEuclidean)
		{
			result = getPath(graph, euclidean.getStartLocationCode(), euclidean.getEndLocationCode(), locationsMap);
			Collections.reverse(result);
		}
		return result;
	}
	
	public List<BoardingCard> getPath(Graph g, int startLocationCode, int endLocationCode, Map<String, Integer> locationsMap)
	{
		List<BoardingCard> edgeStack = new ArrayList<BoardingCard>();
		List<Integer> nodeStack = new ArrayList<Integer>();
		result = new ArrayList<BoardingCard>();
		nodeStack.add(startLocationCode);
		result = eucUtil.dfs(startLocationCode, g, edgeStack, nodeStack,locationsMap, new ArrayList<BoardingCard>());
		return result;
	}
}
