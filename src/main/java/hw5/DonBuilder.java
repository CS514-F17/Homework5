package hw5;

import com.google.gson.JsonObject;

/**
 * A class with a static method to return a new Don based on the
 * input JsonObject.
 * @author srollins
 *
 */
public class DonBuilder {

	/*
// Undergraduate
{  
   "name":"Jenny",
   "id":20398776,
   "gpa":3.4,
   "year":"Junior"
}	

//Graduate
{  
   "name":"Jenny",
   "id":20398776,
   "gpa":3.4,
   "undergrad_uni":"Mills College"
} 

//Faculty
{  
   "name":"Jenny",
   "id":20398776,
   "salary":108765
}

	 */

	/**
	 * Construct an object of type Don.
	 * The method should determine the type of object to instantiate based on the 
	 * schema of the JsonObject.
	 * Above are examples of the schemas for Undergraduate, Graduate, and Faculty.
	 * 
	 * name must be a String
	 * id must be a whole number
	 * gpa must be a double
	 * undergrad_unit must be a String
	 * salary must be a whole number
	 * 
	 * The method will return null if any items are missing or if the value 
	 * associated with a key is not of the correct type.
	 * 
	 * @param donJson
	 * @return
	 */
	public static Don buildDon(JsonObject donJson) {
		//TODO: Replace with your code.
		return null;
	}

}