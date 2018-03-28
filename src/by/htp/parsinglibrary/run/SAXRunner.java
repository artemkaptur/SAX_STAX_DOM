package by.htp.parsinglibrary.run;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.parsinglibrary.bean.PrintedPublication;
import by.htp.parsinglibrary.parser.sax.SAXHandler;

public class SAXRunner {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		XMLReader reader = XMLReaderFactory.createXMLReader();
		SAXHandler handler = new SAXHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("resources/Library.xml"));

		List<PrintedPublication> library = handler.getPrintedPublicationList();
		for (PrintedPublication item : library) {
			System.out.println("==============================================");
			System.out.println(item.toString());
		}

	}

}
