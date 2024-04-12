package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Service {
  private String type;

  public Catering(CateringType type, String bookingReference, int attendees) {
    super(bookingReference, (type.getCostPerPerson() * attendees));
    this.type = type.getName();
  }

  public int getCost() {
    return cost;
  }

  public String getType() {
    return type;
  }
}
