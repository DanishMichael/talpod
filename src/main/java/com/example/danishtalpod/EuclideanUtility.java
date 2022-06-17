package com.example.danishtalpod;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class EuclideanUtility {

	/**
	 * 
	 * @param ins(list of edges going inside a node)
	 * @param outs(list of edges going outside a node)
	 * @return (returns a Euclidean object with start/end node and a boolean variable
	 * which stores if the graph contains a Euclidean path
	 *
	 * checks if the graph contains a Euclidean path by comparing all ins and outs from the nodes
	 */
	
	public Euclidean checkEuclidean(List<Integer>ins, List<Integer>outs)
	{
		int totalNegatives = 0;
		int totalPositives = 0;
		int startLocationCode = 0;
		int endLocationCode = 0;
		Euclidean euclidean = new Euclidean(startLocationCode, endLocationCode, false);
		for(int i=0; i<ins.size(); i++)
		{
			int difference = ins.get(i)-outs.get(i);
			if(difference>1)
				return euclidean;
			else if (difference<-1)
				return euclidean;
			else if(difference == -1)
			{
				totalNegatives = totalNegatives+1;
				startLocationCode = i;
				euclidean.setStartLocationCode(startLocationCode);
			}
			else if(difference == 1)
			{
				totalPositives = totalPositives+1;
				endLocationCode = i;
				euclidean.setEndLocationCode(endLocationCode);
			}
				
		}
		if(totalNegatives !=1 || totalPositives !=1)
			return euclidean;
		euclidean.setEuclidean(true);
		return euclidean;
	}
	
	/**
	 * 
	 * @param node : the current node/source
	 * @param g : the graph
	 * @param edgeStack: list of edges which have been traversed
	 * @param nodeStack: list of nodes which have been traversed
	 * @param locationsMap: the map which maps a locationCode to a string location
	 * @param result: sorted boarding cards
	 * @return
	 * 
	 * an enhanced DFS algorithm which rolls back if the all the edges corresponding to the
	 * current node have been visited and hence continues to traverse the remaining edges
	 */
	public List<BoardingCard> dfs(int node, Graph g, List<BoardingCard> edgeStack, List<Integer> nodeStack, Map<String, Integer> locationsMap, List<BoardingCard> result)
	{
		List<BoardingCard> neigbours = g.getNeighbours(node);
		if(neigbours.size()>0)
		{
			BoardingCard neighbour = neigbours.remove(0);
			edgeStack.add(neighbour);
			int dest = locationsMap.get(neighbour.getDestination());
			nodeStack.add(dest);
			dfs(dest, g, edgeStack, nodeStack, locationsMap, result);
		}
		else if(!edgeStack.isEmpty())
		{
			result.add(edgeStack.remove(edgeStack.size()-1));
			nodeStack.remove(nodeStack.size()-1);
			dfs(nodeStack.get(nodeStack.size()-1), g, edgeStack, nodeStack, locationsMap, result);
		}
		
		return result;
	}
}
