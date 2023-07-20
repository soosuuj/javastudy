package ex07_constructor;

public class MainWrapper {

  public static void main(String[] args) {
    
    //Computer myCom 객체 선언
    Computer myCom;
    
    //Computer  myCom 객체 생성
    myCom = new Computer();  //public Computer(){} 생성자가 호출된다.
          //생성자가 호출된다. -> 필드값 없는 것 -> setter 불러서 값을 채워 사용
    
    myCom.setModel("gram");
    System.out.println("mycom : " + myCom.getModel());    
    
    //Computer youCom 객체 선언
    Computer yourCom;
    
    //Computer youCom 객체 생성
    yourCom = new Computer("macbook"); //public Computer(String model){} 생성자가 호출된다.
            // 생성자가 호출된다.  생성자가 setter 역할을 함 //생성할 때 setter 기능까지 쓰고 싶으면 이렇게 사용
    
    System.out.println("yourCom : " + yourCom.getModel());
  }

}
