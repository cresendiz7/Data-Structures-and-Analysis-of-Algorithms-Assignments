package inClassAssignments.chapter9;

import java.util.TreeMap;

public class Vertex2 implements Comparable<Vertex2> {
	//vertex name
	public String vertex;
	//number of vertices that lead to this vertex
	public int indegree;
	//Map<vertex name, weight> adjacent vertices
	public TreeMap<String, Integer> adjacent;
	public Integer dist;
	public Vertex2 path;
	public boolean known;
	//constructor(vertex)
	public Vertex2(String v)
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
		String temp = "Vertex:" + vertex + " | In Degree:" + indegree + " | Distance:" + dist;
		if(adjacent.size() > 0)
			temp += " | Adjacent List:" + adjacent;
		return temp;
	}
	public int compareTo(Vertex2 v)
	{
		return dist.compareTo(v.dist);
	}
}
