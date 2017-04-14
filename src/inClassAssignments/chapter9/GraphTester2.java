package inClassAssignments.chapter9;


public class GraphTester2 {
	public static void main(String[] args) {
		Graph2 g = new Graph2();
		g.addEdge("V1", "V2", 2);
		g.addEdge("V1", "V4", 1);
		g.addEdge("V2", "V4", 3);
		g.addEdge("V2", "V5", 10);
		g.addEdge("V3", "V1", 4);
		g.addEdge("V3", "V6", 5);
		g.addEdge("V4", "V3", 2);
		g.addEdge("V4", "V5", 2);
		g.addEdge("V4", "V6", 8);
		g.addEdge("V4", "V7", 4);
		g.addEdge("V5", "V7", 6);
		g.addEdge("V7", "V6", 1);
		/*
		   v1 - v2
		  /  \ /  \
		v3 - v4 - v5
          \  / \  /
           v6 - v7
		*/
		System.out.println(g);
		g.printPath("V1", "V7", "unweighted");
		System.out.println(g);
		g.printPath("V3", "V5", "unweighted");
		System.out.println(g);
		g.printPath("V3", "V7", "weighted");
		System.out.println(g);

		Graph2 g2 = new Graph2();
		g2.addEdge("V1", "V2", 2);
		g2.addEdge("V1", "V4", -3);
		g2.addEdge("V2", "V4", 3);
		g2.addEdge("V2", "V5", 10);
		g2.addEdge("V3", "V1", 4);
		g2.addEdge("V3", "V6", 5);
		g2.addEdge("V4", "V3", 2);
		g2.addEdge("V4", "V5", 2);
		g2.addEdge("V4", "V6", 8);
		g2.addEdge("V4", "V7", 4);
		g2.addEdge("V5", "V7", 6);
		g2.addEdge("V7", "V6", 1);
		g2.printPath("V3", "V7", "negative");
		System.out.println(g2);
	}
}
