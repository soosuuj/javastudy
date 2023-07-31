package ex02_random;

import java.util.UUID;

public class Ex04_UUID {

  public static void main(String[] args) {
    
    /*
     * java.util.UUID 
     * 1. 전역 고유 식별자(Universal Unique IDentifier)라는 뜻이다.
     * 2. 32개의 16진수를 랜덤하게 생성한다. (하이픈(-) 4개 별도 포함)
     * 3. UUID를 이용해서 생성한 값은 중복이 없는 거으로 처리한다.
     * 4. 생성된 UUID 값은 String으로 바꿔서 사용한다.
     * 
     */

    UUID uuid = UUID.randomUUID();  // 
    String str = uuid.toString();
    System.out.println(str);        //c2061439-3894-443e-a331-70811ee41946

  }

}
