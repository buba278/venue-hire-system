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
  private int venueCost = 0;

  // Handle paramters as strings due to HireSystem formatting
  public Booking(String venueCode, String requestedDate, String email, String attendees, String dateMade,
      int venueCost) {
    this.venueCode = venueCode;
    this.requestedDate = requestedDate;
    this.email = email;
    this.attendees = attendees;
    this.dateMade = dateMade;
    this.venueCost = venueCost;
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

  public void setCatering(CateringType cateringType, String bookingReference, int attendees) {
    Catering cateringService = new Catering(cateringType, bookingReference, attendees);
    this.cateringService = cateringService;
    return;
  }

  public void setMusic(String bookingReference) {
    Music musicService = new Music(bookingReference);
    this.musicService = musicService;
    return;
  }

  public void setFloral(FloralType floralType, String bookingReference) {
    Floral floralService = new Floral(floralType, bookingReference);
    this.floralService = floralService;
    return;
  }

  public String getFloralType() {
    return floralService.getType();
  }

  public String getCateringType() {
    return cateringService.getType();
  }

  public int getCateringCost() {
    int cost = 0;
    if (cateringService != null) {
      cost = cateringService.getCost();
    }
    return cost;
  }

  public int getMusicCost() {
    int cost = 0;
    if (musicService != null) {
      cost = musicService.getCost();
    }
    return cost;
  }

  public int getFloralCost() {
    int cost = 0;
    if (floralService != null) {
      cost = floralService.getCost();
    }
    return cost;
  }

  public int getTotalCost() {
    int sum = 0;
    if (cateringService != null) {
      sum += cateringService.getCost();
    }
    if (musicService != null) {
      sum += musicService.getCost();
    }
    if (floralService != null) {
      sum += floralService.getCost();
    }
    sum += venueCost;
    return sum;
  }
}
