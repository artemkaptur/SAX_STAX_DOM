package by.htp.parsinglibrary.parser.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.parsinglibrary.bean.Author;
import by.htp.parsinglibrary.bean.Book;
import by.htp.parsinglibrary.bean.Magazine;
import by.htp.parsinglibrary.bean.Newspaper;
import by.htp.parsinglibrary.bean.PrintedPublication;
import by.htp.parsinglibrary.parser.LibraryTagName;

public class SAXHandler extends DefaultHandler {

	private List<PrintedPublication> PrintedPublicationList = new ArrayList<PrintedPublication>();
	private PrintedPublication item;
	private List<Author> authors = new ArrayList<>();
	private Author author;
	private Book bItem;
	private Magazine mItem;
	private Newspaper nItem;
	private StringBuilder text;

	public List<PrintedPublication> getPrintedPublicationList() {
		return PrintedPublicationList;
	}

	public void startDocument() throws SAXException {
		System.out.println("Parsing started.");
	}

	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("startElement -> " + "uri: " + uri + ", localName: " + localName + ", qName: " + qName);

		text = new StringBuilder();
		if (qName.equals("book")) {
			item = new Book();
			item.setAbleToBorrow(attributes.getValue("able_to_borrow"));
		}
		if (qName.equals("magazine")) {
			item = new Magazine();
			item.setAbleToBorrow(attributes.getValue("able_to_borrow"));
		}
		if (qName.equals("newspaper")) {
			item = new Newspaper();
			item.setAbleToBorrow(attributes.getValue("able_to_borrow"));
		}
		if (qName.equals("author")) {
			author = new Author();
		}
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		LibraryTagName tagName = LibraryTagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch (tagName) {
		case CURRENT_COUNT:
			item.setCurrentCount(Integer.valueOf(text.toString()));
			break;
		case DAYS_FOR_BORROWING:
			item.setDaysForBorrwing(Integer.valueOf(text.toString()));
			break;
		case TITLE:
			item.setTitle(text.toString());
			break;
		case COUNT_OF_PAGES:
			item.setCountOfPages(Integer.valueOf(text.toString()));
			break;
		case AUTHORS:
			bItem = new Book(item);
			bItem.setAuthors(authors);
			break;
		case AUTHOR:
			authors.add(author);
			break;
		case NAME:
			author.setName(text.toString());
			;
			break;
		case SURNAME:
			author.setSurname(text.toString());
			;
			break;
		case GENRE:
			bItem.setGenre(text.toString());
			break;
		case YEAR:
			bItem.setYearOfPublication(Integer.valueOf(text.toString()));
			break;
		case CONTENT:
			mItem = new Magazine(item);
			mItem.setContent(text.toString());
			break;
		case RELEASE_DATE:
			mItem.setRealeseDate(text.toString());
			break;
		case PERIODICITY:
			mItem.setPeriodicity(text.toString());
			break;
		case TOPIC:
			nItem = new Newspaper(item);
			nItem.setTopic(text.toString());
			break;
		case DATE:
			nItem.setDate(text.toString());
			break;
		case FREQUENCY:
			nItem.setFrequency(text.toString());
			break;
		case BOOK:
			PrintedPublicationList.add(bItem);
			bItem = null;
			authors = new ArrayList<>();
			break;
		case MAGAZINE:
			PrintedPublicationList.add(mItem);
			mItem = null;
			break;
		case NEWSPAPER:
			PrintedPublicationList.add(nItem);
			nItem = null;
			break;
		}
	}

	public void warning(SAXParseException exception) {
		System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void error(SAXParseException exception) {
		System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
		throw (exception);
	}

}
