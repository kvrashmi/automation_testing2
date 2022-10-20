package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

public class Helper {
	
	public static int generateRandomNumber(int boundaryNum)
	{
		Random rnd = new Random();
		int number=rnd.nextInt(boundaryNum);
		return number;
	}
	
	
	
	public static boolean compareUrls(String url1,String url2)
	{
		Assert.assertEquals(url2, url1);
		return url1.equals(url2);
	}
	
	
	
	
}
