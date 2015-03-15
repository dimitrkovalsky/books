package com.liberty.utils;

import com.liberty.services.BookService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: dimitr
 * Date: 15.03.2015
 * Time: 13:33
 */
public class ServiceFactory {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

    private static BookService bookService = context.getBean(BookService.class);

    public static BookService getBookService() {
        return bookService;
    }

}
