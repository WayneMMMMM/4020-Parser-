
import java.io.FileOutputStream;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriter {
	String xmlFilePath;
	Map<String,String> results;
	Document document;
	Element e=null;
	
	
	public  XMLWriter(String xmlFilePath, Map<String,String> results){
		
		try {
			            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			            document = documentBuilder.newDocument();
			            
			            this.xmlFilePath=xmlFilePath;
			            this.results=results;
			            
			        } catch (ParserConfigurationException e) {
			            e.printStackTrace();
			       
			        }
	}
	
	
		
	public void writeFile(){	
						
		
						System.out.println("Begin to write xml file...");
						
						
						try{
						// PubmedArticleSet element
						
			            Element root = document.createElement("PubmedArticleSet");
			            
			            for (String title : results.keySet()){
			            	
			            String id = results.get(title);
			            
			            //create PubmedArticle element
			            Element PubmedArticle = document.createElement("PubmedArticle");
			            
			         
			            //create PMID element and set its value
			            Element  PMID= document.createElement("PMID");
			            PMID.setTextContent(id);
			            PubmedArticle.appendChild(PMID);
	
			            //create ArticleTitle element and set its value
			            Element ArticleTitle = document.createElement("ArticleTitle");
			            ArticleTitle.setTextContent(title);
			            PubmedArticle.appendChild(ArticleTitle);
			            
			            //add it to the root
			            root.appendChild(PubmedArticle);
			            
			            }
			            
			            
			            
			            document.appendChild(root);
			            
			            // create the XML file
			            //transform the DOM Object to an XML File			          
			            Transformer tr = TransformerFactory.newInstance().newTransformer();
			            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			            tr.setOutputProperty(OutputKeys.INDENT, "yes");
			            // send DOM to file
			            tr.transform(new DOMSource(document), 
			                                 new StreamResult(new FileOutputStream(xmlFilePath)));

			
			            System.out.println("Done creating XML File!");
						}catch (Exception e){
							e.printStackTrace();
						}
						
						
	}
	

	
	}


