package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Service {
  private CateringType type;
  private String typeName;
  private int cost;

  public Catering(CateringType type) {
    this.type = type;
    this.typeName = type.getName();
    this.cost = type.getCostPerPerson();
  }

  public int getCost() {
    return cost;
  }
}
