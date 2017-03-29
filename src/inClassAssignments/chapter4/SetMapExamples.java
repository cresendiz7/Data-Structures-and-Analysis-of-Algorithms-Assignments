package inClassAssignments.chapter4;

import java.util.TreeMap;
import java.util.TreeSet;

public class SetMapExamples {

	public static void main(String[] args) {
		//https://docs.oracle.com/javase/8/docs/api/java/util/TreeSet.html
		TreeSet<String> names = new TreeSet<String>();
		names.add("JET");
		names.add("1");
		names.add("3");
		names.add("2");
		for(String s : names)
		{
			System.out.println(s);
		}
		//https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html
		TreeMap<String, String> nameMap = new TreeMap<String,String>();
		nameMap.put("key", "value");
		nameMap.put("key3", "value3");
		nameMap.put("key2", "value2");
		System.out.println("Keys:");
		for(String s : nameMap.keySet())
		{
			System.out.println(s + ":" + nameMap.get(s));
		}
		//Key must implement the Comparable Interface
		//TreeMap<Student, Course> n = new TreeMap<>();
	}

}
