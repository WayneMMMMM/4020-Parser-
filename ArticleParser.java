import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class ArticleParser extends DefaultHandler {
	
	// This boolean flag will turn true when the "id" tag is found.
	boolean idFlag = false;
	
	// This variable will hold the ID as a string if found.
	String id = null;
	
	public void startElement(String uri, String name, String qName, Attributes atts) {
		if(qName.equalsIgnoreCase("Id")) {
			idFlag = true;
		}
	}
	
	public void characters(char ch[], int start, int length) {		
		if (idFlag) {
			this.id = new String(ch, start, length);			
			idFlag = false;
		}
	}
	
	public String getId() {
		return this.id;
	}
	
}
