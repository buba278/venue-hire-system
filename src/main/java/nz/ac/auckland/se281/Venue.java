package nz.ac.auckland.se281;

public class Venue {
  private String name;
  private String code;
  private int capacity;
  private int hireFee;

  // Handle paramters as strings due to HireSystem formatting
  public Venue(String name, String code, String capacity, String hireFee) {
    this.name = name;
    this.code = code;
    this.capacity = Integer.valueOf(capacity);
    this.hireFee = Integer.valueOf(hireFee);
  }

  public String getName() {
    return this.name;
  }
  public String getCode() {
    return this.code;
  }
  public int getCapacity() {
    return this.capacity;
  }
   public int getHireFee() {
    return this.hireFee;
  }
}
