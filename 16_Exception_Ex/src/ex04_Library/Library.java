package ex04_Library;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;  // 필드에 스캐너 잡아서 모든 메소드에서 쓸 수 있음

public class Library  {
  
  private List<Book> books;     //선언
  private Scanner sc;           //선언   -> 그냥 쓰면 nullPointException 오류 
  
   //new Library()
  public Library() {
    books = new ArrayList<Book>();  //생성
    sc = new Scanner(System.in);    // 생성
  }
  
/**
 * 등록<br>
 * 
 */
  private void addBook() throws InputMismatchException{ // 자동완성, addBook 호출하는 manage로 던짐
    System.out.println("=== 등록 ===");
    System.out.println("책제목 입력");
    String title = sc.next(); // 공백 포함
    System.out.println("책 가격 입력");
    int price = sc.nextInt();
    books.add(new Book(title, price));
    System.out.println(title + "책이 등록되었습니다.");
  }
  
  /**
   * 삭제<br>
   * 
   */
  private void deleteBook() {
    
  }
  
  /**
   * 수정<br>
   * 
   */
  
  private void modifyBook() {
    
  }
  
  /**
   * 조회<br>
   */
  private void queryBook() {
    
  }
  
  /**
   * 전체 조회<br>
   */
  private void queryAllBook() throws RuntimeException {
    System.out.println("===전체조회===");
    int size = books.size();
    System.out.println("전체 보유 도서 수 : " + size + "권");
    if(books.isEmpty()) {
      throw new RuntimeException ("도서관에 등록된 책이 없습니다.");
    }
    for(int i = 0; i < size; i++) {
      System.out.println((i + 1) + "번째 도서 : " + books.get(i));
    }
    
  }
  
  /**
   * 운영<br>
   */
  
  public void manage()  {
    // 사용자가 종료 명령을 내릴 때까지 프로그램은 종료되지 않는다.
    
    
    while(true) { // 무한루프
      
      try {
        
      
      
      System.out.println("1. 등록 2. 삭제 3. 수정 4. 조회 5. 전체조회 0. 종료");
      String choice = sc.next();
      
      
      switch(choice) {
      case "1": addBook(); break;
      case "2": deleteBook(); break;
      case "3": modifyBook(); break;
      case "4": queryBook(); break;
      case "5": queryAllBook(); break;
      case "0": System.out.println("도서관리 프로그램을 종료합니다."); return;
      default: System.out.println("잘못된 입력입니다. 다시 시도하세요.");
      
      }
      
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

    } // while(true)
    
  }  // manage()
  
 
}
