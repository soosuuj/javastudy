package ex02_lambda;

/*
 * 람다 표현식
 * 1. Anonymous Inner Type 방식의 객체를 생성할 때 사용할 수 있는 새로운 표현식
 * 2. "추상 메소드가 하나"인 인터페이스에서 람다 표현식을 사용할 수 있다.
 *    (함수형 인터페이스 : 추상메소드가 하나인 인터페이스)
 * 3. 형식
 *    (매개변수) -> {
 *      본문;
 *      }
 */


/*
 * 람다 표현식 적용 예시
 * 1. 파라미터 x, 반환 x (파라미터의 타입은 생략한다.) 적으면 안됨
 *  () -> {
 *  System.out.println("Hello World");
 *  };
 *  
 *  () -> System.out.println("Hello World");  // 메소드 본문이 1줄이면 중활호{} 생략 가능
 *  
 *  2. 파라미터 o, 반환 x
 *  
 *    (name) -> {
 *     System.out.println("Hello +  name);
 *     }
 *     
 *     (name) ->  System.out.println("Hello " + name);
 *        
 *     
 *  3. 파라미터 x, 반환 o (반환 타입은 생략한다.)
 *  
 *    () -> { 
 *      String name = "tom";
 *      return name;
 *    }
 *    
 *    () -> {
 *    return "tom";
 *    }
 *    
 *    () -> return "tom";
 *    
 *    () -> "tom";  // 메소드에 return만 존재하면 return을 생략한다. 
 *                  // 단순하게 값만 반환하면 값만 쓰기
 *                  
 *  4. 파라미터 o, 반환 o
 *  
 *  // 이름을 전달하면 "님"을 붙여서 출력하고.
 *  // 해당 값을 반환하는 함수
 *  
 *  (name) -> {
 *  String reVal = name + "님"
 *  System.out.println(reVal);
 *  return reVal;
 *  }
 *  
 *  // 정수 값을 전달하면 해당 값보다 1이 큰 수를 반환하는 함수
 *  (n) -> n + 1;
 * 
 *  
 *  
 *  
 */



public class GasStation {
  
  private int totalOil;
  private int payPerLiter;
  private int earning;
  
  public GasStation() {

  }
  
  public void sellOil(String model, int oil) {
    
   // Car 인터페이스를 구현한 별도 클래스를 만들고, 해당 클래스 객체를 만들고, addOil()호출
   // Car's addOil()
    
   // Car car 지역변수(객체) 선언 (sellOil 메소드 호출 시 생성되고, sellOil 메소드 종료 시 소멸된다.
    Car car;
    
    // car 지역변수 (객체) 생성
    car = new Car() { //Car ctrl+space -> 인터페이스로 불러옴
      // 인터페이스에 new를 하고 싶으면 객체 미리 만들어두면 됨..?
      
 
      @Override   // 1)정의만하고
      public void addOil() { // addOil 메서드 가 만들어지고 본문(빈칸)이 있게 만들어짐
                            // sellOil의 (String model, int oil) 호출 가능
        totalOil -= oil;
        earning += oil * payPerLiter;
        System.out.println(model + " " + oil + "L 주유 완료");
        
      }
    };
    
    // 2) Car car 지역변수(객체)의 addOil() 메소드 호출
    car.addOil();
    
  }
  
  
  

  public int getTotalOil() {
    return totalOil;
  }

  public void setTotalOil(int totalOil) {
    this.totalOil = totalOil;
  }

  public int getPayPerLiter() {
    return payPerLiter;
  }

  public void setPayPerLiter(int payPerLiter) {
    this.payPerLiter = payPerLiter;
  }

  public int getEarning() {
    return earning;
  }

  public void setEarning(int earning) {
    this.earning = earning;
  }
  
 
  

}
