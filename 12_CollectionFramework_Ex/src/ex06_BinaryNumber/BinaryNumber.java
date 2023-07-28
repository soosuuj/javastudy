package ex06_BinaryNumber;

import java.util.ArrayList;
import java.util.List;


public class BinaryNumber {
  
  /* 10진수 */ 
  @SuppressWarnings("unused")
  private Integer number; // 10진수
  /* 2진수  */ private List<Integer> binary; // 2진수

  // new BinaryNumber(32) -> 10진수 전달 시 자동으로 2진수(100000)로  binary 저장
  public BinaryNumber(Integer number) {
    this.number = number;
    // 32 % 2 == 0 -> Binary.get(0) : 0
    // 16 % 2 == 0 -> Binary.get(1) : 0
    //  8 % 2 == 0 -> Binary.get(2) : 0
    //  4 % 2 == 0 -> Binary.get(3) : 0
    //  2 % 2 == 0 -> Binary.get(4) : 0
    //  0 % 2 == 0 -> Binary.get(5) : 1
    binary = new ArrayList<Integer>();
    if(number == 0) {
      binary.add(0);
    }else {
     while( number > 0) {
      binary.add(number % 2);
      number /=2; 
      }
    }
  }
  
  public List<Integer> getBinary() {
    return binary;
  }

  public void setBinary(List<Integer> binary) {
    this.binary = binary;
  }


  //BinaryNumber bn = new BinaryNumber(32);
  //System.out.println(bn);  // 100000
  @Override
  public String toString() {
    String result = "";
    for(int i = binary.size() -1; i >=0 ; i-- ) {
      result += binary.get(i);
    }
    return result;
  }
  
}
