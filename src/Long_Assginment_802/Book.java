package Long_Assginment_802;

import java.util.Set;

public class Book extends Publication {
	private String isbn;
	private Set<String> author;
	private String publicationPlace;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int publicationYear, String publisher, String publicationDate, String isbn, Set<String> author,
			String publicationPlace) {
		super(publicationYear, publisher, publicationDate);
		this.isbn = isbn;
		this.author = author;
		this.publicationPlace = publicationPlace;
	}

	@Override
	public void display() {
		System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", super.getPublicationYear(), super.getPublisher(),
				super.getPublicationDate(), this.getIsbn(), this.getAuthor().toString(), this.publicationPlace);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<String> getAuthor() {
		return author;
	}

	public void setAuthor(Set<String> author) {
		this.author = author;
	}

	public String getPublicationPlace() {
		return publicationPlace;
	}

	public void setPublicationPlace(String publicationPlace) {
		this.publicationPlace = publicationPlace;
	}

}
