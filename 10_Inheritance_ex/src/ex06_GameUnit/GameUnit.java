package ex06_GameUnit;

public class GameUnit {
  
  private String name;
  private int hp;
  private boolean alive;
  
  
  // new GameUnit("마린")
  public GameUnit(String name) {
    this.name = name;
  }
  
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getHp() {
    return hp;
  }
  public void setHp(int hp) {
    this.hp = hp;
    setAlive(hp > 0); //  조건 추가, 참이면 true..
  }
  public boolean isAlive() {
    return alive;
  }
  private void setAlive(boolean alive) {  //public 에서 변경
    this.alive = alive;
  }

  // 호출을 위한 attack, 메소드는 실행되지 않는다.
  public void attack(GameUnit other) {
    
  }
  
}
