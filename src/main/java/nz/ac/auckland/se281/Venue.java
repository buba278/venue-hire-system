package nz.ac.auckland.se281;

import java.util.HashMap;

public class Venue {
  private String name;
  private String code;
  private int capacity;
  private int hireFee;
  private String nextAvailableDate = "";

  // keep track of days booked, to what booking
  private HashMap<String, Booking> bookingDates = new HashMap<String, Booking>();
  // keep track of references to bookings
  private HashMap<String, Booking> bookingReferences = new HashMap<String, Booking>();

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
  public boolean checkDateAvailability(String date) {
    return !bookingDates.containsKey(date);
  }
  public Booking getDateBooking(String date) {
    return bookingDates.get(date);
  }
  public Booking getReferenceBooking(String reference) {
    return bookingReferences.get(reference);
  }
  public HashMap<String, Booking> getBookingReferences() {
    return bookingReferences;
  }
  public void addBooking(String venueCode, String requestedDate, String email, String attendees, String reference, String dateMade, int venueCost) {
    Booking booking = new Booking(venueCode, requestedDate, email, attendees, dateMade, venueCost);
    bookingDates.put(requestedDate, booking);
    bookingReferences.put(reference, booking);
    this.nextAvailableDate = getNextAvailableDate();
  }
  public String getNextAvailableDate() {
    // need to count from current day, to next day, until does not contain date key
    // dont cross months according to ed
    return this.nextAvailableDate;
  }
  public void setNextAvailableDate(String date) {
    // dont implement actual check in venues as its system job
    // to compare based on its current date
    this.nextAvailableDate = date;
  }

}
