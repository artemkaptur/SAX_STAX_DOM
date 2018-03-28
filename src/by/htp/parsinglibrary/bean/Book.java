package by.htp.parsinglibrary.bean;

import java.util.ArrayList;
import java.util.List;

public class Book extends PrintedPublication {

	private List<Author> authors = new ArrayList<>();
	private String genre;
	private int yearOfPublication;

	public Book() {
		super();
	}

	public Book(String ableToBorrow, int currentCount, int daysForBorrwing, String title, int countOfPages) {
		super(ableToBorrow, currentCount, daysForBorrwing, title, countOfPages);
	}

	public Book(PrintedPublication item) {
		super(item);
	}

	public Book(List<Author> authors, String genre, int yearOfPublication) {
		super();
		this.authors = authors;
		this.genre = genre;
		this.yearOfPublication = yearOfPublication;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	@Override
	public String toString() {
		return super.toString() + " [authors=" + authors + ", genre=" + genre + ", yearOfPublication="
				+ yearOfPublication + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + yearOfPublication;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (yearOfPublication != other.yearOfPublication)
			return false;
		return true;
	}

}
