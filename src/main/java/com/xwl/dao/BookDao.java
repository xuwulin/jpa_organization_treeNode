package com.xwl.dao;

import com.xwl.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2018/7/15.
 */
@Transactional
public interface BookDao extends JpaRepository<Book,Integer>{
    List<Book> getBooksByAuthorStartingWith(String author);

    List<Book> getBooksByPriceGreaterThan(Float price);

    @Query(value = "select * from t_book where id=(select max(id) from t_book)",nativeQuery = true)
    Book getMaxIdBook();

    @Query("select b from t_book b where b.id>:id and b.author=:author")
    List<Book> getBooksByIdAndAuthor(@Param("author") String author, @Param("id") Integer id);

    @Query("select b from t_book b where b.id<?2 and b.name like %?1%")
    List<Book> getBooksByIdAndName(String name, Integer id);

    @Modifying
    @Query("update t_book b set b.name = :name where b.id = :id")
    int modifyByName(@Param("name") String name ,@Param("id") Integer id);

    @Modifying
    @Query("delete from t_book b where b.id = ?1")
    int deleteBook(Integer id);

}
