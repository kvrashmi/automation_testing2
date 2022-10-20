package util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	
	/*
	 * Read Json File contents for simple json file.
	 * Create a map of username and password and return it.
	*/
	public static Map<String,String> readJSONFileForSimpleJSON()
	{
		Map<String,String> myMap = new HashMap<String,String>();
		System.out.println("Here");
		try
		{
			JSONParser parser = new JSONParser();
			FileReader reader = new FileReader("//Users//rashmikanduluvavikraman//selenium-workspace//TestNGProject//src//main//java//testdata/login_credentials1.json");
			
			//Read JSON File
			Object obj = parser.parse(reader);
			
			JSONObject jsonObject = (JSONObject)obj;
	        String username = (String)jsonObject.get("username");
	        String password = (String)jsonObject.get("password");
			
		    myMap.put("username",username);
			myMap.put("password",password);
			
			System.out.println("ListOfMap:"+myMap);
			reader.close();
			
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return myMap;
		
	}
	/*
	 * Read json file contents - make a list of maps and return it.
	 * json file contains - array of json.
	 */
	public static List<Map<String, String>> readJSONFileForJSONArray() throws IOException, ParseException
	{
		List<Map<String, String>> listOfMaps = new ArrayList<Map<String, String>>();
		
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("//Users//rashmikanduluvavikraman//selenium-workspace//TestNGProject//src//main//java//testdata/login_credentials2.json");
		
		//Read JSON File
		Object obj = jsonParser.parse(reader);
		
		JSONArray usersList = (JSONArray) obj;
		System.out.println("Users List-> "+usersList); //This prints the entire json file
		
		for(int i=0;i<usersList.size();i++) 
		{
			Map<String,String> myMap = new HashMap<String, String>();

			JSONObject users = (JSONObject) usersList.get(i);
			System.out.println("Users -> "+users);//This prints every block - one json object
			
			/*
			JSONObject user = (JSONObject) users.get("users");
			System.out.println("User -> "+user); //This prints each data in the block
			*/
			
			String username = (String) users.get("username");
			String password = (String) users.get("password");
			System.out.println("The username in JSON is: "+username);
			System.out.println("The password in JSON is: "+password);
			
			myMap.put("username",username);
			myMap.put("password",password);
			listOfMaps.add(i,myMap);
		}
		System.out.println("ListOfMap:"+listOfMaps);
		reader.close();
		
		return listOfMaps;
	}
	
	
	/*
	 * Json file contains array of json data
	 * First entry in array is valid username and valid passowrd
	 * Second entry is invalid username and valid password.
	 * Third entry is valid username and invalid password.
	 * Everytime when this method is called any one of the combo will be given to the tester.
	 */
	public static Map<String,String> getCredentialMapFromJSONList(List<Map<String,String>> listOfMaps)
	{
		int sizeOfListOfMaps = listOfMaps.size();
		int randNum = Helper.generateRandomNumber(sizeOfListOfMaps);
		return listOfMaps.get(randNum);
	}
	

}
