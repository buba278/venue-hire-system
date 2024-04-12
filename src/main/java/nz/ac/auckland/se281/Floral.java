package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class Floral extends Service {
  private FloralType type;
  private String typeName;
  private int cost;

  public Floral(FloralType type) {
    this.type = type;
    this.typeName = type.getName();
    this.cost = type.getCost();
  }

  public int getCost() {
    return cost;
  }
}
