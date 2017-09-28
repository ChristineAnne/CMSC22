import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class StudentDB {
	
	private static final String FILE = "/Users/dcs-madl07/Documents/CaH2O/StudentDBSerializable/db.txt";
	
	// checks if the student is already enrolled
	boolean studEnrolled(List<Student> l, String studNum){
		boolean enrolled = false;
		for(Student s: l){
		    if(s.getStudentNumber().compareTo(studNum) == 0){
			enrolled = true;
			break;
		    } 
		}
		return enrolled;
	}
	
	// sleeps 
	public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
	
	// scans the line of the file and puts it into the list
	public final void processLinebyLine(List<Student> list, ObjectInputStream ois) throws IOException {
		
        try{        	
        	list = (List) ois.readObject();            
        } catch (ClassNotFoundException cnf){
        	cnf.printStackTrace();
        }
        ois.close();
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		StudentDB database = new StudentDB();
		List<Student> list = new ArrayList<Student>();
		
		try{
			/*************************/
			// file handling part; reads a file when the program starts..
			File file = new File(FILE);
			if(!file.exists()){
				file.createNewFile();
			}
			
			fis = new FileInputStream(file);
			
			if(file.length() != 0){
				ois = new ObjectInputStream(fis);
				database.processLinebyLine(list, ois);
			}
			
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			/*************************/
				
			//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println("\n\n\t\t\tWelcome to Student Database");
			Scanner sc = new Scanner(System.in);
			
			int choice = 0;
			// we added a display option; it is more efficient than having to go to the file to check how many students are enrolled
			while(choice != 7){
				System.out.println("\n\t1. Register a student\n\t2. Retrieve student information\n\t3. Unenroll a student\n\t4. Save file\n\t5. Update Student's Information\n\t6. Display all Students\n\t7. Exit");
				System.out.print("\n\n\tUser enter your choice: ");
				
				choice = Integer.parseInt(sc.nextLine());
				System.out.println();
				//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				
				String studNum, fName, lName, curse;
				int yrLevel;
				char midIn;
				Course course_Code_Description;
				String courseCode, courseDescription, crushName;
				
				switch(choice){
				
					// register a student
					case 1:
						System.out.println("\n\t\t===================REGISTER====================");
						System.out.println();
						System.out.print("Student Number:  ");
						studNum = sc.nextLine();
		
						if(!database.studEnrolled(list, studNum)){
						    System.out.print("First Name: ");
						    fName = sc.nextLine();
						    System.out.print("Middle Initial: ");
						    midIn = sc.nextLine().charAt(0);
						    System.out.print("Last Name: ");
						    lName = sc.nextLine();
						    System.out.print("Program: ");
						    curse = sc.nextLine();
						    System.out.print("Year Level: ");
						    yrLevel = Integer.parseInt(sc.nextLine());
						    System.out.print("Course Code(fave subject): ");
						    courseCode = sc.nextLine();
						    System.out.print("Course Description(fave subject): ");
						    courseDescription = sc.nextLine();
						    System.out.print("Crush Name: ");
						    crushName = sc.nextLine();
						    System.out.println();
						    
						    course_Code_Description = new Course(courseCode, courseDescription);
						    	
						    Student student = new Student(studNum, fName, midIn, lName, curse, yrLevel, crushName, course_Code_Description);
						    list.add(student);
						    System.out.println("\nStudent added!"); 
						}else{
							System.out.println("Student is already enrolled!");
						}
						database.sleep(1000);
						break;
						
					// retrieve student information using student number
					case 2:	
						System.out.print("Search Student: ");
						studNum = sc.nextLine();
						if(database.studEnrolled(list, studNum)){
							for(int i = 0; i < list.size(); i++) {
								if(list.get(i).getStudentNumber().compareTo(studNum) == 0) {
									Student s = list.get(i);
									System.out.println(s);
									break;
								}
							}
						}else{
							System.out.println("Student is not enrolled");
						}
						System.out.println("\n\nPress Any Key To Continue...");
				        new java.util.Scanner(System.in).nextLine();
						break;
						
					// delete a student using student number
					case 3:					
						System.out.print("Delete Student: ");
						studNum = sc.nextLine();
						if(database.studEnrolled(list, studNum)){
							for(int i = 0; i < list.size(); i++) {
								if(list.get(i).getStudentNumber().compareTo(studNum) == 0) {
									list.remove(list.get(i));
									break;
								}
							}
							System.out.println("Student " + studNum + " deleted!");
						}else{
							System.out.println("Student is not enrolled.");
						}
						database.sleep(1000);
						break;
						
					// save info to a file
					case 4:
						oos.writeObject(list);
						break;
						
					// updates student information
					case 5:
						System.out.println("\n\t\t===================UPDATE====================");
						System.out.println("\nSearch and Update Student:  ");
						studNum = sc.nextLine();
						System.out.println();
						
						if(database.studEnrolled(list, studNum)){
							for(int i = 0; i < list.size(); i++) {
								if(list.get(i).getStudentNumber().compareTo(studNum) == 0){
									Student s = list.get(i);
									int choose = 0; // we added a choose option because what if the user just wants to update one information and not all of it 
									while(choose < 1 || choose > 5){
									    System.out.println("\n1. First Name\n2. Last Name\n3. Middle Initial\n4. Program\n5. Year Level");
									    System.out.print("Choose one to be updated: ");
									    choose = Integer.parseInt(sc.nextLine());                            
									    switch(choose){
											case 1:
											    System.out.print("First Name:  ");
											    fName = sc.nextLine();
											    System.out.println();
											    s.setFirstName(fName);
											    break;
											case 2:
											    System.out.print("Last Name:  ");
											    lName = sc.nextLine();
											    System.out.println();
											    s.setLastName(lName);
											    break;
											case 3:
											    System.out.print("Middle Initial:  ");
											    midIn = sc.nextLine().charAt(0);
											    System.out.println();
											    s.setMiddleInitial(midIn);
											    break;
											case 4:
											    System.out.print("Program:  ");
											    curse = sc.nextLine();
											    System.out.println();
											    s.setCourse(curse);
											    break;
											case 5:
											    System.out.print("Year Level:  ");
											    yrLevel = sc.nextInt();
											    System.out.println();
											    s.setYearLevel(yrLevel);
											    break;
											default:
											    System.out.println("Please choose again.");
											    break;
									    }
									    if(choose > 0 || choose < 6){
											System.out.println("Want to update something else?\nYes or No");
											String c = sc.nextLine();
											if("Yes".equals(c) || "yes".equals(c) || "YES".equals(c) || "YEs".equals(c) || "yES".equals(c) || "YeS".equals(c) || "yeS".equals(c) || "yEs".equals(c))
											    choose = 0;
									    }
									}
									System.out.println("Student " + studNum + "'s information updated!");
							    }
							}	
						} else {
							System.out.println("Student is not enrolled.");
						}
						database.sleep(1000);
						break;
		            
						// displays student info
					case 6:
						System.out.println("\n\t==================STUDENT INFORMATION==================");

						for(Student s: list){
							System.out.println(s);
							System.out.println("------------------------------------------------------------");
						}
						System.out.println("\n\nPress Any Key To Continue...");
				        new java.util.Scanner(System.in).nextLine();
						break;
						
					case 7:
						System.out.println("\n\tThank you for using our service.\n\tGoodbye and have a lovely day ahead.");
						database.sleep(1500);
						break;	
					
					default:
						System.out.println("Please enter again.");
						database.sleep(1500);
				}
				//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			sc.close();
			
		}catch (IOException e){
			e.printStackTrace();
		} finally {
			try{
				oos.close();
				fos.close();
				fis.close();
			}catch (IOException e){
				e.printStackTrace();
			}
			
		}
		
	}
}	