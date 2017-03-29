package inClassAssignments.chapter1;

public class Interfaces implements Comparable<Interfaces> {
	private String data;

	@Override
	public int compareTo(Interfaces o) {
		return data.compareTo(o.data);
	}

	public Interfaces(String data) {
		super();
		this.data = data;
	}

}
