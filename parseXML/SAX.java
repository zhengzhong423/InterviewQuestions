package parseXML;

import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX extends DefaultHandler { 
	Stack<String> tags=new Stack<String>();
	String str="";
	
	public static void main(String args[]) 
	{ 
		long lasting = System.currentTimeMillis(); 
		try { 
			SAXParserFactory sf = SAXParserFactory.newInstance(); 
			SAXParser sp = sf.newSAXParser(); 
			SAX reader = new SAX(); 
			sp.parse(new InputSource("C:/test.xml"), reader); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		System.out.println("Runtime: " + (System.currentTimeMillis() - lasting) + "ms");
	} 
	
	public void characters(char ch[], int start, int length) throws SAXException 
	{ 
		str=new String(ch, start, length);
	} 
	public void startElement(String uri,String localName,String qName,Attributes attrs) 
	{ 
		str="";
	} 
	public void endElement(String uri,String localName,String qName) 
	{ 
		if(qName.equals("ADDR"))
			System.out.println("Address "+str);
		if(qName.equals("NO")) 
			System.out.println("No. " + str);
		if(qName.equals("VALUE"))
			System.out.println();
	} 
} 

