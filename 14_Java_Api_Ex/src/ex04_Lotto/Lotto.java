package ex04_Lotto;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Lotto {
  
  /**
   * 로또 구매<br>
   * 로또 구매를 위해서 사용자로부터 money를 입력 받는 메소드<br>
   * 로또 구매 비용은 최소 1000, 최대 100000이다.<br>
   * @return money 사용자가 입력한 로또 구매 비용에서 1000 미만 단위는 버리고 반환. ex) 5999 입력 시 5000 반환
   * @return 0 로또 구매 실패 시 반환
   */
  public int buyLotto() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Lotto를 얼마나 구입하시겠습니까?(최대 10만원) >>> ");
    int money = sc.nextInt();
    sc.close();
    if(money < 1000 || money > 100000) {
      System.out.println(money + "원 Lotto 구매는 불가능합니다.");
      return 0;
    }
    return money / 1000 * 1000;
    
   
  }

  
  /**
   * 로또 번호 생성<br>
   * 로또 구매 비용만큼 로또 번호를 생성하는 메소드<br>
   * 5게임씩 끊어서 생성된 로또 번호를 출력한다.<br>
   * @param money 로또 구매 비용
   */
  public void generateLotto(int money) { // 1000원 단위로 완성된 모습이 넘어옴 0도 가능
    // 로또 구매 용지 : 5게임 기록
    /*
     * row=1 : 1 2 3 4 5 6    // lotto[0] -> 1차원 배열, 1만있는 한간은 lotto[0][0], 
     * row=2 : 3 2 1 4 6 5
     * row=3 : 6 5 4 3 7 9 
     * row=4 : 9 8 6 5 4 3 
     * row=5 : 8 3 4 5 1 2 
     * 
     * 한 번에 이 번호들이 저장됐음 좋겠다 -> 2차원 배열 필요 6열 3행이니까
     * 한판 만드는데 5천원 -> 10,000원 받으면 5,000원 -> 5,000원 -> 0원
     * 한줄 만드는데 1천원
     */
    
    while (money > 0) {  // 한 번에 5개까지 할 수 있는 게임 반복문
    // 구매금액 최소 5,000원 -> 최대 5개 구매, 그 이하면 한줄씩
     // 한줄씩 1~45개 번호로 채워야함 -> 1차원 배열 lotto[i]에 채워~
    int row = (money >= 5000) ? 5: money / 1000;  //1)
    int [][] lotto = new int[row][6];             //3
    for(int i = 0; i  < lotto.length; i++) {      // 중복 번호 제외하는 렌덤값, 중복저장 x set -> 인덱스가 없고, 저장 순서 없음, 중복저장 안됨
     Set<Integer> set = new HashSet<Integer>();
     SecureRandom secureRandom = new SecureRandom();
     while(set.size() != 6) { // 몇번 돌릴지는 모르나, 언제까지는 6개가 나올 떄 까지  -> while
     set.add(secureRandom.nextInt(45) + 1);  
     }
     Iterator<Integer> arm = set.iterator(); 
     for(int j = 0 ; j < lotto[i].length; j++) {  
        // set 꺼내는 것 -> 인덱스가 없으니 인덱스로 뺄 수 없음, for, 반복자 arm 으로 뺐었음
       lotto[i][j] = arm.next();
     }
    }
    for(int i = 0; i < lotto.length; i++) {
      System.out.print(String.format("%02d", i + 1)+ ":");
      for(int j = 0; j < lotto[i].length; j++) {
        System.out.print(String.format("%4d", lotto[i][j]));
      }
      System.out.println();
    }
    System.out.println("------------------------------");
    money -= 5000;                                //2)  번호
   }
    
    
  }
  
}