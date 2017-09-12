package hw5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

public class DonTest {
	private static final String undergrad = "{\"name\":\"Jenny\", \"id\":20398776, \"gpa\":3.4, \"year\":\"Junior\" }";
	private static final String grad = "{\"name\":\"Bob\", \"id\":20398777, \"gpa\":3.4, \"undergrad_uni\":\"Mills College\" }";
	private static final String faculty = "{\"name\":\"Henry\", \"id\":20398778, \"gpa\":3.4, \"salary\": 108564 }";
	
	private static final String undergrad2 = "{\"name\":\"Jenny\", \"id\":20398779, \"gpa\":3.4, \"year\":\"Junior\" }";
	private static final String grad2 = "{\"name\":\"Carlos\", \"id\":20398790, \"gpa\":3.4, \"undergrad_uni\":\"Mills College\" }";

	private static  final String invalidIdType = "{\"name\":\"Jenny\", \"id\":\"a12b7\", \"gpa\":3.4, \"year\":\"Junior\" }";
	private static final String missingId = "{\"name\":\"Jenny\", \"gpa\":3.4, \"year\":\"Junior\" }";
	private static final String invalidSalary = "{\"name\":\"Jenny\", \"id\":20398776, \"gpa\":3.4, \"salary\": \"$100,987\" }";	

	private static JsonObject ugradObj, gradObj, facObj, invalidIdObj, missingIdObj, invalidSalaryObj, ugrad2Obj, grad2Obj;

	private static final ArrayList<Don> donList = new ArrayList<Don>();
	
	@BeforeClass
	public static void setUp() {

		JsonParser parser = new JsonParser();
				
		try {
			ugradObj = (JsonObject) parser.parse(undergrad);
			gradObj = (JsonObject) parser.parse(grad);
			facObj = (JsonObject) parser.parse(faculty);
			invalidIdObj = (JsonObject) parser.parse(invalidIdType);
			missingIdObj = (JsonObject) parser.parse(missingId);
			invalidSalaryObj = (JsonObject) parser.parse(invalidSalary);				
			
			ugrad2Obj = (JsonObject) parser.parse(undergrad2);
			grad2Obj = (JsonObject) parser.parse(grad2);
			
		} catch(JsonParseException pe) {
			System.err.println("Unable to execute tests. " + pe.getMessage());
		}

	}

	@Test
	public void testUndergraduate() {
		Don don = DonBuilder.buildDon(ugradObj);
		assertTrue("testUndergraduate: Result not instance of Undergraduate.", don instanceof Undergraduate);		
	}

	@Test
	public void testGraduate() {
		Don don = DonBuilder.buildDon(gradObj);
		assertTrue("testGraduate: Result not instance of Graduate.", don instanceof Graduate);		
	}

	@Test
	public void testFaculty() {
		Don don = DonBuilder.buildDon(facObj);
		assertTrue("testFaculty: Result not instance of Faculty.", don instanceof Faculty);		
	}

	@Test
	public void testUndergradInheritsStudent() {
		Don don = DonBuilder.buildDon(ugradObj);
		assertTrue("testUndergradInheritsStudent: Result not instance of Student.", don instanceof Student);		
	}

	@Test
	public void testGradInheritsStudent() {
		Don don = DonBuilder.buildDon(gradObj);
		assertTrue("testGradInheritsStudent: Result not instance of Student.", don instanceof Student);		
	}

	@Test
	public void testInvalidTypeForId() {
		Don don = DonBuilder.buildDon(invalidIdObj);
		assertEquals("testInvalidTypeForId: Return null if id not of type Long.", null, don);		
	}

	@Test
	public void testMissingId() {
		Don don = DonBuilder.buildDon(missingIdObj);
		assertEquals("testMissingId: Return null if Json does not contain key id.", null, don);		
	}

	@Test
	public void testInvalidTypeForSalary() {
		Don don = DonBuilder.buildDon(invalidSalaryObj);
		assertEquals("testInvalidTypeForSalary: Return null if salary not a Long.", null, don);		
	}
	
	@Test
	public void testCompareTo() {
		
		Don jenny1 = DonBuilder.buildDon(ugradObj);
		Don jenny2 = DonBuilder.buildDon(ugrad2Obj);
		Don carlos = DonBuilder.buildDon(grad2Obj);
		Don bob = DonBuilder.buildDon(gradObj);
		Don henry = DonBuilder.buildDon(facObj);
		
		donList.add(jenny1);
		donList.add(bob);
		donList.add(carlos);
		donList.add(jenny2);
		donList.add(henry);
		Collections.sort(donList);
		for(Don d: donList) {
			System.out.println(d);
		}
		boolean result = (donList.get(0) == bob) &&
				(donList.get(1) == carlos) &&
				(donList.get(2) == henry) &&
				(donList.get(3) == jenny1) &&
				(donList.get(4) == jenny2);
		assertTrue("testCompareTo: Incorrect order after sort.", result);
		
	}
	

}
