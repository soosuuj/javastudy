package ex06_this;

public class MainWrapper {

  public static void main(String[] args) {

    //CahinCalculator 객체 선언 & 생성
    ChainCalculator myCalc = new ChainCalculator();
    
    // 객체 자체는 참조값이다.(객체가 어디있는지 주소만 저장하고 있음)
    System.out.println(myCalc); // 결과 : ex06_this.ChainCalculator@6f2b958e 
   
    //myCalc 객체가 호출한 printThis 메소드이기 때문에,
    //여기서 확인된 this 값은 myCalc 객체의 참조값과 같다.
    myCalc.printThis(); // "myCalc = this" , this는 클래스 안에서만 쓸 수 있기 때문에 main에서는 myCalc요거 쓰는데 같은거임
    
    
    //myCalc.addition(3).addition(2); //myCalc.addition(3) 실행 후 mycalc.addition(2)를 실행한다.
    //*myCalc.addition(3)의 결과(반환타입)는  myCalc 여야한다. 
  
    System.out.println();
    
    //myCalc 메소드 체이닝
    myCalc.on().addition(3).subtraction(2).multiplication(5).division(2).done();

    //0.0 + 3.0 + 2.0 * 5.0 / 2.0 = 2.5
    

    
    
  }


}
