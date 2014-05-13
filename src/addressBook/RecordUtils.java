package addressBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecordUtils {

	
	/**
	 * Calculates the difference between two dates in days, without caring
	 * about the order of dates
	 *
	 *
	 */
	static int calculateDifInDays(Date d1, Date d2){
		
		if(d1 !=null && d2 !=null ){  
			long diff = d1.getTime() - d2.getTime();
    		long diffDays = diff / (24 * 60 * 60 * 1000);
    		return (int) Math.abs(diffDays);
		}   
    	return 0;
	}
	
	/**
	 *  
	 * @param records a list of type Record
	 * @param file the file that holds the data to fill list
	 * @return list of records
	 * 
	 */
	static List<Record> populateList(List<Record> records, File file){
		try {
			FileReader fr = new FileReader (file);
			BufferedReader br = new BufferedReader(fr);		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
			
			for (String entry = br.readLine(); entry!=null; entry=br.readLine()){ 
				String [] rowFields = (String[]) entry.split(",");
				String name = 	rowFields[0].trim();
				String gender = rowFields[1].trim();
				String date = 	rowFields[2].trim();
				try{
					Date dob = sdf.parse(date);
					records.add(new Record(name, gender, dob));
				}
				catch (ParseException e){
					e.printStackTrace();
				}
			}		
			br.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return records;
	}
	
	/**
	 * 
	 * 
	 * @param records a list of type Record
	 * 
	 * @return total number of males included in list of records
	 */
	static int countMales(List<Record> records){
		int totalMale = 0;
		int size = records.size(); 
	    for(int i=0; i<size; i++){
	       if (records.get(i).getGender().equalsIgnoreCase("male")){
	           totalMale++;
	       }
	    }
		return totalMale;
	}
	
	/**
	 * 
	 * @param records a list of type Record
	 * @param name the name of person in the list
	 * 
	 * @return the index position in the list
	 */
	static int getIndex(List<Record> records, String name){
		int pos = -1 ; //the index in the list
		int size = records.size();
		for(int i=0; i<size; i++){
    	  int i1 = records.get(i).getName().indexOf(name);
    	  if(i1 == 0) 
	    	pos = i;
	      }
		return pos;
	}
	
	/**
	 * 
	 * @param records a list of type Record
	 * @param name the name of person in the list
	 * 
	 * @return the DOB of the person in the list
	 */
	static Date findDOB(List<Record> records, String name){
		Date dob = null;
		
		int pos = getIndex(records, name); //the index in the list
		if (pos != -1)
			return records.get(pos).getDob();
		
		return dob;
	}
	
	/**
	 * 
	 * @param records a list of type Record
	 * @param name the name of person in the list
	 * 
	 * @return true if name is found in list
	 */
	static boolean existsInList(List<Record> records, String name){
		boolean exists = false;
		
		int size = records.size();
		for(int i=0; i<size; i++){
    	  exists = records.get(i).getName().equalsIgnoreCase(name);
    	  if(exists)
    		  break;
	      }
		return exists;
	}
	
}
