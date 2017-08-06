
public class Record {
	private String name=null;
	private String position=null;
	private String separation=null;
	
	public Record(String n, String p, String s) {
		name = n;
		position = p;
		separation = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSeparation() {
		return separation;
	}

	public void setSeparation(String separation) {
		this.separation = separation;
	}
	
	
}
