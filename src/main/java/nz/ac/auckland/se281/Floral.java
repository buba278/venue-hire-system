package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class Floral extends Service {

  public Floral(FloralType type, String bookingReference) {
    super(bookingReference, type.getCost());
  }
  
  public int getCost() {
    return cost;
  }
}
