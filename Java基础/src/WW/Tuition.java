package WW;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Tuition {
	  private String firstName;
	  private String lastName;
	  private String studNum;
	  private String aFile;
	  private final String STUDENT_TUITION_FILE = "E:/EclipseWorkspace/TEST/src/WW/Tuition.txt";
	  private ArrayList<StudentTuitionModel> allTuition;

	 //constructor
	  public Tuition(String fname, String lname, String stuNum) {
		firstName = fname;
		lastName = lname;
		studNum = stuNum;
	  }

	    //Get basic student awards information from a text file that is
	    //passed in from the parameter
		public ArrayList<StudentTuitionModel> getAllTution(String file){
			  aFile = file;
			  allTuition = new ArrayList();
			  try {
				 BufferedReader reader = new BufferedReader(new FileReader(aFile));
				 String line = reader.readLine();
				 while(line != null) {
					if (line.length() != 0) {
					  String[] arr = line.split("\\,");
					  StudentTuitionModel sdam = new StudentTuitionModel (arr[0].trim(), arr[1].trim(),arr[2].trim(),arr[3].trim(),                        arr[4].trim());
					  if( sdam.getStudFirstName().equals(firstName) &&
						  sdam.getStudLastName().equals(lastName) &&
						  sdam.getStudSerialNum().equals(studNum) )

						  allTuition.add(sdam);
					}
					line = reader.readLine();
				  }
			   }
			   catch(FileNotFoundException exc){
				  exc.printStackTrace();
				  System.exit(1);
			   }
			   catch(IOException exc){
				  exc.printStackTrace();
				  System.exit(1);
			   }
			   return allTuition;
		   }


	  public String getFirstName() {
		return firstName;
	  }
	  public String getLastName() {
		return lastName;
	  }
	  public String getStudNumber() {
		  return studNum;
	  }
}

