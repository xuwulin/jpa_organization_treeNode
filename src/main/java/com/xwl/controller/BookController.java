package com.xwl.controller;

import com.xwl.bean.Book;
import com.xwl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sang on 2018/7/16.
 */
@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/findAll")
    public void findAll() {
        PageRequest pageable = PageRequest.of(1, 2);
        Page<Book> page = bookService.getBookByPage(pageable);
        System.out.println("总页数:"+page.getTotalPages());
        System.out.println("总记录数:"+page.getTotalElements());
        System.out.println("查询结果:"+page.getContent());
        System.out.println("当前页数:"+(page.getNumber()+1));
        System.out.println("当前页记录数:"+page.getNumberOfElements());
        System.out.println("每页记录数:"+page.getSize());
    }
    @GetMapping("/search")
    public void search() {
        List<Book> bs1 = bookService.getBookByIdAndAuthor("鲁迅", 7);
        List<Book> bs2 = bookService.getBooksByAuthorStartingWith("吴");
        List<Book> bs3 = bookService.getBooksByIdAndName("西", 8);
        List<Book> bs4 = bookService.getBooksByPriceGreaterThan(30F);
        Book b = bookService.getMaxIdBook();
        System.out.println("bs1:"+bs1);
        System.out.println("bs2:"+bs2);
        System.out.println("bs3:"+bs3);
        System.out.println("bs4:"+bs4);
        System.out.println("b:"+b);
    }

    @PostMapping("/save")
    public Book save() {
        Book book = new Book();
        book.setAuthor("鲁迅");
        book.setName("呐喊");
        book.setPrice(24F);
        return bookService.addBook(book);
    }

    @PostMapping("/saveAll")
    public List<Book> saveAll() {
        List<Book> list = new ArrayList<>();
        Book book1 = new Book();
        book1.setAuthor("老子");
        book1.setName("道德经");
        book1.setPrice(200F);
        Book book2 = new Book();
        book2.setAuthor("周文王");
        book2.setName("易经");
        book2.setPrice(200F);
        list.add(book1);
        list.add(book2);
        return bookService.addBooks(list);
    }

    @PutMapping("/update")
    public void updateBook() {
        String name = "彷徨";
        Integer id = 1;
        int res = bookService.modifyByName(name, 1);
        System.out.println(res);
    }

    @DeleteMapping("/delete")
    public void deleteBook() {
        Integer id = 1;
        int res = bookService.deleteBook(id);
        System.out.println(res);
    }

}
