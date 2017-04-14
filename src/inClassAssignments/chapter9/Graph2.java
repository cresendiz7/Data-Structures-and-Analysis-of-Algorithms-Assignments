package inClassAssignments.chapter9;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Graph2 {
	//Map<String Vertex>
	public TreeMap<String, Vertex2> graph;
	//constructor
	public Graph2()
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
			graph.put(v, new Vertex2(v));
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
			for(Map.Entry<String, Vertex2> vertex : graph.entrySet())
				temp += vertex.getValue() + "\n";
			return temp;
		}
		return "No Verticies";
	}
	/***************************************************************************/
	public void printPath(String vs, String ve, String type)
	{
		if(graph.containsKey(vs) && graph.containsKey(ve))
		{
			System.out.println(type.toUpperCase());
			Vertex2 start = graph.get(vs);
			if(type.toLowerCase().equals("unweighted"))
			{
				unweighted(start);
			}
			else if(type.toLowerCase().equals("weighted"))
			{
				weighted(start);
			}
			else if(type.toLowerCase().equals("negative"))
			{
				negative(start);
			}
			Vertex2 end = graph.get(ve);
			/*
			 * Pseudocode
			if(e.dist != INFINITY){
				String path = "";
				Vertex curr = e;
				while(curr.path != null){
					path += curr;
					curr = curr.path;
				}
				path = s + path;
				print(path)
				print(dist)
			}else{
				print("can not reach end");
			}
			 */
			if(end.dist != Integer.MAX_VALUE)
			{
				String path = "";
				Vertex2 curr = end;
				while(curr.path != null)
				{
					path = curr.vertex + "->" + path ;
					curr = curr.path;
				}
				path = vs  + "->" + path;
				System.out.println(path);
				System.out.println("Distance:" + end.dist);
			}
			else
			{
				System.out.println("Can Not Reach End");
			}
		}
	}

	public void unweighted(Vertex2 start)
	{
		/*
		 * Pseudocode from textbook PG 372
		Queue<Vertex> q = new Queue<Vertex>();
		for each Vertex v{
			v.dist = INFINITY;
			v.path = null;//added to make sure we clear the path between runs of pathing methods
		}
		s.dist = 0;
		q.enqueue(s);
		while(!q.isEmpty()){
			Vertex v = q.dequeue();
			for each Vertex w adjacent to v{
				if(w.dist == INFINITY){
					w.dist = v.dist + 1;
					w.path = v;
					q.enqueue(w);
				}
			}
		}
		 */
		LinkedList<Vertex2> q = new LinkedList<>();
		for(Map.Entry<String, Vertex2> vertex : graph.entrySet())
		{
			vertex.getValue().dist = Integer.MAX_VALUE;
			vertex.getValue().path = null;
		}
		start.dist = 0;
		q.add(start);
		while(!q.isEmpty())
		{
			Vertex2 v =  q.removeFirst();
			for(Map.Entry<String, Integer> vertex : v.adjacent.entrySet())
			{
				//get vertex out of graph based on string in adjacent list
				Vertex2 w = graph.get(vertex.getKey());
				if(w.dist == Integer.MAX_VALUE)
				{
					w.dist = v.dist + 1;
					w.path = v;
					q.add(w);
				}
			}
		}

	}
	public void weighted(Vertex2 start)
	{
		/*
		 * Pseudocode
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		//implement Comparable<Vertex> based on distance for PriorityQueue
		for each Vertex v{
			v.dist = INFINITY;
			v.path = null;//added to make sure we clear the path between runs of pathing methods
			v.known = false;
		}
		s.dist = 0;
		q.enqueue(s);
		while(!q.isEmpty()){
			Vertex v = q.dequeue();//smallest distance in queue
			v.known = true;
			for each Vertex w adjacent to v{
				if(w.dist > v.dist + w.weight){
					w.dist = v.dist + w.weight;
					w.path = v;
				}
				if(!w.known){
					q.enqueue(w);
				}
			}
		}
		 */
		PriorityQueue<Vertex2> q = new PriorityQueue<>();
		for(Map.Entry<String, Vertex2> vertex : graph.entrySet())
		{
			vertex.getValue().dist = Integer.MAX_VALUE;
			vertex.getValue().path = null;
			vertex.getValue().known = false;
		}
		start.dist = 0;
		q.add(start);
		while(!q.isEmpty())
		{
			Vertex2 v = q.poll();
			v.known = true;
			for(Map.Entry<String, Integer> vertex : v.adjacent.entrySet())
			{
				//get vertex out of graph based on string in adjacent list
				Vertex2 w = graph.get(vertex.getKey());
				int weight = vertex.getValue();
				if(w.dist > v.dist + weight){
					w.dist = v.dist + weight;
					w.path = v;
				}
				if(!w.known){
					q.add(w);
				}
			}
		}
	}
	public void negative(Vertex2 start)
	{
		/*
		 * Pseudocode
		Queue<Vertex> q = new Queue<Vertex>();
		for each Vertex v{
			v.dist = INFINITY;
			v.path = null;//added to make sure we clear the path between runs of pathing methods
		}
		s.dist = 0;
		q.enqueue(s);
		while(!q.isEmpty()){
			Vertex v = q.dequeue();
			for each Vertex w adjacent to v{
				if(w.dist > v.dist + w.weight){
					w.dist = v.dist + w.weight;
					w.path = v;
					if(!q.contains(w)){
						q.enqueue(w);
					}
				}
			}
		}
		 */
		LinkedList<Vertex2> q = new LinkedList<>();
		for(Map.Entry<String, Vertex2> vertex : graph.entrySet())
		{
			vertex.getValue().dist = Integer.MAX_VALUE;
			vertex.getValue().path = null;
		}
		start.dist = 0;
		q.add(start);
		while(!q.isEmpty())
		{
			Vertex2 v = q.poll();
			for(Map.Entry<String, Integer> vertex : v.adjacent.entrySet())
			{
				Vertex2 w = graph.get(vertex.getKey());
				int weight = vertex.getValue();
				if(w.dist > v.dist + weight){
					w.dist = v.dist + weight;
					w.path = v;
					if(!q.contains(w)){
						q.add(w);
					}
				}
			}
		}
	}
}
