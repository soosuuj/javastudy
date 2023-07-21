package ex07_Car;

public class MainWrapper {

  public static void main(String[] args) {

    Driver driver = new Driver();
    
    driver.setName("홍길동");
    driver.setCareer(20);
    //driver.setBestDriver(false); // career가 10년 기준이 있기 때문에 이거 부르지 않아도 됨
   
    Car myCar = new Car();
    
    myCar.setDriver(driver); // 운전자 유무
    myCar.setFuel(50);       // 기름 50을 넣음
    myCar.engineStart();     // 시동이 거렸습니다. or 시동이 걸리지 않았습니다.
    myCar.drive();           // 자동차가 움직였습니다. 자동차가 움직이지 않았습니다.
    myCar.accel(50);         // 기존 속도에 50이 추가 , 현재 속도는 50입니다.
    myCar.accel(60);         // 기존 속도에 60이 추가(최대 속도는 100) 현재 속도는 100입니다.
    myCar.brake(50);         // 기존 속도가 50만큼 감속, 현재 속도는 50입니다.
    myCar.brake(60);         // 기존 속도가 60만큼 감속(최저 속도는 0), 현재 속도는 0입니다.
    
    
    //myCar.setEmpty(true);   - 오류..ㅎ
   
    
  }

}
