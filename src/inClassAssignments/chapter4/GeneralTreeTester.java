package inClassAssignments.chapter4;

public class GeneralTreeTester {

	public static void main(String[] args) {
		GeneralTree<String> words = new GeneralTree<String>();
		words.insert(null, "root");
		words.insert("root", "firstChild");
		words.insert("root", "secondChild");
		words.insert("firstChild", "firstChild of firstChild");
		words.insert("firstChild", "secondChild of firstChild");
		
		System.out.println(words.find("firstChild"));
		words.print();
		/*
		GeneralTreeSearch<String> names = new GeneralTreeSearch<String>();
		
		names.insert("m");//root = m
		names.insert("o");//m ->sib-> o
		names.insert("l");//m ->child-> l
		names.insert("a");//m ->child-> l ->child-> a
		names.insert("z");//m ->sib-> o ->sib-> z
		names.insert("y");//m ->sib-> o ->sib-> z ->child-> y
		names.insert("i");//m ->child-> l ->child-> a ->sib-> i
		names.insert("o");//m ->sib-> o ->sib-> z ->child-> y ->child-> o

		names.print();
		System.out.println("Find m:"+names.find("m"));//true
		System.out.println("Find b:"+names.find("b"));//false
		*/
	}

}
