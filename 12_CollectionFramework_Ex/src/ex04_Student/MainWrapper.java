package ex04_Student;

import java.util.HashMap;
import java.util.Map;

public class MainWrapper {

  public static void main(String[] args) {

    // 교실의 5명 학생 정보를 저장하는 HashMap 만들기
    // Key   : 학번(예 : 10101)
    // Value : Student 객체
    
    Map<Integer, Student> map = new HashMap<Integer, Student>();
    map.put(10101, new Student("가길동", new Exam(100, 100, 100)));
    map.put(10303, new Student("다길동", new Exam(7100, 100, 100)));
    map.put(10404, new Student("라길동", new Exam(100, 100, 100)));
    map.put(10505, new Student("마길동", new Exam(100, 100, 100)));
    
    /*
    Student student = new Student();
    student.setName("나길동");
    student.setExam(new Exam(90, 90, 90));
    map.put(10102, student);
    */
    
    Integer[] stuNo = {10101, 10303, 10404, 10505};
    for(int i = 0; i < stuNo.length; i++) { // 학번 준비, key값
      Student student = map.get(stuNo[i]);
      System.out.println("이름 : " + student.getName());
      System.out.println("시험 : " + student.getExam());
    }
    
  }

}
