package Long_Assginment_802;

public abstract class Publication {
	private int publicationYear;
	private String publisher;
	private String publicationDate;
	
	public Publication() {
		// TODO Auto-generated constructor stub
	}

	public Publication(int publicationYear, String publisher, String publicationDate) {
		this.publicationYear = publicationYear;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
	}

	public abstract void display();
	
	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	
}
