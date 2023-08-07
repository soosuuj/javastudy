package ex01_anonymous_inner_type;

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
    // 람다식으로 Car 인터페이스 타입의 객체 생성
    car = () -> { 
    totalOil -= oil;
    earning += oil * payPerLiter;
    System.out.println(model + " " + oil + "L 주유 완료");
    };
    
    
    // Car car 지역변수(객체)의 addOil() 메소드 호출
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
