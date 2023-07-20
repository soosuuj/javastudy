package exam;

public class MainWrapper {

  // main
  public static void main(String[] args) {
    //q1();
    //q2();
    //q3();
    //q4();
    //q5();
    //q6();
    //q7();
    //q8();
    //q9();
    //q10();
    //q11();
    //q12();
    //q13();
    //q14();
    //q14_1()
    q14_2();
  }
  
  // q1. 절대값 구하기
  // int number에 저장된 절대값을 계산하여 int absNumber에 저장하고 출력하시오.
  // 예시)
  // -5의 절대값은 5입니다.
  public static void q1() {
    int number = -5;
    int absNumber;
    // 요기서부터 풀이
    if(number < 0) {
      absNumber = -number;
    }else {
      absNumber = number;
    }
    System.out.println(number + "의 절대값은 " + absNumber +"입니다.");
  }
  
  // q2. 나이에 따른 구분하기
  // 0 ~ 7    : 미취학아동
  // 8 ~ 13   : 초등학생
  // 14 ~ 16  : 중학생
  // 17 ~ 19  : 고등학생
  // 20 ~ 100 : 성인
  // 이외값   : 잘못된 나이
  // 예시)
  // 30살은 성인입니다.
  public static void q2() {
    String strAge = "30"; //int로 변환
    
    int age = Integer.parseInt(strAge); // 숫자가 됨
    if(age < 0  || age > 100) {
      System.out.println("잘못된 나이");
    }else if(age <= 7) {
      System.out.println("미취학아동");
    }else if(age <=13) {
      System.out.println("초등학생");
    }else if(age <= 16) {
      System.out.println("중학생");
    }else if(age <= 19) {
     System.out.println("고등학생");
    }else {
      System.out.println("성인");
    }
  }
  
  // q3. 너비가 int width, 높이가 int height인 삼각형의 넓이를 계산하여 double area에 저장한 뒤 출력하시오.
  // 예시)
  // 너비가 3, 높이가 3인 삼각형의 넓이는 4.5입니다.
  public static void q3() {
    int width = 3;
    int height = 3;
    double area;
    
   //area = (width * height)/(double)2; 
    area = width * height/2.0; 
    System.out.println("너비가 " + width + " 높이가 " + height  + "인 삼각형의 넓이는 " + area + "입니다.");
  }
  
  // q4. int month에 저장된 월의 계절과 해당 월이 며칠까지 있는지 출력하시오.
  // 항상 2월은 28일까지만 있는 것으로 처리하시오.(윤년은 고려하지 않는다는 의미이다.) 
  // 예시1)
  // 5월은 봄입니다.
  // 5월은 31일까지 있습니다.
  // 예시2)
  // 13월은 잘못된 정보입니다.
  public static void q4() {
    int month = 5;
    String[] season = {"겨울", "봄", "여름", "가을"}; // 겨울 인덱스 0
    int[] lastDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
     //0 더미값, 안쓰는 값 - 인덱스때문에 넣은 것임, 인덱스 시작은 0부터...
    
    if(month > 12 || month < 1) {
      System.out.println(month + "월은 잘못된 정보입니다.");
      
     }else {
    
    System.out.println(month + "월은 " + season[month % 12 /3] + "입니다.");
    System.out.println(month + "월은 " + lastDay[month] + "일까지 있습니다."); 
     } 
    // [month] - 인덱스 그대로 사용
    
  }
  
  // q5. int a, b에 저장된 값 중에서 정수 10과 더 가까운 값을 출력하시오.
  // 예시)
  // 8, 11중 10과 가까운 수는 11입니다.
  public static void q5() {
    int a = 8;
    int b = 11;
    
    int diffA = (10 > a) ? 10 - a : a - 10;  // 10과 a, b의 차이 구함 -> 모두 양수로
    int diffB = (10 > b) ? 10 - b : b - 10;
    
    /*
     * int answer = 0;
    if(diffA < diffB) {
      answer = a;
    }else {
      answer = b;
    }
    */
   
    int answer = (diffA < diffB) ? a : b;
    System.out.println(a + " ," + b + " 중 10과 가까운 수는 " + answer + "입니다.");
    
  }
  
