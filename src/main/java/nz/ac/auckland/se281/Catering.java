package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Service {
  private CateringType type;

  public Catering(CateringType type, String bookingReference) {
    super(bookingReference, type.getCostPerPerson());
    this.type = type;
  }
}
