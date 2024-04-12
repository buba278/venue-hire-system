package nz.ac.auckland.se281;

public class Music extends Service {
  private int cost;

  public Music(String bookingReference) {
    super(bookingReference, 500);
  }

  public int getCost() {
    return this.cost;
  }
}
