package ex07_TourGuide;

public class MainWrapper {

  public static void main(String[] args) {
    
    TourGuide guide1 = new TourGuide();
    guide1.setTour(new HawaiiTour());
    guide1.sightseeing();
    guide1.lesisure();
    guide1.meal();
    
    System.out.println("--------------------------------");
    
    TourGuide guide2 = new TourGuide();
    guide2.setTour(new JapanTour());
    guide2.sightseeing();
    guide2.lesisure();
    guide2.meal();
  }

}
