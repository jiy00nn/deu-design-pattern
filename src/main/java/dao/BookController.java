
package dao;
import dto.BookDto;
import dao.BookDao;
import view.TestView;
import java.util.UUID;
/**
 *
 * @author ysj62
 */
public class BookController {
    private BookDto bookdto;
    private BookDao bookdao;
    private TestView view;
    
 public BookController(BookDto bookdto,BookDao bookdao){
 this.bookdto=bookdto;
 this.bookdao=bookdao;
 }  
    
 
 public boolean Upate(){ //추가
         boolean result = true;
        
        if(!(bookdao.book.isEmpty())){      //데이터베이스가 공백인지 확인하기 위한 조건문
            for(int i = 0; i < bookdao.book.size(); i++){   //입력받은 아이디가 이미 사용중인지 확인하기 위한 for문
                if(bookdto.getId()==(bookdao.book.get(i).getId())){
                    result = false;
                    System.out.println("이미 사용중인 아이디입니다.");
                    System.out.println("This ID is already in use.");
                    break;
                }
            }
            if(result){     //입력받은 아이디가 사용가능한 아이디일 경우
                bookdao.UpdataData( bookdto.getId(),bookdto.getTitle(), bookdto.getGenre(),bookdto.getAuthor(),bookdto.getStatus(),bookdto.getCount());
                System.out.println("update success");
            }
        }
        else{            //데이터베이스가 공백일 경우
            bookdao.UpdataData( bookdto.getId(), bookdto.getTitle(), bookdto.getGenre(),bookdto.getAuthor(),bookdto.getStatus(),bookdto.getCount());
                System.out.println("update success");
        }
        
        return result;
    }
 public boolean Modify(){
              boolean result = true;
                //데이터베이스가 공백인지 확인하기 위한 조건문
            for(int i = 0; i < bookdao.book.size(); i++){   //입력받은 아이디가 있는지 
                if(bookdto.getId()==(bookdao.book.get(i).getId())){
                    result = false;
                    break;
                }
                else if(result){ // 있다는걸 확인하고 바꾼다.
                bookdao.ModifyBook();
            }
            

}
   return result;         
 }
}
