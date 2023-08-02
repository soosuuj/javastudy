package ex02_7_10;

public class game {
  
  public static void main(String[] args) {

    Unit[] group = { new Marine(), new Tank(), new Dropship()};
    
    for(int i = 0; i < group.length; i++) {
      group[i].move(100, 200);
    }
    
  }

}
  
  abstract class Unit{
    int x, y;     //변수
    abstract void move(int x, int y);  // 추상 메서드
    void stop() {}   // 구현부가 비어있는 일반 메서드
  }
  
  class Marine extends Unit{
    void move(int x, int y) {
      System.out.println("Marine[x=" + x + ", y = " + y +"]");
    }
    void stimPack() {}
  }
  
  class Tank extends Unit{
    void move(int x, int y) {
      System.out.println("Tank [x=" + x + ", y = " + y +"]");
    }
    void changeMode() {}
  }
  class Dropship extends Unit{
    void move(int x, int y) {
      System.out.println("Dropship[x=" + x + ",y=" + y + "]");
    }
    void load() {}
    void unload() {}
  }
  

