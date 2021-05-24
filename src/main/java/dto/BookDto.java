/**
 * @packageName     : dto
 * @filewName       : BookDto.java
 * @author          : Jiyoon Bak
 * @date            : 2021.05.07
 * @description     : MVC Patterns에서 사용하는 Model
 * =======================================================
 *      DATE         AUTHOR          NOTE
 * -------------------------------------------------------
 * 2021.05.07        JiYoon Bak     최초 생성
 */
package dto;
import java.util.UUID;

/**
 * BookDto의 정보를 담고 있는 DTO class이다.
 */
public class BookDto {
    private UUID id;
    private String title;
    private String genre;
    private String author;
    private String status;
    private int count;
    public BookDto(){}
    
    // 모든 필드의 값을 생성자의 인자로 전달 받는 생성자 generate
    public BookDto(UUID id, String title, String genre, String author, String status, int count){
        super();
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.status = status;
        this.count = count;
    }
    
       public BookDto(UUID id, String title, String genre, String author){
        super();
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }
    public UUID getId(){
        return id;
    }
    
    public void setId(UUID id){
        this.id = id;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getGenre(){
        return genre;
    }
    
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public int getCount(){
        return count;
    }
    
    public void setCount(int count){
        this.count = count;
    }
}
