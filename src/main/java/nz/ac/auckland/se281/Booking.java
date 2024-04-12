package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class Booking {
  private String reference;
  private String venueCode;
  private String requestedDate;
  private String email;
  private String attendees;

  // service fields
  private Catering cateringService = null;
  private Music musicService = null;
  private Floral floralService = null;
  private int cost = 0;

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
  public String getReference() {
    return this.reference;
  }
  
  public void setCatering(CateringType cateringType) {
    Catering cateringService = new Catering(cateringType);
    return;
  }
  public void setMusic() {
    Music musicService = new Music();
    return;
  }
  public void setFloral(FloralType floralType) {
    Floral floralService = new Floral(floralType);
    return;
  }
}
