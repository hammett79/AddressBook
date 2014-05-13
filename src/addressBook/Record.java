package addressBook;

import java.util.*;


public class Record implements Comparable<Record> {
	
	private String name;
	private String gender;
	private Date dob;
	
	public Record(String name, String gender, Date dob) {
		this.name = name;
		this.gender = gender;
		this.dob = dob;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String toString(){
	    return name + " " + gender + " " + dob;
	}

	@Override
	public int compareTo(Record r) {
		return dob.compareTo(r.getDob());
	}
}
