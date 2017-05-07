package weeklyAssignments;

import java.util.TreeMap;

public class Vertex {
	//vertex name
	public String vertex;
	//number of vertices that lead to this vertex
	public int indegree;
	//Map<vertex name, weight> adjacent vertices
	public TreeMap<String, Integer> adjacent;
	//constructor(vertex)
	public Vertex(String v)
	{
		adjacent = new TreeMap<>();
		vertex = v;
		indegree = 0;
	}
	//addEdge(vertex, weight)
	public boolean addEdge(String v, int w)
	{
		if(!adjacent.containsKey(v))
		{
			adjacent.put(v, w);
			return true;
		}
		return false;
	}
	//addEdge(vertex)
	public void addEdge(String v)
	{
		addEdge(v, 0);
	}
	public String toString()
	{
		String temp = "Vertex:" + vertex + " | In Degree:" + indegree;
		if(adjacent.size() > 0)
			temp += " | Adjacent List:" + adjacent;
		return temp;
	}
}
