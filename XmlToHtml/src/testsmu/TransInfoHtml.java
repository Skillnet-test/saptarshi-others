package testsmu;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransInfoHtml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set t=new TreeSet();
		 t.add(null);
		 //t.add("saptarshi");
		 
		 //System.out.println(""+t.toString());
		  Map m=new TreeMap();		  
		  m.put(null, "saptarshi");
		  System.out.println(""+t.toString());
		/*try {
	        TransformerFactory tFactory=TransformerFactory.newInstance();

	        Source xslDoc=new StreamSource("StyleSheets/test-Stylesheet.xsl");
	        Source xmlDoc=new StreamSource("xmls/test-smu.xml");

	        String outputFileName="CompanyInfo.html";

	        OutputStream htmlFile=new FileOutputStream(outputFileName);
	        Transformer trasform=tFactory.newTransformer(xslDoc);
	        trasform.transform(xmlDoc, new StreamResult(htmlFile));
	    } 
	    catch (FileNotFoundException e) 
	    {
	        e.printStackTrace();
	    }
	    catch (TransformerConfigurationException e) 
	    {
	        e.printStackTrace();
	    }
	    catch (TransformerFactoryConfigurationError e) 
	    {
	        e.printStackTrace();
	    }
	    catch (TransformerException e) 
	    {
	        e.printStackTrace();
	    }
*/	}
		
		

	


}
