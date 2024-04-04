package nz.ac.auckland.se281;

import java.util.HashMap;

public class Venue {
  private String name;
  private String code;
  private int capacity;
  private int hireFee;

  // keep track of days booked, to what booking
  HashMap<String, Booking> bookingDates = new HashMap<String, Booking>();
  // keep track of references to bookings
  HashMap<String, Booking> bookingReferences = new HashMap<String, Booking>();

  // Handle paramters as strings due to HireSystem formatting
  public Venue(String name, String code, String capacity, String hireFee) {
    this.name = name;
    this.code = code;
    this.capacity = Integer.parseInt(capacity);
    this.hireFee = Integer.parseInt(hireFee);
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

  // booking methods

}
