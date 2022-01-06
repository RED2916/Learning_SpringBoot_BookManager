package com.tydic.books.service;

import com.tydic.books.pojo.Books;

import java.util.List;

public interface BooksService {
    public List<Books> getAllBooks();
    public Books getBooksById(int booksID);
    public int addBooks(Books books);
    public int updateBooks(Books books);
    public int deleteBooksById(int bookID);
    public List<Books> getBooksByName(String bookName);
    public List<Books> getBooksByPage(int begin,int pageSize);
    public int getBooksAmout();
}
