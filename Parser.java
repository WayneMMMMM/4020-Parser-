import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class Parser {
	
	public static void main(String[] args) {
	//load dataset	
	File input = new File ("4020a1-datasets.txt");
	//parse dataset
	DatasetParser myPaser= new DatasetParser(input);
	


	//making http requests, get xml from server
	APIConnector api = new APIConnector(myPaser.getArticlesMap());
	api.getXML();
	Map<String, String> results = api.getIdMap();
	

	//write result to final file
	XMLWriter myWriter = new XMLWriter("./groupID_result.xml", results);
	myWriter.writeFile();
	
	
	
	}
}



