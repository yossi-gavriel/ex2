package coding;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * 
 * the main purpose of this code is to take information from a json file 
 * and put it in a text file with some hashing on the password
 * 
 */


public class Messup {


	public static void main(String[] args) {
	
		jsonFileToTextFile json = new jsonFileToTextFile();
		json.read("src/coding/TestFile.json");
		json.write("src/coding/users.txt");
		System.out.println(json.toString());
		
		
	}
}

