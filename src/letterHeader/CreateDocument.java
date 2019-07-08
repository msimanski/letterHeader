package letterHeader;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

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
	static XWPFRun addressRunner = address.createRun();
	// remember to make a runner for each email
	static ArrayList<XWPFRun> phoneRunners = new ArrayList<XWPFRun>();
	static ArrayList<XWPFRun> emailRunners = new ArrayList<XWPFRun>();
	
	public static void main(String[] args) throws Exception 
	{	
		// create IO stream with document name
		FileOutputStream out = new FileOutputStream( new File("createdocument.docx"));
		
		CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
		CTPageMar pageMar = sectPr.addNewPgMar();
		pageMar.setLeft(BigInteger.valueOf(720L));
		pageMar.setTop(BigInteger.valueOf(720L));
		pageMar.setRight(BigInteger.valueOf(720L));
		pageMar.setBottom(BigInteger.valueOf(720L));
		
		// storing the ID automatically makes the objects
		int phoneID = addListParagraph("phone");
		int emailID = addListParagraph("email");
		
		// make name
		nameRunner.setText("Michael Simanski \n");
		nameRunner.setBold(true);
		nameRunner.setFontSize(18);
		nameRunner.setFontFamily("Times");
		
		// make address
		addressRunner.setText("2907 S 10th Ave, Altoona, PA 16601 \n");
		nameRunner.setFontSize(12);
		nameRunner.setFontFamily("Times");
		
		// make phone
		phoneRunners.get(phoneID).setText("(814) 414 - 9770");
		phoneRunners.get(phoneID).setFontSize(12);
		phoneRunners.get(phoneID).setFontFamily("Times");
		
		// make email
		emailRunners.get(emailID).setText("mfsimanski@gmail.com");
		emailRunners.get(emailID).setFontSize(12);
		emailRunners.get(emailID).setFontFamily("Times");
		
		document.write(out);
		out.close();
		

	}
	
	public static int addListParagraph(String type) 
	{
		switch (type) 
		{
			case "phone":
				phoneNumbers.add(document.createParagraph());
				phoneRunners.add(phoneNumbers.get(phoneNumbers.size() - 1).createRun());
				return phoneNumbers.size() - 1;
				
			case "email":
				emails.add(document.createParagraph());
				emailRunners.add(emails.get(emails.size() - 1).createRun());
				return emails.size() - 1;
				
			default:
				System.out.println("ERROR: Paragraph type not found!");
				return 0;
		}
	}

}
