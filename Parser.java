
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Parser {

	 
	 
	public static void main(String[] args) {
	File input = new File ("4020a1-datasets.txt");
	
	
	Map<String, String> subResult1;
	Map<String, String>	subResult2;
	Map<String, String> subResult3;	
	//deviding tasks
	DatasetPaser myPaser1= new DatasetPaser(input,0,1766);
	DatasetPaser myPaser2= new DatasetPaser(input,1766,3532);
	DatasetPaser myPaser3= new DatasetPaser(input,3532,5299);
	APIConnector api1 = new APIConnector(myPaser1.getArticlesMap());
	APIConnector api2 = new APIConnector(myPaser2.getArticlesMap());
	APIConnector api3 = new APIConnector(myPaser3.getArticlesMap());
	
	//give task to thread 1
	Thread t1 = new Thread(new Runnable() {
        public void run() {
        	
        	api1.getXML();
        	
        }
    });
	
	//give task to thread 2
	Thread t2 = new Thread(new Runnable() {
        public void run() {
        	
        	api2.getXML();
        	
        }
    });
	//give task to thread 3
	Thread t3 = new Thread(new Runnable() {
        public void run() {
        	
        	api3.getXML();
        	
        }
    });
	
	t1.start();
	t2.start();
	t3.start();
	
	
	if ((!t1.isAlive()) && (!t2.isAlive()) && (!t3.isAlive())){
	
	subResult1 = api1.getIdMap();
	subResult2 = api2.getIdMap();
	subResult3 = api3.getIdMap();
	
	
	
	
	Map<String, String> results = new HashMap<>();
	results.putAll(subResult1);
	results.putAll(subResult2);
	results.putAll(subResult3);
	
	XMLWriter myWriter = new XMLWriter("/Users/Wayne/test.txt", results);
	myWriter.writeFile();
	}
	
	
	}
}



