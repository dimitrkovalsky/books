package com.liberty.reco;

import com.graphaware.reco.generic.context.Context;
import com.graphaware.reco.generic.engine.SingleScoreRecommendationEngine;
import com.graphaware.reco.generic.transform.ParetoScoreTransformer;
import com.graphaware.reco.generic.transform.ScoreTransformer;
import com.liberty.models.Book;
import com.liberty.services.BookService;
import com.liberty.utils.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * User: dimitr
 * Date: 15.03.2015
 * Time: 10:51
 */
public class SameAuthorEngine extends SingleScoreRecommendationEngine<Book, Book> {
    private BookService bookService = ServiceFactory.getBookService();

    @Override
    protected Map<Book, Float> doRecommendSingle(Book input, Context<Book, Book> context) {
        Map<Book, Float> result = new HashMap<>();
        Iterable<Book> books = bookService.getAllAuthorBooks(input.getAuthor());
        if (books != null)
            books.forEach(b -> addToResult(result, b, 1));
        return result;
    }

    @Override
    protected ScoreTransformer scoreTransformer() {
        return new ParetoScoreTransformer(100, 10);
    }

    @Override
    public String name() {
        return "SameAuthorEngine";
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
