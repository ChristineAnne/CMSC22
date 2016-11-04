package studentDB;

/*
 *  created by Christine Anne Ibo Catubig 
 */

import java.io.Serializable;

public class Course implements Serializable {
	
	String courseCode;
	String courseDescription;
	
	public Course(String courseCode, String courseDescription) {
		this.courseCode = courseCode;
		this.courseDescription = courseDescription;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	@Override
	public String toString(){
		return "\nCourse Code: " + courseCode + "\nCourse Description: " + courseDescription;
	}
	
}
