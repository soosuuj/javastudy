package ex06_GameUnit;

public class Marine extends GameUnit {
  
  private final int POWER = 5;
  
  //생성자 new Marine("마린")
  public Marine(String name) {
    super(name); // public public(name){} 생성자를 호출한다.
  }
 
  @Override
  public void attack (GameUnit other) { // unit1.attack(unit2)
    System.out.println(getName() + "의 공격!"); //나의 부모인 game unit에 마린이라고 있음
    if(POWER >= other.getHp()) { // 내 파워가 상대보다 크거나 같다면
      other.setHp(0);   //0으로 떨어트리면 
    }else {
      other.setHp(other.getHp() - POWER);
    }
  }
  
}
