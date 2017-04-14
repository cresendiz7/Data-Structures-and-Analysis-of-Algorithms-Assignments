package inClassAssignments.chapter9;

import java.util.Map;
import java.util.TreeMap;

public class Graph {
	//Map<String Vertex>
	public TreeMap<String, Vertex> graph;
	//constructor
	public Graph()
	{
		graph = new TreeMap<>();
	}
	//addEdge(vertex1, vertex2, weight)
	public void addEdge(String v1, String v2, int w)
	{
		//make sure vertices are in graph
		addVertex(v1);
		addVertex(v2);

		if(graph.get(v1).addEdge(v2, w))
			graph.get(v2).indegree++;
	}
	//addEdge(vertex1, vertex2)
	public void addEdge(String v1, String v2)
	{
		addEdge(v1, v2, 0);
	}
	//addVertex(vertex)
	public void addVertex(String v)
	{
		if(!graph.containsKey(v))
		{
			graph.put(v, new Vertex(v));
		}
	}
	//removeVertex(vertex)
	//helper method for topological sort, marked as private to prevent access
	private void removeVertex(String v)
	{
		if(!graph.containsKey(v))
		{
			//modify indegree of adjacent items
			//look at toString foreach as an example for walking through a TreeMap

			//remove vertex from graph
			graph.remove(v);
		}
	}
	public String toString()
	{
		if(graph.size() > 0)
		{
			String temp = "";
			for(Map.Entry<String, Vertex> vertex : graph.entrySet())
				temp += vertex.getValue() + "\n";
			return temp;
		}
		return "No Verticies";
	}
}
