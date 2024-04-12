package nz.ac.auckland.se281;

abstract public class Service {
  private String bookingReference;
  private int cost;

  public Service(String bookingReference, int cost) {
    this.bookingReference = bookingReference;
    this.cost = cost;
  }
}
