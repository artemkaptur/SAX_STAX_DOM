package by.htp.parsinglibrary.run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import by.htp.parsinglibrary.parser.stax.STAXProcess;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.htp.parsinglibrary.bean.PrintedPublication;

public class STAXRunner {

	public static void main(String[] args) throws FileNotFoundException {

		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream("resources/Library.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			List<PrintedPublication> liabrary = STAXProcess.process(reader);
			for (PrintedPublication item : liabrary) {
				System.out.println("==============================================");
				System.out.println(item.toString());
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

	}

}
