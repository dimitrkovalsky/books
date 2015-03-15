package com.liberty;

import com.graphaware.reco.generic.context.Mode;
import com.graphaware.reco.generic.result.Recommendation;
import com.liberty.models.Book;
import com.liberty.reco.BookRecommendationEngine;
import com.liberty.services.AuthorService;
import com.liberty.services.BookService;
import com.liberty.services.GenreService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * User: Dmytro_Kovalskyi
 * Date: 13.03.2015
 * Time: 14:55
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        GenreService genreService = context.getBean(GenreService.class);
        AuthorService authorService = context.getBean(AuthorService.class);
        BookService bookService = context.getBean(BookService.class);
        //  authorService.getAllAuthors().forEach(System.out::println);
        //  System.out.println(genreService.getGenre("Drama"));
        Book book = bookService.getBook(246);
        System.out.println(book);

        BookRecommendationEngine engine = new BookRecommendationEngine();
        List<Recommendation<Book>> recommend = engine.recommend(book, Mode.REAL_TIME, 6);
        for (Recommendation<Book> bookRecommendation : recommend) {
            System.out.println("Score : " + bookRecommendation.getScore().getTotalScore() + "\t" + bookRecommendation.getItem());
        }
//        Author author = new Author(241l);
//        System.out.println(bookService.getAllAuthorBooks(author));
    }
}
