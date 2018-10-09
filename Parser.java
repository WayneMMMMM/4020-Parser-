import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class Parser {
	
	public static void main(String[] args) {
		
	File input = new File ("4020a1-datasets.txt");
	DatasetParser myPaser= new DatasetParser(input);
	

	
	
	APIConnector api = new APIConnector(myPaser.getArticlesMap());
	api.getXML();
	
	Map<String, String> results = api.getIdMap();
	

	
	XMLWriter myWriter = new XMLWriter("./groupID_result.xml", results);
	myWriter.writeFile();
	
	
	
	}
}



