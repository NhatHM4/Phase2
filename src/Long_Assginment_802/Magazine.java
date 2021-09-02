package Long_Assginment_802;

public class Magazine extends Publication {
	private String author;
	private int volume;
	private int edition;

	public Magazine() {
		// TODO Auto-generated constructor stub
	}

	public Magazine(int publicationYear, String publisher, String publicationDate, String author, int volume,
			int edition) {
		super(publicationYear, publisher, publicationDate);
		this.author = author;
		this.volume = volume;
		this.edition = edition;
	}

	@Override
	public void display() {
		System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", super.getPublicationYear(), super.getPublisher(),
				super.getPublicationDate(), this.author, this.volume, this.edition);

	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

}
