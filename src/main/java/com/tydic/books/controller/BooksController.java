package com.tydic.books.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tydic.books.pojo.Books;
import com.tydic.books.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/AfterLogIn/books")
public class BooksController {
    @Autowired
    @Qualifier("booksServiceImpl")
    private BooksService booksService;

    private int begin = 0;
    private int pageSize = 5;
    private int allBooksAmout;
//    @RequestMapping("/showAllBooks")
//    public String selectAllBooks(Model model){
////        List<Books> allBooksList = booksService.getAllBooks();
//        allBooksAmout = this.getAllBooksAmount();
//        System.out.println("allBooksAmount=>"+allBooksAmout);
//        List<Books> allBooks = booksService.getBooksByPage(begin,pageSize);
//        model.addAttribute("booksList",allBooks);
//        return "showAllBooks";
//    }
//    private int getAllBooksAmount(){
//        return booksService.getBooksAmout();
//    }
    @RequestMapping("/showAllBooks")
    public String selectAllBooks(Model model, @RequestParam(value = "pageNum",required = true,defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",required = true,defaultValue = "5") int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Books> allBooks = booksService.getAllBooks();
        PageInfo<Books> pageInfo = new PageInfo<>(allBooks);
        model.addAttribute("pageInfo",pageInfo);
        return "showAllBooks";
    }

    @RequestMapping("/toAddBooks")
    public String toAddBooks(Model model){
        return "toAddBooks";
    }

    @RequestMapping("/addBooks")
    public String addBooks(Books books){
        System.out.println("addBooks=>"+books);
        booksService.addBooks(books);
        return "redirect:/AfterLogIn/books/showAllBooks";
    }

    @RequestMapping("/toUpdateBooks/{bookID}")
    public String ToUpdateBooks(@PathVariable("bookID") int bookID,Model model){
        Books booksById = booksService.getBooksById(bookID);
        model.addAttribute("books",booksById);
        return "toUpdateBooks";
    }

    @RequestMapping("/updateBooks")
    public String updateBooks(Books books){
        System.out.println("updateBooks=>"+books);
        booksService.updateBooks(books);
        return "redirect:/AfterLogIn/books/showAllBooks";
    }

    @RequestMapping("/deleteBooks/{bookID}")
    public String deleteBooksById(@PathVariable("bookID") int bookID){
        booksService.deleteBooksById(bookID);
        return "redirect:/AfterLogIn/books/showAllBooks";
    }

    @RequestMapping("/queryBooks")
    public String queryBooks(String bookName, Model model){
//        System.out.println("访问=>查询书籍");
        List<Books> booksByName = booksService.getBooksByName(bookName);
        System.out.println(booksByName);
        if(booksByName == null || booksByName.isEmpty()){
            model.addAttribute("failToFindBooks","未能查询到相关书籍");
            booksByName = booksService.getAllBooks();
        }
//        System.out.println(booksByName);
        PageInfo<Books> pageInfo = new PageInfo<>(booksByName);
        model.addAttribute("pageInfo",pageInfo);
        return "showAllBooks";
    }

}
