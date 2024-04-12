package nz.ac.auckland.se281;

public class Music extends Service {

  public Music(String bookingReference) {
    super(bookingReference, 500);
  }

  public int getCost() {
    return 0;
  }
}
