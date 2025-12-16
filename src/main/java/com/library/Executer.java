package com.library;
import java.util.Scanner;

public class Executer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n==== Library Tracker Menu ====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register User");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Search Book by Title");
            System.out.println("7. Search Book by Author");
            System.out.println("8. View All Books");
            System.out.println("9. View All Users");
            System.out.println("0. Exit");
            System.out.println("===============================");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bID, title, author));
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeID = sc.nextInt();
                    library.removeBook(removeID);
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int uID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    library.registerUser(new User(uID, name));
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    int borrowUserID = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int borrowBookID = sc.nextInt();
                    library.borrowBook(borrowUserID, borrowBookID);
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    int returnUserID = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int returnBookID = sc.nextInt();
                    library.returnBook(returnUserID, returnBookID);
                    break;

                case 6:
                    System.out.print("Enter Title to Search: ");
                    String searchTitle = sc.nextLine();
                    library.searchBookByTitle(searchTitle);
                    break;

                case 7:
                    System.out.print("Enter Author to Search: ");
                    String searchAuthor = sc.nextLine();
                    library.searchBookByAuthor(searchAuthor);
                    break;

                case 8:
                    library.viewBooks();
                    break;

                case 9:
                    library.viewUsers();
                    break;

                case 0:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

