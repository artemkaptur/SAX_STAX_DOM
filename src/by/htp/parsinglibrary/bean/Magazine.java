package by.htp.parsinglibrary.bean;

public class Magazine extends PrintedPublication {

	private String content;
	private String realeseDate;
	private String periodicity;

	public Magazine() {
		super();
	}

	public Magazine(String ableToBorrow, int currentCount, int daysForBorrwing, String title, int countOfPages) {
		super(ableToBorrow, currentCount, daysForBorrwing, title, countOfPages);
	}

	public Magazine(PrintedPublication item) {
		super(item);
	}

	public Magazine(String content, String realeseDate, String periodicity) {
		super();
		this.content = content;
		this.realeseDate = realeseDate;
		this.periodicity = periodicity;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRealeseDate() {
		return realeseDate;
	}

	public void setRealeseDate(String realeseDate) {
		this.realeseDate = realeseDate;
	}

	public String getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return super.toString() + " [content=" + content + ", realeseDate=" + realeseDate + ", periodicity="
				+ periodicity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((periodicity == null) ? 0 : periodicity.hashCode());
		result = prime * result + ((realeseDate == null) ? 0 : realeseDate.hashCode());
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
		Magazine other = (Magazine) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (periodicity == null) {
			if (other.periodicity != null)
				return false;
		} else if (!periodicity.equals(other.periodicity))
			return false;
		if (realeseDate == null) {
			if (other.realeseDate != null)
				return false;
		} else if (!realeseDate.equals(other.realeseDate))
			return false;
		return true;
	}

}
