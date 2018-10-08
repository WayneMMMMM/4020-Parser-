
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Parser {

	 
	 
	public static void main(String[] args) {
	File input = new File ("4020a1-datasets.txt");
	

	//deviding tasks
	DatasetPaser myPaser= new DatasetPaser(input);


	APIConnector api1 = new APIConnector(myPaser.getArticlesMap(0,800));
	APIConnector api2 = new APIConnector(myPaser.getArticlesMap(800,1600));
	APIConnector api3 = new APIConnector(myPaser.getArticlesMap(1600,2400));
	APIConnector api4 = new APIConnector(myPaser.getArticlesMap(2400,3200));
	APIConnector api5 = new APIConnector(myPaser.getArticlesMap(4000,4800));
	APIConnector api6 = new APIConnector(myPaser.getArticlesMap(4800,myPaser.getListLength()));
	//APIConnector api7 = new APIConnector(myPaser.getArticlesMap(3000,3500));
	//APIConnector api8 = new APIConnector(myPaser.getArticlesMap(3500,4000));
	//APIConnector api9 = new APIConnector(myPaser.getArticlesMap(4000,4500));
	//APIConnector api10 = new APIConnector(myPaser.getArticlesMap(4500,myPaser.getListLength()));
	
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
	//give task to thread 4
	Thread t4 = new Thread(new Runnable() {
        public void run() {
        	
        	api4.getXML();
        	
        }
    });
	
	//give task to thread 5
	Thread t5 = new Thread(new Runnable() {
        public void run() {
        	
        	api5.getXML();
        	
        }
    });
	//give task to thread 6
	Thread t6 = new Thread(new Runnable() {
        public void run() {
        	
        	api6.getXML();
        	
        }
    });
	//give task to thread 7
	//Thread t7 = new Thread(new Runnable() {
		//public void run() {
        	
        	//api7.getXML();
        	
       // }
   // });
	//give task to thread 8
	//Thread t8 = new Thread(new Runnable() {
       // public void run() {
        	
        //	api8.getXML();
        	
        //}
    //});	
	//give task to thread 9
	//Thread t9 = new Thread(new Runnable() {
       // public void run() {
        	
        //	api9.getXML();
        	
       // }
   // });
	//give task to thread 10
	//Thread t10 = new Thread(new Runnable() {
      //  public void run() {
        	
        //	api10.getXML();
        	
       // }
    //});
	
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	t5.start();
	t6.start();
	//t7.start();
	//t8.start();
	//t9.start();
	//t10.start();
	
	//write all result from the threads to the file
	try{ 
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		t6.join();
		//t7.join();
		//t8.join();
		//t9.join();
		//t10.join();
	
	
	Map<String, String> subResult1 = api1.getIdMap();
	Map<String, String> subResult2 = api2.getIdMap();
	Map<String, String> subResult3 = api3.getIdMap();
	Map<String, String> subResult4 = api4.getIdMap();
	Map<String, String> subResult5 = api5.getIdMap();
	Map<String, String> subResult6 = api6.getIdMap();
	//Map<String, String> subResult7 = api7.getIdMap();
	//Map<String, String> subResult8 = api8.getIdMap();
	//Map<String, String> subResult9 = api9.getIdMap();
	//Map<String, String> subResult10 = api10.getIdMap();
	
	
	Map<String, String> results = new HashMap<>();
	results.putAll(subResult1);
	results.putAll(subResult2);
	results.putAll(subResult3);
	results.putAll(subResult4);
	results.putAll(subResult5);
	results.putAll(subResult6);
	//results.putAll(subResult7);
	//results.putAll(subResult8);
	//results.putAll(subResult9);
	//results.putAll(subResult10);
	
	
	XMLWriter myWriter = new XMLWriter("/Users/Wayne/test.txt", results);
	myWriter.writeFile();
	
	}catch (Exception e){
		e.printStackTrace();
	}
	
	}
}



