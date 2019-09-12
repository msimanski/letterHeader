package letterHeader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

// this object manages the importation and selection of quotes from the file "quotes.json"
public class Quotes
{
	public static ArrayList<Quote> quotesList = new ArrayList<Quote>();
	public static JSONObject quotesJSON;
	
	// initialize required objects and store JSON in memory
	public Quotes() throws FileNotFoundException, IOException
	{
		File file = new File("quotes.json");
	    String content = FileUtils.readFileToString(file, "utf-8");

	    // convert JSON string to JSONObject
	    quotesJSON = new JSONObject(content);
	    
	    // extracting data array from json string
	    JSONArray ja_data = quotesJSON.getJSONArray("quotes");
	    int length = quotesJSON.length();
	    
	    // loop to get all json objects from data json array, datify them to quote objects so its not a pain in the ass to mess with
	    for(int i=0; i< length + 1; i++) 
	    {
	    	// instantiate a new quote object
	    	Quote newQuote = new Quote();
	    	
	    	// set fields
	        JSONObject jObj = ja_data.getJSONObject(i);
	        newQuote.setId(Integer.parseInt(jObj.get("id").toString()));
	        newQuote.setText(jObj.getString("text").toString());
	        newQuote.setAuthor(jObj.getString("author").toString());
	        
	        // getting inner array tags
	        JSONArray ja = jObj.getJSONArray("tags");
	        ArrayList<String> tagNames = new ArrayList<>();
	        for(int j=0; j < ja.length(); j++) 
	        {
	        	JSONObject json = ja.getJSONObject(j);
	        	tagNames.add(json.getString("tag").toString());
	        }
	        
	        // set tags
	        ArrayList<String> tagDummy = new ArrayList<String>();
	        for(int k = 0; k < tagNames.size(); k++) 
	        {
	        	tagDummy.add(tagNames.get(k));
	        }
	        newQuote.setTags(tagDummy);
	        
	        // add the new quote to the list
	        quotesList.add(newQuote);
	    }
	}
	
	public static void importQuotes() throws IOException
	{
		//System.out.println("INFO: Successfully added quote: {" + line + "} to memory.");
		
		//System.out.println("INFO: Confirming, first element is: {" + Quotes.quotes.get(0) + "}");
	}
	
	public String selectQuote() 
	{
		return "";
	}
	
	public void createQuote() 
	{
		
	}

}
