package by.htp.parsinglibrary.bean;

public class Newspaper extends PrintedPublication {

	private String topic;
	private String date;
	private String frequency;

	public Newspaper() {
		super();
	}

	public Newspaper(String ableToBorrow, int currentCount, int daysForBorrwing, String title, int countOfPages) {
		super(ableToBorrow, currentCount, daysForBorrwing, title, countOfPages);
	}

	public Newspaper(PrintedPublication item) {
		super(item);
	}

	public Newspaper(String topic, String date, String frequency) {
		super();
		this.topic = topic;
		this.date = date;
		this.frequency = frequency;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return super.toString() + " [topic=" + topic + ", date=" + date + ", frequency=" + frequency + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
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
		Newspaper other = (Newspaper) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (frequency == null) {
			if (other.frequency != null)
				return false;
		} else if (!frequency.equals(other.frequency))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}

}
