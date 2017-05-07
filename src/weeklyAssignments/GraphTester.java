package weeklyAssignments;


public class GraphTester {

	public static void main(String[] args) {
		Graph courses = new Graph();
		//required CS courses
		courses.addEdge("CSCI 1301", "CSCI 1302");
		courses.addEdge("CSCI 1301", "CSCI 2150");
		courses.addEdge("CSCI 1302", "CSCI 3100");
		courses.addEdge("CSCI 1302", "CSCI 3200");
		courses.addEdge("CSCI 1302", "CSCI 3300");
		courses.addEdge("CSCI 1302", "CSCI 3410");
		courses.addEdge("CSCI 1302", "CSCI 3450");
		courses.addEdge("CSCI 1302", "CSCI 3510");
		courses.addEdge("CSCI 1302", "CSCI 4200");
		courses.addEdge("CSCI 3100", "CSCI 4100");
		courses.addEdge("CSCI 3300", "CSCI 4400");
		courses.addEdge("CSCI 3300", "CSCI 4950");
		courses.addEdge("MATH 1113", "MATH 1450");
		courses.addEdge("MATH 1113", "MATH 2400");
		courses.addEdge("MATH 1113", "MATH 2510");
		courses.addEdge("MATH 1450", "MATH 2460");
		courses.addEdge("MATH 2510", "CSCI 3200");
		courses.addEdge("MATH 2510", "CSCI 3450");
		courses.addEdge("MATH 2510", "CSCI 4200");
		courses.topologicalSort();	
	}

}
