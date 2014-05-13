package addressBook;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AddressBookTest {

	public static void main (String [] args){
			
//		Populate entries of address book		
		File file = new File("AddressBook.txt");
		List <Record> records = new ArrayList<Record>();
		records = RecordUtils.populateList(records, file);
		
		
//		1.  Find total males		
		int totalMale= RecordUtils.countMales(records);
		System.out.println("There are " + totalMale + " males");    
	
		       
//	    2. 	Find oldest person		       
//			Sort by age and pick the first person from records
		Collections.sort(records);      
		if(!records.isEmpty())
		   	  System.out.println("Oldest person in address book is "+ records.get(0).getName());
		      

//	    3.	Check if Bill and Paul exist, get their age and calculate difference in days
		boolean billExists = RecordUtils.existsInList(records, "Bill McKnight");
		boolean paulExists = RecordUtils.existsInList(records, "Paul Robinson");
		Date billsDOB = null;
		Date paulsDOB = null;
		
		if(billExists && paulExists){
			billsDOB = RecordUtils.findDOB(records, "Bill McKnight");
			paulsDOB = RecordUtils.findDOB(records, "Paul Robinson");
			if(billsDOB !=null && paulsDOB != null){
				int days = RecordUtils.calculateDifInDays(billsDOB, paulsDOB);
			 	System.out.println("Bill and Paul have " + days +" days difference");
			}
		}
	}
}
