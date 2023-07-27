package ex01_Person;

import java.util.ArrayList;
import java.util.List;

public class MainWrapper {

  public static void main(String[] args) {

    List<Person> family = new ArrayList<Person>();
    

    // 가족 구성원을 리스트에 추가
     family.add(new Person("정숙", 30));
     family.add(new Person("상철", 35));


    // 가족 구성원 출력
     for(int i = 0, length = family.size(); i <length; i ++) {
       System.out.println(family.get(i)); //Person의 toString() 동작
       System.out.println("이름 : " + family.get(i).getName()); // 이름을 따로 부름
       System.out.println("나이 : " + family.get(i).getAge());  // 나이를 따로 부름
     }
  }
}
