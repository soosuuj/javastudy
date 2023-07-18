package ex01_one_dim;

import java.util.Arrays;

public class MainWrapper {

  public static void ex01() {
    //                            배역의 인덱스
    // 월에 따른 계절    월 % 12  월 % 12 / 3 몫을 구하고자함
    // 3 ~ 5 : 봄        3 ~ 5    1  - 봄
    // 6 ~ 8 : 여름      6 ~ 8    2  - 여름
    // 9 ~ 11: 가을      9 ~ 11   3  - 가을
    // 12 ~ 2: 겨울      0 ~ 2    0  - 겨울
    int month = 2;
    String[] seasons = {"겨울", "봄", "여름", "가을"};
    // 코드 1줄로 해결할 것
    System.out.println(month + "월은 " + seasons[(month % 12)/3] + "입니다.");
  }
  
  public static void ex02() {
    // 10, 20, 30, 40, 50을 배열 a에 저장하고 출력하기
    // 배열 a: [10, 20, 30, 40, 50]
    int[] a = new int[5];
    // 배열과 인덱스 외 변수 사용 금지
    // 인덱스  - 배열요소 -> 식
    // 0          10       (인덱스 + 1) * 10
    // 1          20  
    // 2          30  
    // 3          40  
    // 4          50  
    
   for(int i = 0; i < a.length; i++) {
     a[i] = (i + 1) * 10 ;
   }
   System.out.print("배열 a : " + Arrays.toString(a));
  }
  
  public static void ex03() {
    // 'A', 'B', 'C', ...'Z'를 배열 a에 저장하고 출력하기
    // 배열 a: [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]
    char[] a = new char[26];
    char ch = 'A';
    
    for(int i = 0; i < a.length; i++) {
      a[i] = ch;
      ch++;
     //a[i] = ch + i -> char(2byte), int(4byte) 타입이 달라 계산 불가
     //a[i] = (char)(ch + i); -> casting으로도 풀 수 있음.
        }
    System.out.println("배열 a : " + Arrays.toString(a) );    
  }
  
  public static void ex04() {
    // 배열 a의 마지막 3개 요소 0을 배열 b의 요소로 바꾸기
    // 배열 a: [10, 20, 30, 40, 50, 60]
    int[] a = {10, 20, 30, 0, 0, 0};
    int[] b = {40, 50, 60};            //
    System.arraycopy(b, 0, a, 3, b.length);
    //b배열 인덱스 0부터 복사해서, a배열 3번에 복사해라!
    
    for(int i = 0 ; i < b.length; i++) {
     a[3+i] = b[i];  
    }
    System.out.println("배열 a : " + Arrays.toString(a));    
    
    /*
    int destLength = a.length + b.length; 
    int[] dest = new int[6];
    
    System.arraycopy(a, 0, dest, 0, a.length);
    System.arraycopy(b, 0, dest, 3, 3);
    System.out.println(Arrays.toString(dest));
    */  
  }
    
  public static void ex05() {
    // 10진수(int number)를 2진수(int[] binary)로 변환하기
    // 10진수 35 = 2진수 0000100011
    int number = 35;             //  35를 2진수로 변환하면 아래와 같다.
                                 // ┌------------------------------------------------┐
    int[] binary = new int[10];  // │ 0 │ 0 │ 0 │ 0 │ 1 │ 0 │ 0 │ 0 │ 1 │ 1 │
                                 // └------------------------------------------------┘
    System.out.println("10진수 " + number + " = 2진수");    

    int i = 9;
    while (number != 0) { // while(number > 0) 0만 아니면 된다.
      binary[i--] = number % 2;
      number /= 2; //number = number / 2; -> 복합 연산으로 줄일 수 있음
    }
    // number 넣으면 0으로 나옴
    for(int j = 0; j < binary.length; j++) {
      System.out.print(binary[j]);
    }
  }
  
  public static void ex06() {
    // 배열에 저장된 점수의 평균, 최댓값, 최솟값 구하기
    // 평균: 84.8점
    // 최대: 100점
    // 최소: 70점
    String[] name = {"미희", "정숙", "영철", "상철", "옥자"};
    int top = 0;     //1등의 인덱스  - 최대값의 번호가 0이라 0으로 초기화
    int botton = 0;  //5등의 인덱스  - 최소값의 번호가 0이라 0으로 초기화
    int[] score = {100, 70, 95, 83, 76};
    int total = score[0];  // 합계(평균을 구할 때 필요한 변수)
    int max = score[0];  // 최댓값
    int min = score[0];  // 최솟값

   
          
    /*
    total = total + score[1];
    total = total + score[2];
    total = total + score[3];
    total = total + score[4];
    
    if(max < score[1]) { max = score[1]; top = 1;}
    if(max < score[2]) { max = score[2]; top = 2;}
    if(max < score[3]) { max = score[3]; top = 3;}
    if(max < score[4]) { max = score[4]; top = 4;}
    
    if(min > score[1]) {min = score[1];}
    if(min > score[2]) {min = score[2];}
    if(min > score[3]) {min = score[3];}
    if(min > score[4]) {min = score[4];}
    */
    
    
    for(int i = 1; i < score.length; i++) {  // 배열 0은 이미 들어가 있으므로 1부터 시작
      total += score[i];
      if(max < score[i]) {
        max = score[i];
        top = i;
      }
      if(min > score[i]) {
        min = score[i];
        botton = i;
      }
    }   
    
     System.out.println("평균 : " + (double)total/score.length);
     System.out.println("최대 : " + max);
     System.out.println("최소 : " + min);
     System.out.println("1등 : " + name[top]);    // 미희
     System.out.println("5등 : " + name[botton]); //정숙
     
  }

  public static void main(String[] args) {
    //ex01();
    //ex02();
    //ex03();
    //ex04();
    //ex05();
   ex06();

  }

}
