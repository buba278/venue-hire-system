package nz.ac.auckland.se281;

abstract public class Service {
  protected int cost;

  abstract int getCost();

  public Service(String bookingReference, int cost) {
    this.cost = cost;
  }
}
