package nz.ac.auckland.se281;

public class Booking {
  private String reference;
  private String venueCode;
  private String requestedDate;
  private String email;
  private String attendees;

  // Handle paramters as strings due to HireSystem formatting
  public Booking(String venueCode, String requestedDate, String email, String attendees) {
    this.venueCode = venueCode;
    this.requestedDate = requestedDate;
    this.email = email;
    this.attendees = attendees;
  }

  public String getCode() {
    return this.venueCode;
  }
  public String getDate() {
    return this.requestedDate;
  }
  public String getEmail() {
    return this.email;
  }
   public String getAttendees() {
    return this.attendees;
  }
}
