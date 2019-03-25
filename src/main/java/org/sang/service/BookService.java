package org.sang.service;

import org.sang.dao.BookDao;
import org.sang.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sang on 2018/7/15.
 */
@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    // 保存单个实体
    public Book addBook(Book book) {
        return bookDao.save(book);
    }

    // 保存多个实体
    public List<Book> addBooks(Iterable<Book> books) {
        return bookDao.saveAll(books);
    }

    public Page<Book> getBookByPage(Pageable pageable) {
        return bookDao.findAll(pageable);
    }

    public List<Book> getBooksByAuthorStartingWith(String author){
        return bookDao.getBooksByAuthorStartingWith(author);
    }

    public List<Book> getBooksByPriceGreaterThan(Float price){
        return bookDao.getBooksByPriceGreaterThan(price);
    }

    public Book getMaxIdBook(){
        return bookDao.getMaxIdBook();
    }

    public List<Book> getBookByIdAndAuthor(String author, Integer id){
        return bookDao.getBooksByIdAndAuthor(author, id);
    }

    public List<Book> getBooksByIdAndName(String name, Integer id){
        return bookDao.getBooksByIdAndName(name, id);
    }

    public int modifyByName(String name, Integer id) {
        return bookDao.modifyByName(name, id);
    }

    public int deleteBook(Integer id) {
        return bookDao.deleteBook(id);
    }


}