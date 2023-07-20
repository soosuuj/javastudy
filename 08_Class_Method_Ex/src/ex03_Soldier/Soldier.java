package ex03_Soldier;

public class Soldier {

  private Gun gun; // 객체가 선언된 것, 객체가 만들어지지 않음
  
  public Soldier(Gun gun) {
    this.gun = gun;
  }
  
  public Soldier(int bullet) {
    gun = new Gun(bullet);
  }
  
  public void reload(int bullet) {
    gun.reload(bullet);
  }
  
  public void shoot() {
    gun.shoot();
  }
  
}

  /*
  public static void main(String[] args) {
      Soldier s = new Soldier(30); // 총알을 30개 가진 군인

      s.reload(20); // 20발이 장전되었습니다. 현재 50발이 들어있습니다.

      for (int n = 0; n < 50; n++) {
          s.shoot();
      }

      s.shoot(); // 헛 빵!
  }
  */

