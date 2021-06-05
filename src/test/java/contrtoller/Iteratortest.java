/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contrtoller;

import controller.BookSearchIterator;
import controller.IteratorBookSearch;
import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author wndgk
 */
public class Iteratortest {

    @Test
    public void testIterator() {        
        BookSearchIterator booksearchiterator = new BookSearchIterator("Fox and Crane");
        IteratorBookSearch iteratorbooksearch = new IteratorBookSearch(booksearchiterator);
        iteratorbooksearch.printList();
    }
}
