package ex09_Eatable;

public class AppleMango extends Food implements Eatable { //먹을 수 있는 음식
  
  public AppleMango(String name) {
    super(name); // 슈퍼 클래스의 생성자 호출 public Food(String name){ } 생성자 호출
  }              // 슈퍼 클래스 생성자 있으면 자식 클래스도 반드시 생성자 있어야함!!!

}
