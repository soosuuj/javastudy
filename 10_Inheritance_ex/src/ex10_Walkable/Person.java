package ex10_Walkable;

public class Person {

  public void foodFeed(Animal animal, String string) {
    System.out.println(animal + "에게" + string + "주기");
    
  }
/*
  public void foodFeed(Snake snake, String string) {
    System.out.println(snake + "에게" + string + "주기");
    
  }
*/
  
  public void walk(Walkable animal) {
    System.out.println(animal + "산책한다.");
    
  }

}
