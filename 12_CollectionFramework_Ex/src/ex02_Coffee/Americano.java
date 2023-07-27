package ex02_Coffee;

public class Americano implements Coffee {
  // 아메리카노 타입은 커피
  private String name;

  public Americano(String name) {
    super();
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Americano [name=" + name + "]";
  }
  

}
