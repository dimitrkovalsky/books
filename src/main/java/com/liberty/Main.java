package com.liberty;

import com.liberty.services.AuthorService;
import com.liberty.services.GenreService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

      //  authorService.getAllAuthors().forEach(System.out::println);
        System.out.println(genreService.getGenre("Drama"));
        System.out.println(authorService.getAuthor("Huxley"));
    }
}
