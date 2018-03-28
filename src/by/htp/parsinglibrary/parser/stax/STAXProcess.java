package by.htp.parsinglibrary.parser.stax;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.htp.parsinglibrary.bean.Author;
import by.htp.parsinglibrary.bean.Book;
import by.htp.parsinglibrary.bean.Magazine;
import by.htp.parsinglibrary.bean.Newspaper;
import by.htp.parsinglibrary.bean.PrintedPublication;
import by.htp.parsinglibrary.parser.LibraryTagName;
import by.htp.parsinglibrary.parser.XMLStreamConstants;

public class STAXProcess {

	public static List<PrintedPublication> process(XMLStreamReader reader) throws XMLStreamException {
		List<PrintedPublication> library = new ArrayList<PrintedPublication>();
		PrintedPublication item = null;
		Book bItem = null;
		Magazine mItem = null;
		Newspaper nItem = null;
		List<Author> authors = new ArrayList<>();
		Author author = new Author();
		LibraryTagName elementName = null;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = LibraryTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case BOOK: {
					item = new Book();
					bItem = new Book();
					String ableToBorrow = reader.getAttributeValue(null, "able_to_borrow");
					item.setAbleToBorrow(ableToBorrow);
					break;
				}
				case MAGAZINE: {
					item = new Magazine();
					String ableToBorrow = reader.getAttributeValue(null, "able_to_borrow");
					item.setAbleToBorrow(ableToBorrow);
					break;
				}
				case NEWSPAPER: {
					item = new Newspaper();
					String ableToBorrow = reader.getAttributeValue(null, "able_to_borrow");
					item.setAbleToBorrow(ableToBorrow);
					break;
				}
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
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
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				elementName = LibraryTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case BOOK:
					library.add(bItem);
					bItem = null;
					authors = new ArrayList<>();
					break;
				case MAGAZINE:
					library.add(mItem);
					mItem = null;
					break;
				case NEWSPAPER:
					library.add(nItem);
					nItem = null;
					break;
				}
			}
		}
		return library;
	}
}
