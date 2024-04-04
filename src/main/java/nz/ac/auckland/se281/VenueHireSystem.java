package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.HashMap;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // list of venues
  private ArrayList<Venue> venues = new ArrayList<Venue>();

  // set of used codes
  // use a hashmap instead (value pairs to referencevenue) key = code, value =
  // name
  private HashMap<String, Venue> codes = new HashMap<String, Venue>();

  // numbers to words for printing
  private final String[] numbers = new String[] { "", "one", "two", "three", "four", "five", "six", "seven", "eight",
      "nine" };

  // setting up the system date variable
  private String systemDate = "";

  public VenueHireSystem() {
  }

  public void printVenues() {
    // TODO implement this method

    // Check if the venue list is empty
    if (venues.size() == 0) {
      MessageCli.NO_VENUES.printMessage();
      return;
    }
    // if only one entry
    else if (venues.size() == 1) {
      MessageCli.NUMBER_VENUES.printMessage("is", this.numbers[1], "");
      Venue venue = venues.get(0);
      MessageCli.VENUE_ENTRY.printMessage(venue.getName(), venue.getCode(), String.valueOf(venue.getCapacity()),
          String.valueOf(venue.getHireFee()));
    }

    // less than 10 entries
    else if (venues.size() < 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", this.numbers[venues.size()], "s");
      for (Venue i : venues) {
        MessageCli.VENUE_ENTRY.printMessage(i.getName(), i.getCode(), String.valueOf(i.getCapacity()),
            String.valueOf(i.getHireFee()));
      }
    }

    // 10 or more entries
    else if (venues.size() >= 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(venues.size()), "s");
      for (Venue i : venues) {
        MessageCli.VENUE_ENTRY.printMessage(i.getName(), i.getCode(), String.valueOf(i.getCapacity()),
            String.valueOf(i.getHireFee()));
      }
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // TODO implement this method

    // if code exists
    if (codes.containsKey(venueCode)) {
      MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, codes.get(venueCode).getName());
      return;
    }

    // if empty name
    if (venueName.strip().equals("")) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    }

    // if capacity not a number
    try {
      // if number not positive int (0 exclusive)
      if (Integer.parseInt(capacityInput) <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
        return;
      }
    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }
    // if hireFee not a number
    try {
      // if number not positive int (0 exclusive)
      if (Integer.parseInt(hireFeeInput) <= 0) {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
        return;
      }
    } catch (Exception e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }

    // if successful, add it to the arrayList and code set
    // make a new Venue instance
    Venue venue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    venues.add(venue);
    codes.put(venueCode, venue);

    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venue.getName(), venue.getCode());
  }

  //

  public void setSystemDate(String dateInput) {
    // TODO implement this method
    this.systemDate = dateInput;
    // print confirmation
    MessageCli.DATE_SET.printMessage(systemDate);
  }

  public void printSystemDate() {
    // TODO implement this method
    if (systemDate.trim().equals("")) {
      MessageCli.CURRENT_DATE.printMessage("not set");
    } else {
      MessageCli.CURRENT_DATE.printMessage(this.systemDate);
    }
  }

  public void makeBooking(String[] options) {
    // takes in code, date, email, attendee count
    // assume correct formats for all of these
    // TODO implement this method

    // options split
    String venueCode = options[0];
    String requestDate = options[1];
    String email = options[2];
    String attendees = options[3];

    String bookingRef = BookingReferenceGenerator.generateBookingReference();

    // pre checks

    // date set, and one venue in system
    if (systemDate.trim().equals("") || venues.size() == 0) {
      return;
    }

    // quantify dates in 0 = days, 1 = month, 2 = year
    String[] dateParts = requestDate.split("/");
    // magnify from year to day
    

    // venue code exist, date available, date not in past (today or later)
    if (!codes.containsKey(venueCode) || codes.get(venueCode).checkDateAvailability(requestDate)) {
      return;
    }

    if ()

    //

    // Succesful booking
    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(bookingRef, codes.get(venueCode).getName(), requestDate, attendees);

  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
