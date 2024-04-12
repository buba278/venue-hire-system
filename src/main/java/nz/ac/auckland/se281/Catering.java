package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Service {

  public Catering(CateringType type, String bookingReference, int attendees) {
    super(bookingReference, (type.getCostPerPerson() * attendees));
  }

  public int getCost() {
    return 0;
  }
}
