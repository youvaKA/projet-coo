package competitions.competitors;

/**
 * this class represent competitors that will participate in a competition.
 */
public class Competitor {
	public String name;

	/**
	 * this is the constructor
	 * 
	 * @param n the name of the competitor.
	 */
	public Competitor(String n) {
		this.name = n;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return this.name;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Competitor))
			return false;
		Competitor other = (Competitor) o;
		if (this.name == null)
			return other.name == null;
		else
			return this.getName().equals(other.getName());
	}
}