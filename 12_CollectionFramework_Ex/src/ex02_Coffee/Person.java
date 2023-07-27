package ex02_Coffee;

import java.util.ArrayList;
import java.util.List;

public class Person {
  
  private List<Cup> tray;
  
  
  //new Person()
  public Person() {
    tray = (new ArrayList<Cup>());
  }

 

  public void addCoffeeToTray(Cup cup) {
    tray.add(cup);
   
  }
  
  public void trayInfo() {  //tray.get(i)  = 컵, getCoffee 로 정보 가져와야함
    for(int i = 0, lenght = tray.size(); i <lenght; i++) {
      System.out.println((i + 1) + "번째 커피 " + tray.get(i).getCoffee() +"번째 커피" );
    }
  }
}
