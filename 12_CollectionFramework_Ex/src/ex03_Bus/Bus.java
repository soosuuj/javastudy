package ex03_Bus;

import java.util.ArrayList;
import java.util.List;

public class Bus {

  private List<Seat> seats; // 제한 없이 사람을 앉힐 수 있음 -> 인덱스 사용가능 -> 인덱스를 사용하여 사람 앉히기
  private final int LIMIT = 25; // 25인승 버스
  
  public Bus() { //seat 25개 만들어짐... 
    seats = new ArrayList<Seat>();
    for(int i = 0; i < LIMIT; i++) {  // 0~24까지
      seats.add(new Seat());
    }
  }

  public void getOn(int seatNo, Person person) {
    if(seatNo < 1 || seatNo > LIMIT) {  // 실제 번호 1~25, 인덱스로 환산 시 -1  
      System.out.println("존재하지 않는 좌석번호입니다.");
      return;
    }
    if(seats.get(seatNo -1).getPerson() != null) {
      System.out.println("이미 점유된 좌석번호입니다.");
      return;
    }
    seats.get(seatNo -1).setPerson(person);
    System.out.println(seatNo +" 번 좌석에 " + person + "탑승했습니다.");
  }
  
  
  public void getOff(int seatNo) {
    if(seatNo < 1 || seatNo > LIMIT) {  // 실제 번호 1~25, 인덱스로 환산 시 -1  
      System.out.println("존재하지 않는 좌석번호입니다.");
      return;
    }
    if(seats.get(seatNo -1).getPerson() == null) { //seats.get(seatNo -1) 좌석까지  -> getPerson 사람 꺼내기
      System.out.println(seatNo +  "해당 좌석에 착석한 사람이 없습니다.");      
      return;
    }
    System.out.println(seatNo + "번 좌석에 앉은 " + seats.get(seatNo -1 ).getPerson() + "하차하였습니다.");
    seats.get(seatNo - 1).setPerson(null);
  }

  public void info() {
    for(int i = 0; i < LIMIT; i++) {
      System.out.print(( i + 1) + " 번 좌석: ");  
      if(seats.get(i).getPerson() != null) {
        System.out.println(seats.get(i).getPerson() != null);
      }else {
        System.out.println("빈좌석");
      }
    }
  }

}
