package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class Floral extends Service {
  private FloralType type;

  public Floral(FloralType type, String bookingReference) {
    super(bookingReference, type.getCost());
    this.type = type;
  }
  public int getCost() {
    return 0;
  }
}
