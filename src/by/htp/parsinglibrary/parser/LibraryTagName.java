package by.htp.parsinglibrary.parser;

public enum LibraryTagName {
	CURRENT_COUNT, DAYS_FOR_BORROWING, TITLE, COUNT_OF_PAGES, AUTHORS, AUTHOR, NAME, SURNAME, GENRE, YEAR, CONTENT, RELEASE_DATE, PERIODICITY, TOPIC, DATE, FREQUENCY, BOOK, MAGAZINE, NEWSPAPER, PRINTED_PUBLICATIONS, LIBRARY;

	public static LibraryTagName getElementTagName(String element) {
		switch (element) {
		case "book":
			return BOOK;
		case "magazine":
			return MAGAZINE;
		case "newspaper":
			return NEWSPAPER;
		case "current_count":
			return CURRENT_COUNT;
		case "days_for_borrowing":
			return DAYS_FOR_BORROWING;
		case "title":
			return TITLE;
		case "count_of_pages":
			return COUNT_OF_PAGES;
		case "authors":
			return AUTHORS;
		case "author":
			return AUTHOR;
		case "name":
			return NAME;
		case "surname":
			return SURNAME;
		case "genre":
			return GENRE;
		case "year":
			return YEAR;
		case "content":
			return CONTENT;
		case "release_date":
			return RELEASE_DATE;
		case "periodicity":
			return PERIODICITY;
		case "topic":
			return TOPIC;
		case "date":
			return DATE;
		case "frequency":
			return FREQUENCY;
		case "printed_publications":
			return PRINTED_PUBLICATIONS;
		case "library":
			return LIBRARY;
		default:
			throw new EnumConstantNotPresentException(LibraryTagName.class, element);
		}
	}

}
