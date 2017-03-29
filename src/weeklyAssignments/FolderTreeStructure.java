package weeklyAssignments;
import java.io.File;
import java.util.ArrayList;
public class FolderTreeStructure {
	public static ArrayList<String> getDirectories(File f) {
        ArrayList<String> list = new ArrayList<String>();
        if (f.isDirectory()){
            for (File sub : f.listFiles())
            {
                if (sub.isDirectory())
                	list.addAll(getDirectories(sub));
                list.add(sub.toString());
            }
        }
        return list;
    }
	public void test(){
		File f = new File("E:/School/Spring 2017/Operating Systems & File Organization (CSCI 4100)");
		ArrayList<String> list = new ArrayList<String>(getDirectories(f));
		GeneralTree<String> tree = new GeneralTree<String>();
		for (String childNode : list) {
            tree.insert(childNode);
        }
        System.out.println();
        tree.traverseDirectories(f, "");
	}
	public static void main(String[] args) 
	{
		FolderTreeStructure testTree = new FolderTreeStructure();
		testTree.test();
	}
}