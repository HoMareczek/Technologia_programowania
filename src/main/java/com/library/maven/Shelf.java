package com.library.maven;
import java.util.*;
import java.io.*;

public class Shelf
{
    private ArrayList<Book> books = new ArrayList<Book>();
    String title, author;
    Book book;

    public void addBook(String title, String author)
    {
        book = new Book(title, author);
        books.add(book);
        System.out.println("Book added!");
    }

    public void removeBook(String title, String author)
    {
        List<Book> toRent = new ArrayList<Book>();
        for (Book book : books)
        {
            if (title.equals(book.getTitle()) && author.equals(book.getAuthor()))
            {
                toRent.add(book);
                System.out.println("Book rented!");
                break;
            }
        }
        if (!toRent.isEmpty())
        {
            books.removeAll(toRent);
        }
        else
        {
            System.out.println("Sorry, this book is not on the shelf");
        }
    }

    public ArrayList<Book> showBooks()
    {
        return books;
    }

    public void saveToFile()
    {
        try(PrintWriter writer = new PrintWriter(new File("data/books.txt")))
        {
            for (Book book : books)
            {
                writer.println(book.getTitle() + ";" + book.getAuthor());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadFromFile()
    {
        books.clear();
        try (Scanner scanner = new Scanner(new File("data/books.txt")))
        {
            while (scanner.hasNextLine())
            {
                String[] parts = scanner.nextLine().split(";");
                if (parts.length == 2)
                {
                    books.add(new Book(parts[0], parts[1]));
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("There seems to be a problem with our books");
        }
    }
}