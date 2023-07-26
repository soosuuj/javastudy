package ex08_SmartPhone;

public class MainWrapper {

  public static void main(String[] args) {

    Phone p = new Smartphone();
     p.call();
     p.sms();
    if(p instanceof Computer ) { //다운케스팅으로 자동형변환 할 때 객체에 들어있는지 확인
      ((Computer) p).game();
      ((Computer) p).internet();
    }
    if(p instanceof Camera)
      ((Camera) p).takePicker();
    
    System.out.println("===============");
    
    Computer c = new Smartphone();
    c.game();
    c.internet();
    if(c instanceof Smartphone) {
      ((Smartphone) c).call();
      ((Smartphone) c).sms();
    }
    if(c instanceof Camera) {
      ((Camera) c).takePicker();
    }
    
    System.out.println("===============");
    
    
    Smartphone sp = new Smartphone();
    sp.call();
    sp.sms();
    sp.internet();
    sp.game();
    sp.takePicker();
  }
  
  

}
