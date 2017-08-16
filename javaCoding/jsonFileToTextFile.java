package coding;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/*
 * this class is contain a Array of object with "name" and "password" 
 * this class have main methods :
 * 1- read json file and put his information in a json object
 * 2- put the information from the json object in text file
 *  which every element in the array write as the form : "name: (hashcode of the password of the user)" 
 */

public class jsonFileToTextFile
{

	private JSONObject jsonObject ;


	/**
	 * constructor
	 */
	public jsonFileToTextFile()
	{

		jsonObject =new JSONObject();

	}

	/**
	 * @param jasonFile
	 * this function get a String that represent a jason file and take the array that inside the file
	 * and put it in array of jasons and put the array in a JSONObject
	 */
	public void read(String jasonFile)
	{

		try {

			JSONParser parser =new JSONParser();
			FileReader filereader =new FileReader(jasonFile);
			JSONArray outJasonArray =new JSONArray();
			JSONArray inputJasonArray = (JSONArray) parser.parse(filereader);//  get array of jason from the file

			for (int i = 0; i < inputJasonArray.size(); i++) 
			{
				JSONObject Obj = (JSONObject) inputJasonArray.get(i); //  get the next json object 
				String userToAdd = Obj.get("username").toString()+":"+Obj.get("password").toString().hashCode() ;
				outJasonArray.add(userToAdd);//   add it to the array
			}

			jsonObject.put("users", outJasonArray);  //put the array in the jason object

		} catch (IOException | ParseException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param outPutFile
	 * this function get the String that represent the name of the output file
	 * and write the current jason object into the file
	 * 
	 */
	public void write(String outPutFile)
	{

		try (FileWriter filewriter = new FileWriter(outPutFile)) 
		{
			try
			{
				filewriter.write(jsonObject.toJSONString());
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (IOException e1)
		{

			e1.printStackTrace();
		}

	}

	/**
	 *  
	 * @return the string that represent the current object
	 */
	public  String toString()
	{

		return "\nJSON Object: " + jsonObject ;

	}

}
