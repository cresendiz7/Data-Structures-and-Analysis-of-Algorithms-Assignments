package weeklyAssignments;

import java.util.LinkedList;
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
	
	public void topologicalSort()
	{
		LinkedList<Vertex> q = new LinkedList<Vertex>();
		int size = graph.size();
		int counter = 0;
		String[] sortedList = new String[size];
		for(Map.Entry<String, Vertex> vertex : graph.entrySet())
			if(vertex.getValue().indegree == 0 )
				q.add(vertex.getValue());
		while(!q.isEmpty())
		{
			sortedList[counter++] = q.peek().vertex;
			Vertex v = q.removeFirst();
			for(Map.Entry<String, Integer> vertex : v.adjacent.entrySet())
			{
				Vertex w = graph.get(vertex.getKey());
				w.indegree--;
				if(w.indegree == 0)
					q.add(w);
			}
		}
		for (int i = 0; i < sortedList.length; i++)
			System.out.println(sortedList[i]);
	}
}
