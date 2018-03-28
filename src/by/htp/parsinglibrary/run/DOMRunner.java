package by.htp.parsinglibrary.run;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.htp.parsinglibrary.bean.Book;
import by.htp.parsinglibrary.bean.Magazine;
import by.htp.parsinglibrary.bean.Newspaper;
import by.htp.parsinglibrary.bean.PrintedPublication;

public class DOMRunner {

	public static void main(String[] args) {

		DocumentBuilder docBuilder = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.err.println("Ошибка конфигурации парсера: " + e);
		}

		Document document = null;
		try {
			document = docBuilder.parse("resources/Library.xml");
		} catch (SAXException e) {
			System.err.println("Parsing failure: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("File error or I/O error: " + e);
			e.printStackTrace();
		}

		Element root = document.getDocumentElement();
		List<PrintedPublication> library = new ArrayList<PrintedPublication>();
		NodeList bItemNodes = root.getElementsByTagName("book");
		Book bItem = null;

		for (int i = 0; i < bItemNodes.getLength(); i++) {
			bItem = new Book();
			Element itemElement = (Element) bItemNodes.item(i);

			bItem.setAbleToBorrow(itemElement.getAttribute("able_to_borrow"));
			bItem.setCountOfPages(
					Integer.parseInt(getSingleChild(itemElement, "count_of_pages").getTextContent().trim()));
			bItem.setCurrentCount(
					Integer.parseInt(getSingleChild(itemElement, "current_count").getTextContent().trim()));
			bItem.setDaysForBorrwing(
					Integer.parseInt(getSingleChild(itemElement, "days_for_borrowing").getTextContent().trim()));
			bItem.setTitle(getSingleChild(itemElement, "title").getTextContent().trim());
			bItem.setGenre(getSingleChild(itemElement, "genre").getTextContent().trim());
			bItem.setYearOfPublication(Integer.parseInt(getSingleChild(itemElement, "year").getTextContent().trim()));
			library.add(bItem);
		}

		NodeList mItemNodes = root.getElementsByTagName("magazine");
		Magazine mItem = null;
		for (int i = 0; i < mItemNodes.getLength(); i++) {
			mItem = new Magazine();
			Element itemElement = (Element) mItemNodes.item(i);

			mItem.setAbleToBorrow(itemElement.getAttribute("able_to_borrow"));
			mItem.setCountOfPages(
					Integer.parseInt(getSingleChild(itemElement, "count_of_pages").getTextContent().trim()));
			mItem.setCurrentCount(
					Integer.parseInt(getSingleChild(itemElement, "current_count").getTextContent().trim()));
			mItem.setDaysForBorrwing(
					Integer.parseInt(getSingleChild(itemElement, "days_for_borrowing").getTextContent().trim()));
			mItem.setTitle(getSingleChild(itemElement, "title").getTextContent().trim());
			mItem.setContent(getSingleChild(itemElement, "content").getTextContent().trim());
			mItem.setRealeseDate(getSingleChild(itemElement, "release_date").getTextContent().trim());
			mItem.setPeriodicity(getSingleChild(itemElement, "periodicity").getTextContent().trim());
			library.add(mItem);
		}

		NodeList nItemNodes = root.getElementsByTagName("newspaper");
		Newspaper nItem = null;
		for (int i = 0; i < nItemNodes.getLength(); i++) {
			nItem = new Newspaper();
			Element itemElement = (Element) nItemNodes.item(i);

			nItem.setAbleToBorrow(itemElement.getAttribute("able_to_borrow"));
			nItem.setCountOfPages(
					Integer.parseInt(getSingleChild(itemElement, "count_of_pages").getTextContent().trim()));
			nItem.setCurrentCount(
					Integer.parseInt(getSingleChild(itemElement, "current_count").getTextContent().trim()));
			nItem.setDaysForBorrwing(
					Integer.parseInt(getSingleChild(itemElement, "days_for_borrowing").getTextContent().trim()));
			nItem.setTitle(getSingleChild(itemElement, "title").getTextContent().trim());
			nItem.setTopic(getSingleChild(itemElement, "topic").getTextContent().trim());
			nItem.setDate(getSingleChild(itemElement, "date").getTextContent().trim());
			nItem.setFrequency(getSingleChild(itemElement, "frequency").getTextContent().trim());
			library.add(nItem);
		}

		for (PrintedPublication i : library) {
			System.out.println("==============================================");
			System.out.println(i.toString());
		}
	}

	private static Element getSingleChild(Element element, String childName) {
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}

}
