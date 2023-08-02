package ex01_Practice;

public abstract class Player {

  boolean pause;
  int currentPos;
  
  // 추상 클래스도 생성자 필요
  public Player(boolean pause, int currentPos) {
    super();
    this.pause = false;
    this.currentPos = currentPos;
  }
  
  abstract void play(int pos); //추상 메서드
  
  abstract void stop(); // 추상 메서드
  
  // 추상 메서드 사용
  void play() {  
    play(currentPos);
  }
  
  void pause() {
    if(pause) { //pause가 true일때(정지상태) 에서 pause가 호출되면, 
      pause = false; // pause의 상태를 false로 바꾸고.
      play(currentPos);  //현재의 위치에서 play한다.
    }else { //pause가 false일때,
      pause = true;
      stop();
    }
  }
  
  
}
