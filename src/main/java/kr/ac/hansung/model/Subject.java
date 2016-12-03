package kr.ac.hansung.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Subject {	
	private int year;
	private int semester;
	
	
	@NotEmpty(message="Cannot be empty")
	private String id;
	@NotEmpty(message="Cannot be empty")
	private String name;
	@NotEmpty(message="Cannot be empty")	
	private String part;
	//@NotNull(message="Grade Cannot be empty")
	//@NumberFormat(style = Style.NUMBER)
	//@Pattern(regexp="^[1|2|3]$")
	@NotNull @Min(1) @Max(3)
	private int grade;

	public Subject() {

	}

	public Subject(int year, int semester, String id, String name, String part, int grade) {
		this.year = year;
		this.semester = semester;
		this.id = id;
		this.name = name;
		this.part = part;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Subject [year=" + year + ", semester=" + semester + ", id=" + id + ", name=" + name + ", part=" + part
				+ ", grade=" + grade + "]";
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
