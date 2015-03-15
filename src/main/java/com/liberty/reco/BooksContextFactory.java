package com.liberty.reco;

import com.graphaware.reco.generic.context.FilteringContextFactory;
import com.graphaware.reco.generic.filter.Filter;
import com.graphaware.reco.neo4j.filter.ExcludeSelf;
import com.liberty.models.Book;
import org.neo4j.graphdb.Node;

import java.util.Arrays;
import java.util.List;

/**
 * User: dimitr
 * Date: 15.03.2015
 * Time: 13:17
 */
public class BooksContextFactory extends FilteringContextFactory<Book, Book> {
    @Override
    protected List<Filter<Book, Book>> filters() {
        return Arrays.<Filter<Book, Book>>asList(
                new ExcludeSelfBook()
        );
    }
}
