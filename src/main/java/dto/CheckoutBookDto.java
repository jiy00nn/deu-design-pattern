/**
 * @packageName     : dto
 * @filewName       : CheckoutBookDto.java
 * @author          : Jiyoon Bak
 * @date            : 2021.05.07
 * @description     : MVC Patterns에서 사용하는 Model
 * =======================================================
 *      DATE         AUTHOR          NOTE
 * -------------------------------------------------------
 * 2021.05.07        JiYoon Bak     최초 생성
 */
package dto;

import java.util.Date;
import java.util.UUID;

/**
 * CheckoutBook의 정보를 담고 있는 DTO class이다.
 */
public class CheckoutBookDto {
    private UUID user_id;
    private UUID book_id;
    private Date rental_date;
    private Date return_date;
    
    CheckoutBookDto() {}
    
    public CheckoutBookDto(UUID user_id, UUID book_id, Date rental_date, Date return_date) {
        super();
        this.user_id = user_id;
        this.book_id = book_id;
        this.rental_date = rental_date;
        this.return_date = return_date;
    }
    
    public UUID getUserId(){
        return user_id;
    }
    
    public void setUserId(UUID user_id){
        this.user_id = user_id;
    }
    
    public UUID getBookId(){
        return book_id;
    }
    
    public void setBookId(UUID book_id){
        this.book_id = book_id;
    }

    public Date getRental_date() {
        return rental_date;
    }

    public void setRental_date(Date rental_date) {
        this.rental_date = rental_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
    
   
    
}
