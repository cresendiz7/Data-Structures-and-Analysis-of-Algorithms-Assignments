package inClassAssignments.chapter5;

public class Student {
	private String name;
	private String major;
	private int gradYear;
	public Student(String name, String major, int gradYear) {
		super();
		this.name = name;
		this.major = major;
		this.gradYear = gradYear;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGradYear() {
		return gradYear;
	}
	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", major=" + major + ", gradYear=" + gradYear + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gradYear;
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)//alias
			return true;
		if (obj == null)//no second object
			return false;
		if (getClass() != obj.getClass())//same class of object
			return false;
		Student other = (Student) obj;
		if (gradYear != other.gradYear)
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
