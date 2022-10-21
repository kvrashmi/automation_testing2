
package util;

import java.io.*;
import java.util.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVReaderHelper {
	//public static String path="//Users//rashmikanduluvavikraman//eclipse-workspace//JavaLearning//src//java_io//emp_details.csv";
	public String path=null;
	
	public CSVReaderHelper(String path)
	{
		this.path=path;
	}
	
	/*
	public static void readCSVUsingReader(String path)
	{
		try
		{
			ArrayList<String> al1 = new ArrayList<String>();
			ArrayList<String> al2 = new ArrayList<String>();
			File fObj = new File(path);
			FileReader fr = new FileReader(fObj);
			BufferedReader br = new BufferedReader(fr);
			String line=br.readLine();
			boolean flag=true;
			while(line!=null)
			{
				String[] arr= line.split(",",0);
				if(flag==true)
				{
					int j=0;
					while(j<arr.length)
					{
						al1.add(j,arr[j]);
						j++;
					}
					flag=false;
				}
				else if(flag==false)
				{
					int j=0;
					while(j<arr.length)
					{
						al2.add(j,arr[j]);
						j++;
					}
				}
				line=br.readLine();
			}
			
			//System.out.println(al1);
			//System.out.println(al2);
			br.close();
			fr.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	*/
	
	/*
	public static void readCSVFileUsingScanner(String path)
	{
		ArrayList<String> headers = new ArrayList<String>();
		
		File f = new File(path);
		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		int i=0;
		while(sc.hasNext())
		{
			
			String line = sc.next(); //EmpId,FirstName,LastName,DOB,Address,PhoneNumber
			//System.out.println(line);
			String arr[] = line.split(",",0);
			if(i==0)
			{
				for(int j=0;j<arr.length;j++)
				{
					headers.add(j, arr[j]);
				}
				i++;
			}
			else
			{
				int j=0;
				while(j<arr.length)
				{
					System.out.println(headers.get(j)+"=>"+arr[j]);
					j++;
				}
			}
		}
		sc.close();
	}
	*/
	
	
	public List<Map<String,String>> readCSVFileUsingOpenCSV()
	{
		CSVReader reader = null; 
		List<Map<String,String>> al =new ArrayList<Map<String,String>>(); 
		try  
		{  
			List<String> header = new ArrayList<String>();
			//parsing a CSV file into CSVReader class constructor
			reader = new CSVReaderBuilder(new FileReader(this.path)).build();
			String[] nextLine;  
			
			//reads one line at a time - put line 1 in header list
			boolean flag=true;
			while ((nextLine = reader.readNext()) != null)  
			{  
				if(flag)
				{
					for(int j=0;j<nextLine.length;j++)
					{
						header.add(j,nextLine[j].toString());
						//System.out.println(nextLine[j]);
					}
					flag=false;
				}
				
				else if(!flag)
				{
					Map<String,String> mpOb = new HashMap<String,String>();
					for(int i=0;i<nextLine.length;i++)
					{
						//System.out.println(nextLine[i]);
						String val = nextLine[i];
						mpOb.put(header.get(i).toString(),val.toString());
						
					}
					al.add(mpOb);
				}
			}
			reader.close();
			//System.out.println(al);
		}  
		catch (Exception e)   
		{  
			e.printStackTrace();  
		}  
		return al;
	}
	
	/*
	public static void main(String[] args) 
	{
		//ReadCSVFile.readCSVFileUsingScanner(ReadCSVFile.path);
		//ReadCSVFile.readCSVUsingReader(ReadCSVFile.path);
		CSVReaderHelper csvRead= new CSVReaderHelper("//Users//rashmikanduluvavikraman//selenium-workspace//TestNGProject//src//main//java//testdata//TestNGProject1.csv");
		List<Map<String,String>> lMap=csvRead.readCSVFileUsingOpenCSV();
		Map<String,String> map = lMap.get(0);
		System.out.println(map);
		System.out.println("Account => "+map.get("Account"));
		System.out.println(map.containsKey("Date"));
		System.out.println(map.values());
		System.out.println(map.keySet());
		Set<String> keySet = map.keySet();
		keySet.forEach((key)->System.out.println("key : "+key.toString().trim().length()));
		System.out.println("Account Key Contains : "+keySet.contains("Description"));
	}
	*/
	
}


