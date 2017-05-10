package udemy.json;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import udemy.json.domain.UdemyStudent;

public class DataBindingWrite
{

	public static void main(String[] args)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		
		// Java POJO (Plain Old Java Object)
		// Write to System.out
		UdemyStudent udemyStudent = new UdemyStudent();
		udemyStudent.setId(1);
		udemyStudent.setName("tuna");
		udemyStudent.setLastName("tore");
		
		UdemyStudent udemyStudent2 = new UdemyStudent();
		udemyStudent2.setId(2);
		udemyStudent2.setName("tuna2");
		udemyStudent2.setLastName("tore2");
		
		try {
			String studentString = objectMapper.writeValueAsString(udemyStudent);
			// Write unformatted JSON in one line
			System.out.println(studentString);
			// Writer with pretty printer formats JSON to look nicer
			System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(udemyStudent));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, Object> mapJSON = new LinkedHashMap<String, Object>();
		
		// Adding various types of data to the map
		mapJSON.put("key1", "value1");
		mapJSON.put("key2", "value2");
		mapJSON.put("key3", "value3");
		mapJSON.put("booleanTrue", true);
		mapJSON.put("booleanFalse", false);
		mapJSON.put("array", new String[] {"1", "2", "3"});
		mapJSON.put("arrayOfObjects", new UdemyStudent[]{udemyStudent, udemyStudent2});
		mapJSON.put("nestedObject", udemyStudent);
		mapJSON.put("integer", 1);
		mapJSON.put("valueNull", null);
		mapJSON.put("list", Arrays.asList("1", "2", "3"));
		mapJSON.put("date", LocalDateTime.now().toString());
		
		// Output mapJSON to the console
		try {
			System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapJSON));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Output mapJSON to a file instead of a string
		try {
			objectMapper.writerWithDefaultPrettyPrinter().writeValue
			(new File("src/main/resources/mapJSON.json"), mapJSON);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
