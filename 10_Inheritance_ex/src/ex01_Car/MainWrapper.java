package ex01_Car;

public class MainWrapper {

  public static void main(String[] args) {
    // Ev
    Ev ev = new Ev();
    ev.drive();
    ev.charge();
    
    //EngineCar
    EngineCar enCar = new EngineCar();
    enCar.drive();
    enCar.addFul();

    //HybridCar
    HybridCar hybrid = new HybridCar();
    hybrid.drive();
    hybrid.addFul();
    hybrid.charge();
  }

}
