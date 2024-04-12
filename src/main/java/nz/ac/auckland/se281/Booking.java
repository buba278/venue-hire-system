package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class Booking {
  private String reference;
  private String venueCode;
  private String requestedDate;
  private String email;
  private String attendees;
  private String dateMade;

  // service fields
  private Catering cateringService = null;
  private Music musicService = null;
  private Floral floralService = null;
  private int cost = 0;

  // Handle paramters as strings due to HireSystem formatting
  public Booking(String venueCode, String requestedDate, String email, String attendees, String dateMade) {
    this.venueCode = venueCode;
    this.requestedDate = requestedDate;
    this.email = email;
    this.attendees = attendees;
    this.dateMade = dateMade;
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
  public String getDateMade() {
    return this.dateMade;
  }
  
  public void setCatering(CateringType cateringType, String bookingReference) {
    Catering cateringService = new Catering(cateringType, bookingReference);
    return;
  }
  public void setMusic(String bookingReference) {
    Music musicService = new Music(bookingReference);
    return;
  }
  public void setFloral(FloralType floralType, String bookingReference) {
    Floral floralService = new Floral(floralType, bookingReference);
    return;
  }
}
