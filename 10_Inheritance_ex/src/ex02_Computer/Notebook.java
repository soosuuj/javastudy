package ex02_Computer;

public class Notebook extends Computer {

  private int battery; // 배터리 용량
  
  // new Notebook("gram", 70)에 의해서 호출되는 생성자
  public Notebook(String model, int battery ) {
    super(model);              //computer의 생성자를 불러줘야함, 먼저 불러야지 안그럼 오류남!!
    this.battery = battery;
  }
  
  public int getBattery() {
   return battery;
  }
  public void setBatter(int battery) {
    this.battery = battery;
  }
  
}
