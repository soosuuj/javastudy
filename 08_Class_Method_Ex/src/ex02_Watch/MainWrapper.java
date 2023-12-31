package ex02_Watch;

public class MainWrapper {

  public static void main(String[] args) {

    //Watch 객체 선언 & 생성
    Watch  watch = new Watch();
    
    //watch 객체에 시, 분, 초 정 보설정
    watch.setHour(9);
    watch.setMinute(40);
    watch.setSecond(30);

  // 시, 분, 초 증가시키기
    watch.addHour(25);     // 1일 1시간 -> 1시간만 살아님음
    watch.addMinute(61);   // 1시간 1분 -> 둘 다 살아남음
    watch.addSecond(3661); // 1시간 1분 1초    총 3시간 2분 1초 후 가 나와야함!!!
    
    //시, 분, 초 확인하기
    System.out.println("시 : " + watch.getHour());   // 시 : 12시
    System.out.println("분 : " + watch.getMinute()); // 분 : 42분
    System.out.println("초 : " + watch.getSecond()); // 초 : 31초
    
  
  
  }

}
