import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean checkedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}

class LibraryManagementCatalog {
    private ArrayList<Book> books;

    public LibraryManagementCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        books.add(newBook);
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book searchByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    public void checkOutBook(String title) {
        Book book = searchByTitle(title);
        if (book != null && !book.isCheckedOut()) {
            book.setCheckedOut(true);
            System.out.println("Book checked out successfully!");
        } else {
            System.out.println("Book is either not available or already checked out.");
        }
    }

    public void returnBook(String title) {
        Book book = searchByTitle(title);
        if (book != null && book.isCheckedOut()) {
            book.setCheckedOut(false);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book is either not checked out or not found.");
        }
    }
}

public class Library{
    public static void main(String[] args) {
        LibraryManagementCatalog catalog = new LibraryManagementCatalog();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Book\n2. Search by Title\n3. Search by Author\n4. Check Out Book\n5. Return Book\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    catalog.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book foundByTitle = catalog.searchByTitle(searchTitle);
                    if (foundByTitle != null) {
                        System.out.println("Book found: " + foundByTitle.getTitle() + " by " + foundByTitle.getAuthor());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    Book foundByAuthor = catalog.searchByAuthor(searchAuthor);
                    if (foundByAuthor != null) {
                        System.out.println("Book found: " + foundByAuthor.getTitle() + " by " + foundByAuthor.getAuthor());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter book title to check out: ");
                    String checkOutTitle = scanner.nextLine();
                    catalog.checkOutBook(checkOutTitle);
                    break;
                case 5:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    catalog.returnBook(returnTitle);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

