package com.library.maven;
import java.util.*;

public class App
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        String title, author;
        ArrayList<Book> books;
        Shelf shelf = new Shelf();
        shelf.loadFromFile();

        System.out.println("Welcome to the library! How can I help you?");

        while (true)
        {
            command = scanner.nextLine().trim().toLowerCase();
            if(command.equals("add"))
            {
                System.out.println("Title: ");
                title = scanner.nextLine();
                System.out.println("Author: ");
                author = scanner.nextLine();
                shelf.addBook(title, author);
            }
            else if (command.equals("rent"))
            {
                System.out.println("Title: ");
                title = scanner.nextLine();
                System.out.println("Author: ");
                author = scanner.nextLine();
                shelf.removeBook(title, author);
            }
            else if (command.equals("show"))
            {
                books = shelf.showBooks();
                if (books.isEmpty())
                {
                    System.out.println("Sorry, we're out of books right now! Get lost!");
                }
                else
                {
                    for (Book book : books)
                    {
                        System.out.println("Title: " + book.getTitle() + "   Author: " + book.getAuthor());
                    }
                }
            }
            else if (command.equals("exit"))
            {
                shelf.saveToFile();
                System.out.println("Goodbye!");
                break;
            }
            else
            {
                System.out.println("Unknown command! Choose from 'add', 'rent', 'show' and 'exit'");
            }
        }
    }
}
