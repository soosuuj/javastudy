package ex03_Class;

public class MainWrapper {

  public static void main(String[] args) {

    // Calculator 객체 선언 ( 배열이랑 비슷함)
    // 클래스의 이름을 객체의 타입으로 사용 , myCalc - 객체이름(변수이름)- 변수이름이라고 하지는 않음
    Calculator myCalc; 
    
    // Calculator 객체 생성  -> myCalc이 손으로 만질 수 있는 계산기
    // 객체 == 인스턴스 (메모리에 로드된 인스턴스)
    myCalc = new Calculator(); // 인스턴스화 : 메모리에 로드되었다. 
    
    // Calculator 만들지 않았는데 호출됨.. 
    //객체를 만들어주는 메소드는 개발자가 만들지 않으면 자바가 만들어줌
    
    // 계산하고자 하는 실수 2개 준비
    double a = 1.5;
    double b = 1.2;
    
    // 덧셈, 뺄셈, 곱셈, 나눗셈 메소드 호출
    System.out.println(myCalc.addition(a, b));   
    System.out.println(myCalc.subtraction(a, b));
    System.out.println(myCalc.multiplication(a, b));
    System.out.println(myCalc.division(a, b));
    
  }

}
 