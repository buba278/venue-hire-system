package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class Floral extends Service {
  private String type;

  public Floral(FloralType type, String bookingReference) {
    super(bookingReference, type.getCost());
    this.type = type.getName();
  }

  public int getCost() {
    return cost;
  }
  public String getType() {
    return type;
  }
}
