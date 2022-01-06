package com.tydic.books.service;

import com.github.pagehelper.PageHelper;
import com.tydic.books.dao.BooksMapper;
import com.tydic.books.pojo.Books;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksMapper booksMapper;
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<Books> getAllBooks() {
        return booksMapper.getAllBooks();
    }

    @Override
    public Books getBooksById(int booksID) {
        return booksMapper.getBooksById(booksID);
    }

    @Override
    public int addBooks(Books books) {
        return booksMapper.addBooks(books);
    }

    @Override
    public int updateBooks(Books books) {
        return booksMapper.updateBooks(books);
    }

    @Override
    public int deleteBooksById(int bookID) {
        return booksMapper.deleteBooksById(bookID);
    }

    @Override
    public List<Books> getBooksByName(String bookName) {
        return booksMapper.getBooksByName(bookName);
    }

//    @Override
//    public List<Books> getBooksByPage(int begin, int pageSize) {
//        RowBounds rowBounds = new RowBounds(begin,pageSize);
//        List<Books> booksList = sqlSessionTemplate.selectList("com.tydic.dao.BooksMapper.getAllBooks", null, rowBounds);
//        return booksList;
//    }

    @Override
    public List<Books> getBooksByPage(int begin, int pageSize) {
        PageHelper.startPage(begin,pageSize);
        List<Books> allBooks = booksMapper.getAllBooks();
//        PageInfo<Books> pageInfo = new PageInfo<>(allBooks);
        return allBooks;
    }

    @Override
    public int getBooksAmout() {
        return booksMapper.getBooksAmount();
    }
}
