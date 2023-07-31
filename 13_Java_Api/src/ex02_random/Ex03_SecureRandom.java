package ex02_random;

import java.security.SecureRandom;

public class Ex03_SecureRandom {

  public static void main(String[] args) {
    
    // java.security.SecureRandom 클래스  -> 보안처리된 랜덤 , 보안 코드 만들기
    // 1. 보안 처리된 난수를 발생한다.
    // 2. Random 클래스와 같은 사용법을 가진다.
    
    // SecureRandom 객체 선언 & 생성
    SecureRandom secureRandom = new SecureRandom();
    
    // 실수 난수
    double randomNumbber1 = secureRandom.nextDouble();
    
    //정수
    int randomNumbber2 = secureRandom.nextInt();
    int randomNumbber3 = secureRandom.nextInt(5);
    
    System.out.println(randomNumbber1);
    System.out.println(randomNumbber2);
    System.out.println(randomNumbber3);
    

  }

}
