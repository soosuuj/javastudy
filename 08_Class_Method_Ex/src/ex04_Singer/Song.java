package ex04_Singer;

public class Song {

  //필드
  private String title;
  private String genre;
  private double playTime;
  
  //Song song = new Song(); 생성자는 만들어진거 쓸거라 안만듦.
  
  // setter
  public void setTitle(String title) {
    this.title = title;
  }
  public void setGenre(String genre) {
    this.genre = genre;
  }
  public void setPlayTime(double playTime) {
    this.playTime = playTime;
  }
  
  //info
  public void info() {
    System.out.println("제목: " + title + ", 장르: " + genre + ", 재생시간: " + playTime + "분");
}
}
