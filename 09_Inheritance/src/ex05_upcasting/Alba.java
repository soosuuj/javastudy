package ex05_upcasting;

// 학교 다니는 알바생
public class Alba extends Student {
  
  private String work;
  
  // new Alba()
  public Alba() {
    super(); // new Student() 호출과 동일하다. 디폴트 생성자이므로 생략할 수 있다.
             //알아서 호출되는 코드, 있어도 그만 없어도 그만!
  }
  
  // new Alba("홍길동", "가산대학교", "투썸")

  public Alba(String name, String school, String work ) {
    super(name, school);  //new Student("홍길동", "가산대학교") 호출과 동일하다.
    this.work = work;
  }

  public String getWork() {
    return work;
  }

  public void setWork(String work) {
    this.work = work;
  }
  @Override //애너테이션
  public void working() {
    System.out.println("일함");
  }
  
  @Override //애너테이션 ctrl + space //부모가 가지고 있는것을 다시 만드는것 - >부모의 메서드를 사용할 수 없기 때문에..
  public void info() {
    System.out.println("이름 : " + getName());
    System.out.println("학교 : " + getSchool());
    System.out.println("직장 " + work);
  }
}
