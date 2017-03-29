package inClassAssignments.chapter4;

import java.io.File;

public class FolderStructure {

	public static void main(String[] args) {
		File f = new File("E:/School/Spring 2017/Operating Systems & File Organization (CSCI 4100)");
		if(f.isDirectory())
			for(File sub : f.listFiles())
				System.out.println(sub);

	}

}