  // q6. int money를 오만원권, 만원권, 오천원, 천원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 오원 동전, 일원 동전이 각각 몇 개로 변환되는지 출력하시오.
  // 예시)
  // 75832원은 다음과 같습니다.
  // 50000원 짜리 : 1개
  // 10000원 짜리 : 2개
  // 5000원 짜리 : 1개
  // 500원 짜리 : 1개
  // 100원 짜리 : 3개
  // 10원 짜리 : 3개
  // 1원 짜리 : 2개
  public static void q6() {
    /*
     * 75832 / 50000 -> 1이 남음(몫) -> count[0], 오만원 짜리 하나 필요,
     * 25832 / 10000 -> 2(몫) -> count[1]
     * 5832  / 5000  -> 1(몫) -> count[2]
     * ...
     * 2     / 1     ->          count[9]
     * ----------------------------------
     * money / unit[i]   / count[i]  i => 같은 번호
     * money %= unit[i]  //   money = money % unit[i] 
     */
    
    int money = 75832;
    int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
    int[] count = new int[unit.length]; //10
    
    for (int i = 0; i < unit.length; i++) {  // 문제에는 1000, 5원이 없음, for돌리면 없는거 안나옴?
      count[i] = money / unit[i];
      money %= unit[i];
      if(count[i] != 0) {
        System.out.println(unit[i] + "원 짜리: " + count[i] + "개");
      }
    }
  }
  
  
  // q7. int second에 저장된 초를 시/분/초로 변환하여 출력하시오.
  // 1분이 넘는 경우 '분'까지 표시하고, 1시간이 넘는 경우 '시'까지 표시하시오.
  // 예시1)
  // 40초는 40초입니다.
  // 예시2)
  // 90초는 1분 30초입니다.
  // 예시3)
  // 3690초는 1시간 1분 30초입니다.
  public static void q7() {
    int second = 3690;
    
    if(second < 60) {
      System.out.println(second +"초는" +second +"초입니다.");
    }else if(second < 3600) { // 분
      System.out.println(second + "초는 " + (second / 60) +"분 " + (second % 60) +"초입니다.");
    }else {
      System.out.println(second + "초는 " + (second / 3660) + "시간" + (second % 3600 / 60) + "분 " + (second % 60) + "초입니다."); // 마지막 초 (second % 3600 % 60)
    }
  }
  
	// q8. int number의 첫 번째 글자가 1,3,5이면 "남자", 2,4,6이면 "여자"를 출력하시오.
	// int number의 첫 번째 글자는 항상 1 ~ 6 사이의 정수라고 가정한다.
	// 예시
	// 남자입니다.
	public static void q8() {
		int number = 1234567;
		 // 앞자리
		if((number / 100000) %2 == 1) {
		  System.out.println("남자입니다.");
		}else {
		  System.out.println("여자입니다.");
		}
		switch( number / 100000) {
		case 1: case 3: case 5:
		  System.out.println("남자입니다.");
		  break;
		 default:
		    System.out.println("여자입니다.");
		}
	}
	
	// 카프리카 수 판별하기
	// 2자리(10~99) 또는 4자리(1000~9999) 수 대상
	// 앞 뒤로 숫자를 분리 -> 각 숫자를 더함  -> 더한 수의 제곱을 구함 -> 자신과 같은가?
	// 81 ->  8   1로 분리 -> 9               -> 9*9 =81                 처음 수 81, 마지막 81로 같음...
	
	// q9. 구구단을 모두 출력하지 말고 5 x 5 = 25까지만 출력하시오.
	// 예시
	// 2 x 1 = 2
	// 2 x 2 = 4
	// ...
	// 5 x 5 = 25
	public static void q9() {
		for(int i = 2; i <= 5; i++) {
		  for(int j = 1; j <=9; j++) {
		    System.out.println( i + " * " + j +" = " + i*j);
		    if(i == 5 && j ==5) {
		      break; 
		    }
		  }
		  System.out.println();
		}
	}
	
/*
 *  라벨을 붙여여 break 빠져 나감
	outer:
	    for(int i = 2; i <= 5; i++) {
	      for(int j = 1; j <=9; j++) {
	        System.out.println( i + " * " + j +" = " + i*j);
	        if(i == 5 && j ==5) {
	          break outer; 
	        }
	      }
	    }

*/
	
