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

/**
 * CheckoutBook의 정보를 담고 있는 DTO class이다.
 */
public class CheckoutBookDto {
    private String user_id;
    private String book_id;
    private String date;
    
    CheckoutBookDto() {}
    
    CheckoutBookDto(String user_id, String book_id, String date) {
        super();
        this.user_id = user_id;
        this.book_id = book_id;
        this.date = date;
    }
    
    public String getUserId(){
        return user_id;
    }
    
    public void setUserId(String user_id){
        this.user_id = user_id;
    }
    
    public String getBookId(){
        return book_id;
    }
    
    public void setBookId(String book_id){
        this.book_id = book_id;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
}
