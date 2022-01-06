package com.tydic.books.dao;

import com.tydic.books.pojo.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BooksMapper {
    public List<Books> getAllBooks();
    public Books getBooksById(int booksID);
    public int addBooks(Books books);
    public int updateBooks(Books books);
    public int deleteBooksById(int bookID);
    public List<Books> getBooksByName(@Param("bookName") String bookName);
    public int getBooksAmount();
}
