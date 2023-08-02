package ex04_Library;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;  // 필드에 스캐너 잡아서 모든 메소드에서 쓸 수 있음

public class Library  {
  
  private List<Book> books;     //선언
  private Scanner sc;           //선언   -> 그냥 쓰면 nullPointException 오류 
  private boolean found;
  
   //new Library()
  public Library() {
    books = new ArrayList<Book>();  //생성
    sc = new Scanner(System.in);    // 생성
  }
  
  /**
   * 등록<br>
   * 책의 제목과 가격을 입력 받아서 List<Book> books에 저장하는 메소드
   * @throws InputMismatchException 책의 가격을 정수로 입력하지 않았을 때 발생하는 예외
   */
  private void addBook() throws InputMismatchException{ // 자동완성, addBook 호출하는 manage로 던짐
    System.out.println("=== 등록 ===");
    System.out.println("책제목 입력");
    String title = sc.next(); // 공백 포함
    System.out.println("책 가격 입력");
    int price = sc.nextInt();       //정수 입력 아닐시 InputMismatchException ->  addBook 호출하는 곳으로 미룸
    books.add(new Book(title, price));
    System.out.println(title + "책이 등록되었습니다.");
  }
  
  /**
   * 삭제<br>
   * 책의 제목을 입력 받아서 해당 제목을 가진 Book 객체를 List<Book> books에서 삭제하는 메소드
   * @throws RuntimeException 책이 0권이거나 삭제할 책의 제목이 입력되지 않았을 때 발생하는 예외
   */
  private void deleteBook() throws RuntimeException {
    System.out.println("=== 삭제 ===");
    if(books.isEmpty()) {
      throw new RuntimeException("도서관에 등록된 책이 없습니다.");
    }
    System.out.println("삭제할 책의 제목 입력 >>> ");
    //String
    String title = sc.next();
    // 비교 - 입력된게 없음
    if(title.isEmpty()) {
      throw new RuntimeException("삭제할 책의 제목이 입력되지 않았습니다.");
    }
    // 객체 기반 삭제(동일한 객체를 찾아서 삭제)
    // 동일한 객체인지 비교하기 위해서는 Book 클래스에 equals 메소드가 오버라이드 되어있어야 한다.
    // 앞에가 입력된 책, 뒤에는 도서관 책
    for(Book book : books ) {
      if(title.equals(book.getTitle())) {
        books.remove(book); // 2번째 remove 객체 비교니까
        System.out.println(book + "책이 삭제되었습니다.");
        // 같으면 deleteBook 메소드 실행을 끝내겠다
        return;
      }
    }
    // 똑같은 제목이 없을 때 이리로 온다
    System.out.println(title + "제목을 가진 책이 없습니다.");
  }
  
  /**
 * 수정<br>
   * 수정할 책의 제목을 입력 받아서 해당 책의 가격을 수정하는 메소드
   * @throws RuntimeException 책이 0권이거나 수정할 책의 제목이 입력되지 않았을 때 발생하는 예외
   * @throws InputMismatchException 책의 가격을 정수로 입력하지 않았을 때 발생하는 예외
   */
  
  private void modifyBook() throws RuntimeException, InputMismatchException {
    System.out.println("=== 수정 ===");
    if(books.isEmpty()) {
      throw new RuntimeException("도서관에 등록된 책이 없습니다.");
    }
    System.out.println("수정할 책의 제목 입력 >>> ");
    String title = sc.next();
    if(title.isEmpty()) {
      throw new RuntimeException("수정할 책의 제목이 입력되지 않았습니다.");
    }
    for(Book book : books) {
      if(title.equals(book.getTitle())) {
        System.out.println("수정할 책의 가격 입력 >>> ");
        int price = sc.nextInt();
        book.setPrice(price);
        System.out.println(title + " 책의 가격이 " + price + "원으로 수정되었습니다.");
        return;
      }
    }
    System.out.println(title + " 제목을 가진 책이 없습니다.");
  }
  /**
   * 조회<br>
   * 조회할 책의 제목을 입력 받아서 해당 책의 정보를 출력하는 메소드
   * @throws RuntimeException 책이 0권이거나 삭제할 책의 제목이 입력되지 않았을 때 발생하는 예외
   */
  /*
  private void queryBook() throws RuntimeException{
    System.out.println("=== 조회 ===");
    if(books.isEmpty()) {
      throw new RuntimeException("도서관에 등록된 책이 없습니다.");
    }
    System.out.println("조회할 책의 제목 입력 >>> ");
    String title = sc.next();
    if(title.isEmpty()) {
      throw new RuntimeException("조회할 책의 제목이 입력되지 않았습니다.");
    }
    boolean found = false;
    for(Book book : books) {
      if(title.equals(book.getTitle())) {
        //queryBook();
        System.out.println("책이 조회 되었습니다.");
        found = true;
        break;
      }
      if(!found) {
        System.out.println(title + "제목을 가진 책이 없습니다.");
      } else {
        System.out.println("책이 조회되었습니다.");
      }
    }
}
  */
  private void queryBook() {
    System.out.println("=== 조회 ===");
    if(books.isEmpty()) {
      throw new RuntimeException("도서관에 등록된 책이 없습니다.");
    }
    System.out.println("조회할 책의 제목 입력 >>> ");
    String title = sc.next();
    if(title.isEmpty()) {
      throw new RuntimeException("조회할 책의 제목이 입력되지 않았습니다.");
    }
    for(Book book : books) {
      if(title.equals(book.getTitle())) {
        System.out.println("조회결과" + book);
        return;
      }
    }
    System.out.println(title + " 제목을 가진 책이 없습니다.");
  }
  
  /**
   * 전체조회<br>
   * List<Book> books의 모든 Book 객체를 순서대로 출력하는 메소드
   * @throws RuntimeException 책이 0권일 때 발생하는 예외
   */
  private void queryAllBook() throws RuntimeException {
    System.out.println("===전체조회===");
    int size = books.size();
    System.out.println("전체 보유 도서 수 : " + size + "권");
    if(books.isEmpty()) {     // Array -> books
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
      case "1": addBook(); break;      //addBook 여기서 try  -> catch로 넘어감
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
