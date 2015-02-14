package parseXML;

import java.io.File;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class Dom4j {
	public static void main(String[] args)
	{
		try {
			SAXReader reader=new SAXReader();
			String file="C:/test.xml";
			Document document=reader.read(new File(file));
			Element root=document.getRootElement();
			for(Iterator<?> i=root.elementIterator("VALUE"); i.hasNext();)
			{
				Element element=(Element)i.next();
				System.out.println(element.element("NO").getText());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
