package Package;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Book 
{
    private String title;
    private String author;

    public Book(String title, String author)
    {
        this.title = title;
        this.author = author;
    }
    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return author;
    }
}

class Library
{
    private Map<Integer, Book> books = new HashMap<>();
    private List<Book> borrowedBooks = new ArrayList<>();
    private int bookIdCounter = 1;

    public void addBook(String title, String author)
    {
        Book newBook = new Book(title, author);
        books.put(bookIdCounter++, newBook);
        System.out.println("Book added: " + newBook.getTitle() + " by " + newBook.getAuthor());
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            Book book = entry.getValue();
        }
    }

    public void borrowBook(int bookId) 
    {
        if (books.containsKey(bookId)) 
        {
            Book selectedBook = books.get(bookId);
                borrowedBooks.add(selectedBook);
                System.out.println("Book borrowed: " + selectedBook.getTitle());
            } 
            else
            {
                System.out.println("Book is not available for borrowing.");
            }
        } 
           
    public void returnBook(int bookId) 
    {
        for (Book borrowedBook : borrowedBooks) 
        {
            if (books.containsKey(bookId) && borrowedBook.equals(books.get(bookId)))
            {
                borrowedBooks.remove(borrowedBook);
                System.out.println("Book returned: " + borrowedBook.getTitle());
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " was not borrowed from the library.");
    }
}

public class LibraryManagement {
    public static void main(String[] args) 
    {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                    
                case 2:
                    System.out.print("Enter the ID of the book to borrow: ");
                    int borrowId = scanner.nextInt();
                    library.borrowBook(borrowId);
                    break;
                    
                case 3:
                    System.out.print("Enter the ID of the book to return: ");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;
                    
                case 4:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}