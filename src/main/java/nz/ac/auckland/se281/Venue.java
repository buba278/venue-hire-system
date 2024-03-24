package nz.ac.auckland.se281;

public class Venue {
  private String name;
  private int code;
  private int capacity;
  private int hireFee;

  // Handle paramters as strings due to HireSystem formatting
  public Venue(String name, String code, String capacity, String hireFee) {
    this.name = name;
    this.code = Integer.valueOf(code);
    this.capacity = Integer.valueOf(capacity);
    this.hireFee = Integer.valueOf(hireFee);
  }
}
