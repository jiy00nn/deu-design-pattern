/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contrtoller;
import controller.BookRental;
import controller.BookStatus;
import controller.ReturnBook;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;
import org.junit.Test;
/**
 *
 * @author wndgk
 */
public class StateTset {
    @Test
    public void testStatus(){
        BookStatus  bookstatus = new BookStatus();
        BookRental bookrental = new BookRental();
        ReturnBook returnbook = new ReturnBook();
        UUID user_number = UUID.fromString("c658cb36-08d6-4a36-b14f-fb811c838697");
        UUID book_id = UUID.fromString("1fdaee1f-411f-4346-8692-333a2b950c2e");
        Calendar cal = new GregorianCalendar();
        Date date = new Date(cal.getTimeInMillis());
        cal.add(Calendar.DATE, +6);
        Date date2 = new Date(cal.getTimeInMillis());
//        bookstatus.setStatu(bookrental);
//        bookstatus.status(user_number, book_id, date, date2);
        bookstatus.setStatu(returnbook);
        bookstatus.status(user_number, book_id, date, date2);
    }
}
