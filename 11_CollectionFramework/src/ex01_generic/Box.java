package ex01_generic;

// T = String 타입
public class Box<T> {
  
  private T item;

  public T getItem() {
    return item;
  }
  public void setItem(T item) {
    this.item = item;
  }

  
}
