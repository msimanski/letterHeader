package letterHeader;

import java.util.ArrayList;

// class representing and controlling an individual quote belonging to quotes
public class Quote 
{
	public int id;
	public String text;
	public String author;
	public ArrayList<String> tags;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public ArrayList<String> getTags()
	{
		return tags;
	}
	public void setTags(ArrayList<String> tags)
	{
		this.tags = tags;
	}
}
