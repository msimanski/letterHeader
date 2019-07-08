package letterHeader;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CreateDocument 
{
	// create blank document
	static XWPFDocument document = new XWPFDocument();
	
	// create paragraphs for header
	static XWPFParagraph name = document.createParagraph();
	static XWPFParagraph address = document.createParagraph();
	static ArrayList<XWPFParagraph> phoneNumbers = new ArrayList<XWPFParagraph>();
	static ArrayList<XWPFParagraph> emails = new ArrayList<XWPFParagraph>();
			
	// create runner objects
	static XWPFRun nameRunner = name.createRun();
	static XWPFRun addressRunner = name.createRun();
	// remember to make a runner for each email
	static ArrayList<XWPFRun> phoneRunners = new ArrayList<XWPFRun>();
	static ArrayList<XWPFRun> emailRunners = new ArrayList<XWPFRun>();
	
	public static void main(String[] args) throws Exception 
	{	
		// create IO stream with document name
		FileOutputStream out = new FileOutputStream( new File("createdocument.docx"));
		
		document.write(out);
		out.close();
		

	}
	
	public static void addListParagraph(String type, String text) 
	{
		switch (type) 
		{
			case "phone":
				phoneNumbers.add(document.createParagraph());
				phoneRunners.add(emails.get(emails.size() - 1).createRun());
				break;
				
			case "email":
				
				break;
				
			default:
				
		}
	}

}
