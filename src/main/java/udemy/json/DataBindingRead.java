package udemy.json;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import udemy.json.domain.UdemyStudent;

// Class to read strings and bind JSON to a java object
public class DataBindingRead
{

	public static void main(String[] args)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		
		// Create a JSON object as a string to be converted into a java object
		String udemyStudentJSON = "{" +
				"\"id\" : 1," +
				"\"name\" : \"tuna\"," +
				"\"lastName\" : \"tore\"" +
				"}";

		try {
			UdemyStudent udemyStudent = objectMapper.readValue(udemyStudentJSON, UdemyStudent.class);
			System.out.println("id:" + udemyStudent.getId());
			System.out.println("name:" + udemyStudent.getName());
			System.out.println("lastName:" + udemyStudent.getLastName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ClassLoader classLoader = DataBindingRead.class.getClassLoader();
		
		// Read a JSON file and turn it into a java map
		try {
			Map<String, Object> mapJSON = 
				objectMapper.readValue(new File(classLoader.getResource("mapJSON.json").getFile()),
				new TypeReference<Map<String, Object>>() {} );
			
		System.out.println(mapJSON);
		
		// Another way to print out the map: use map methods
		for (Map.Entry<String, Object> entry : mapJSON.entrySet())
		{
			System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