	// q10. begin부터 end 사이의 모든 정수들의 평균을 출력하시오.
	// 단, 항상 begin은 end보다 작거나 같은 상태이다.
	// 예시
	// 1부터 6사이 모든 정수의 평균은 3.5입니다.
	public static void q10() {
		int begin = 1;
		int end = 6;
		int total = 0;
		
		for(int n = begin; n <= end; n++) {
		  total = total +n;
		}
		System.out.println(begin + "부터 " + end + "사이 모든 정수의 평균은" + (total / (end - begin + 1.0)) + "입니다.");
	}
	
	// q11. 1부터 100 사이의 모든 3의 배수를 더한 결과를 출력하시오.
	// 예시
	// 모든 3의 배수 합은 1683입니다.
	public static void q11() {
		int total = 0;
		
		for(int n = 1; n <=100; n++) {
		  if( n% 3 == 0) {
		    total = total + n;
		  }
		}
		System.out.println("모든 3의 배수의 합은 " + total + "입니다.");
	}
	
	// q12. 배열에 저장된 모든 정수를 모두 더하시오.
	// 단, 0보다 작은 값은 더하지 마시오.
	// 예시
	// 합계는 6입니다.
	public static void q12() { //요거 나옴 시험
		int total = 0;
		int[] a = {1, -1, -2, 2, 3, -3};
		
		for(int i = 0; i < a.length; i++) {
		  if(a[i] < 0 ) {
		    continue;
		  }
		  total = total +a[i];
		}
		System.out.println("합계는 " + total + "입니다.");
		total = 0;
		for(int n : a) {
		  if(n >0 ) {
		    total = total +n;
		  }
		}
    System.out.println("합계는 " + total + "입니다.");
	}
	
	// q13. 제시된 배열 a에 상수 TARGET과 동일한 문자가 몇 개 포함되어 있는지 갯수를 구해서 출력하시오.
	// 예시
	// 배열에 포함된 h는 2개입니다.
	public static void q13() {
		final char TARGET = 'h';
		char[] a = {'a', 'h', 'e', 'h', 'p'};
		
		int count = 0;
		
		for(int i = 0; i < a.length; i++) {
		  if(a[i] == TARGET) {
		    count++;
		  }
		}
		System.out.println("배열에 포함된 " + TARGET + "는 " + count + "개입니다.");
	}
	
	// q14. 점수에 따라 가져갈 수 있는 모든 사은품을 출력하시오.
	// 점수가 60점 이상인 경우 : "행주"
	// 점수가 70점 이상인 경우 : "행주도마"
	// 점수가 80점 이상인 경우 : "행주도마식칼"
	// 점수가 90점 이상인 경우 : "행주도마식칼냄비"
	// 예시
	// 행주도마
	public static void q14() {
		String strScore = "75"; // 숫자로 변환 필요
		String gift = ""; //  String gift = null;
		
	  int score = Integer.parseInt(strScore);
	  if(score >= 60) {
	    gift = gift + "행주"; // else if 여기서는 쓸 수 없음
	  }
	  if(score >= 70) {
      gift = gift + "도마"; 
	  }
	  if(score >= 80) {
      gift = gift + "식칼"; 
    }
	  if(score >= 90) {
      gift = gift + "냄비"; 
    }
	  System.out.println(gift);
	}



public static void q14_1() { // 문자열 연결은 null 쓰면 출력됨
  String strScore = "75"; // 숫자로 변환 필요
  //String gift = ""; //  String gift = null;
  String gift = null;
  int score = Integer.parseInt(strScore);
  if(score >= 60) {
    gift = gift + "행주"; // else if 여기서는 쓸 수 없음
  }
  if(score >= 70) {
    gift = gift + "도마"; 
  }
  if(score >= 80) {
    gift = gift + "식칼"; 
  }
  if(score >= 90) {
    gift = gift + "냄비"; 
  }
  System.out.println(gift);
}



// 요거는 거꾸로 나옴~ 답 아님!!!
public static void q14_2() { // 문자열 연결은 null 쓰면 출력됨
  String strScore = "75"; // 숫자로 변환 필요
  String gift = ""; //  String gift = null;
  //String gift = null;
  int score = Integer.parseInt(strScore);
 
   switch(score / 10) {
   case 10:
   case 9: gift += "냄비";
   case 8: gift += "식칼";
   case 7: gift += "도마";
   case 6: gift += "행주"; break;
   default: gift += "꽝";
   }
   System.out.println(gift);
}

}

