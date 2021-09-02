package Long_Assginment_802;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Long_Assginment_902.Validator;

public class LibraryManagement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Publication> listPub = new ArrayList<Publication>();

		do {
			System.out.println("================== LIBRARY MANAGEMENT SYSTEM ==================");
			System.out.println("1. Add new book");
			System.out.println("2. Add new Magazine");
			System.out.println("3. Display Book and Magazine");
			System.out.println("4. Add author book");
			System.out.println("5. Display Top 10");
			System.out.println("6. Search book");
			System.out.println("================================================================");
			System.out.println("Enter your option");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				Publication book = new Book();
				listPub.add(input(book, sc));
				break;
			case 2:
				Publication magazine = new Magazine();
				listPub.add(input(magazine, sc));
				break;
			case 3:
				showPub(listPub, sc);
				break;
			case 4:
				addOnAuthor(listPub, sc);
				break;
			case 5:
				selectTop10volume(listPub);
				break;
			case 6:
				searchBook(listPub, sc);
				break;
			case 0:
				System.exit(0);
			}
		} while (true);
	}

	private static void searchBook(List<Publication> listPub, Scanner sc) {
		Magazine mg1 = new Magazine(2015, "a1", "DN", "Quynh", 15, 10);
		Magazine mg2 = new Magazine(2015, "a1", "DN", "Nhat", 15, 10);
		listPub.add(mg1);
		listPub.add(mg2);
		Collections.sort(listPub, new Comparator<Publication>() {
			@Override
			public int compare(Publication o1, Publication o2) {
				if (o1 instanceof Book && o2 instanceof Book) {
					if (((Book) o1).getIsbn().compareTo(((Book) o2).getIsbn()) > 0) {
						return 1;
					} else if (((Book) o1).getIsbn().compareTo(((Book) o2).getIsbn()) < 0) {
						return -1;
					} else {
						if (((Book) o1).getPublicationDate().compareTo(((Book) o2).getPublicationDate()) > 0) {
							return 1;
						} else if (((Book) o1).getPublicationDate().compareTo(((Book) o2).getPublicationDate()) < 0) {
							return -1;
						} else {
							return 0;
						}
					}
				}
				return 0;
			}
		});

		System.out.println("What do you search atributte ? ");
		System.out.println("1. Search book by isbn");
		System.out.println("2. Search book by author");
		System.out.println("3. Search book by publisher");
		int choose = Integer.parseInt(sc.nextLine());
		switch (choose) {
		case 1:
			System.out.println("Enter ISBN");
			String ibsn = sc.nextLine();
			if (checkContainBook(listPub)) {
				System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Publication Year", "Publisher",
						"Publication Date", "ISBN", "Author", "Publication Place");
				for (Publication publication : listPub) {
					if (publication instanceof Book) {
						if (((Book) publication).getIsbn().equals(ibsn)) {
							publication.display();
						}
					}
				}
			}
			break;
		case 2:
			System.out.println("Enter author");
			String author = sc.nextLine();
			if (checkContainBook(listPub)) {
				System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Publication Year", "Publisher",
						"Publication Date", "ISBN", "Author", "Publication Place");
				for (Publication publication : listPub) {
					if (publication instanceof Book) {
						for (String string : ((Book) publication).getAuthor()) {
							if (string.equals(author)) {
								publication.display();
							}
						}
					}
				}
			}
			break;
		case 3:
			System.out.println("Enter publisher");
			String publisher = sc.nextLine();
			if (checkContainBook(listPub)) {
				System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Publication Year", "Publisher",
						"Publication Date", "ISBN", "Author", "Publication Place");
				for (Publication publication : listPub) {
					if (publication instanceof Book) {
						if (((Book) publication).getPublisher().equals(publisher)) {
							publication.display();
						}
					}
				}
			}
			break;
		default:
			break;
		}
	}

	private static void selectTop10volume(List<Publication> listPub) {
		Magazine mg1 = new Magazine(2015, "a1", "DN", "Nhat", 15, 10);
		Magazine mg2 = new Magazine(2015, "a1", "DN", "Nhat", 10, 10);
		Magazine mg3 = new Magazine(2015, "a1", "DN", "Nhat", 11, 10);
		Magazine mg4 = new Magazine(2015, "a1", "DN", "Nhat", 20, 10);
		Magazine mg5 = new Magazine(2016, "a1", "DN", "Nhat", 10, 10);

		listPub.add(mg1);
		listPub.add(mg2);
		listPub.add(mg3);
		listPub.add(mg4);

		listPub.add(mg5);
		System.out.println();
		for (int i = 0; i < 5; i++) {
			if (listPub.get(i) instanceof Book) {
				listPub.remove(i);
			}
		}
		Collections.sort(listPub, new Comparator<Publication>() {
			@Override
			public int compare(Publication o1, Publication o2) {
				if (o1 instanceof Magazine && o2 instanceof Magazine) {
					if (((Magazine) o1).getVolume() > ((Magazine) o2).getVolume()) {
						return -1;
					} else if (((Magazine) o1).getVolume() < ((Magazine) o2).getVolume()) {
						return 1;
					} else
						return 0;
				}
				return 3;
			}
		});

		System.out.println();
		if (checkContainMagazine(listPub)) {
			System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Publication Year", "Publisher",
					"Publication Date", "Author", "Volume", "Edition");
			for (int i = 0; i < 4; i++) {
				if (listPub.get(i) instanceof Magazine) {
					listPub.get(i).display();
				}
			}
		}
	}

	private static boolean checkContainMagazine(List<Publication> listPub) {
		for (Publication publication : listPub) {
			if (publication instanceof Magazine) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkContainBook(List<Publication> listPub) {
		for (Publication publication : listPub) {
			if (publication instanceof Book) {
				return true;
			}
		}
		return false;
	}

	private static void addOnAuthor(List<Publication> listPub, Scanner sc) {
		for (Publication publication : listPub) {
			if (publication instanceof Book) {
				System.out.println("Enter ISBN for add on Author");
				String isbn = sc.nextLine();
				if (((Book) publication).getIsbn().equals(isbn)) {
					if (((Book) publication).getAuthor() == null) {
						Set<String> listAuthor = new HashSet<String>();
						int n = 0;
						do {
							System.out.println("Enter number of  Author ");
							n = Integer.parseInt(sc.nextLine());
							for (int i = 0; i < n; i++) {
								System.out.println("Enter author " + i);
								String author = sc.nextLine();
								listAuthor.add(author);
							}
						} while (n <= 0);
						((Book) publication).setAuthor(listAuthor);
						System.out.println("Add successfully");
					} else {
						System.out.println("Author existed");
					}
				}
			}
		}
	}

	private static void showPub(List<Publication> listPub, Scanner sc) {
		System.out.println("Enter publication year want to search");
		int year = Integer.parseInt(sc.nextLine());
		System.out.println("Enter publisher want to search");
		String publisher = sc.nextLine();
		for (Publication publication : listPub) {
			if (publication.getPublicationYear() == year && publication.getPublisher().equals(publisher)) {
				publication.display();
			}
		}
	}

	private static Publication input(Publication publication, Scanner sc) {
		System.out.println("Enter year pub");
		int pubYear = Validator.validDate(sc).getYear();
		publication.setPublicationYear(pubYear);
		System.out.println("Enter publisher");
		String publisher = sc.nextLine();
		publication.setPublisher(publisher);
		System.out.println("Enter date publication");
		String date = String.valueOf(Validator.validDate(sc).getDayOfMonth());
		publication.setPublicationDate(date);
		if (publication instanceof Book) {
			System.out.println("Enter ISBN");
			String isbn = sc.nextLine();
			((Book) publication).setIsbn(isbn);
			Set<String> listAuthor = new HashSet<String>();
			System.out.println("Enter number of  Author ");
			int n = Validator.validateNumber();
			for (int i = 0; i < n; i++) {
				System.out.println("Enter author name " + (i+1));
				String author = sc.nextLine();
				listAuthor.add(author);
			}
			((Book) publication).setAuthor(listAuthor.size() == 0 ? null : listAuthor);
			System.out.println("Enter place publication");
			String place = sc.nextLine();
			((Book) publication).setPublicationPlace(place);
			return publication;
		} else {
			System.out.println("Enter author");
			String author1 = sc.nextLine();
			((Magazine) publication).setAuthor(author1);
			System.out.println("Enter volume");
			int volume = Validator.validateNumber();
			((Magazine) publication).setVolume(volume);
			System.out.println("Enter edition");
			int edition = Validator.validateNumber();
			((Magazine) publication).setEdition(edition);
			return publication;
		}
	}

}
