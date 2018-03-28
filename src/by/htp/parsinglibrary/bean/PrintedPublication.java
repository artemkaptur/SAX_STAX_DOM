package by.htp.parsinglibrary.bean;

public abstract class PrintedPublication {

	private String ableToBorrow;
	private int currentCount;
	private int daysForBorrwing;
	private String title;
	private int countOfPages;

	public PrintedPublication() {
		super();
	}

	public PrintedPublication(String ableToBorrow, int currentCount, int daysForBorrwing, String title,
			int countOfPages) {
		super();
		this.ableToBorrow = ableToBorrow;
		this.currentCount = currentCount;
		this.daysForBorrwing = daysForBorrwing;
		this.title = title;
		this.countOfPages = countOfPages;
	}

	public PrintedPublication(PrintedPublication item) {
		super();
		this.ableToBorrow = item.getAbleToBorrow();
		this.currentCount = item.getCurrentCount();
		this.daysForBorrwing = item.getDaysForBorrwing();
		this.title = item.getTitle();
		this.countOfPages = item.getCountOfPages();
	}

	public String getAbleToBorrow() {
		return ableToBorrow;
	}

	public void setAbleToBorrow(String ableToBorrow) {
		this.ableToBorrow = ableToBorrow;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getDaysForBorrwing() {
		return daysForBorrwing;
	}

	public void setDaysForBorrwing(int daysForBorrwing) {
		this.daysForBorrwing = daysForBorrwing;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCountOfPages() {
		return countOfPages;
	}

	public void setCountOfPages(int countOfPages) {
		this.countOfPages = countOfPages;
	}

	@Override
	public String toString() {
		return "[ableToBorrow=" + ableToBorrow + ", currentCount=" + currentCount + ", daysForBorrwing="
				+ daysForBorrwing + ", title=" + title + ", countOfPages=" + countOfPages + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ableToBorrow == null) ? 0 : ableToBorrow.hashCode());
		result = prime * result + countOfPages;
		result = prime * result + currentCount;
		result = prime * result + daysForBorrwing;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrintedPublication other = (PrintedPublication) obj;
		if (ableToBorrow == null) {
			if (other.ableToBorrow != null)
				return false;
		} else if (!ableToBorrow.equals(other.ableToBorrow))
			return false;
		if (countOfPages != other.countOfPages)
			return false;
		if (currentCount != other.currentCount)
			return false;
		if (daysForBorrwing != other.daysForBorrwing)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
