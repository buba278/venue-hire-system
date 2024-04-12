package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.HashMap;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

  // list of venues
  private ArrayList<Venue> venues = new ArrayList<Venue>();

  // hashmap used codes (value pairs to referencevenue)
  // key = code, value = name
  private HashMap<String, Venue> codes = new HashMap<String, Venue>();

  // numbers to words for printing
  private final String[] numbers = new String[] { "", "one", "two", "three", "four",
      "five", "six", "seven", "eight", "nine" };

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
          String.valueOf(venue.getHireFee()), venue.getNextAvailableDate());
    }

    // less than 10 entries
    else if (venues.size() < 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", this.numbers[venues.size()], "s");
      for (Venue i : venues) {
        MessageCli.VENUE_ENTRY.printMessage(i.getName(), i.getCode(), String.valueOf(i.getCapacity()),
            String.valueOf(i.getHireFee()), i.getNextAvailableDate());
      }
    }

    // 10 or more entries
    else if (venues.size() >= 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(venues.size()), "s");
      for (Venue i : venues) {

        MessageCli.VENUE_ENTRY.printMessage(i.getName(), i.getCode(), String.valueOf(i.getCapacity()),
            String.valueOf(i.getHireFee()), i.getNextAvailableDate());
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
    updateAllVenueAvailability();
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
    Venue venue = codes.get(venueCode);

    // PRE CHECKS

    // date set
    if (systemDate.trim().equals("")) {
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      return;
    }
    // at least one venue in the system
    if (venues.size() == 0) {
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      return;
    }
    // venue code exist
    if (!codes.containsKey(venueCode)) {
      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(venueCode);
      return;
    }
    // date available
    if (!venue.checkDateAvailability(requestDate)) {
      MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(venue.getName(), requestDate);
      return;
    }

    // quantify dates in 0 = days, 1 = month, 2 = year
    String[] dateParts = requestDate.split("/");
    // magnify from year to day for sum value
    int dateSum = (Integer.valueOf(dateParts[2]) * 100) + (Integer.valueOf(dateParts[1]) * 10)
        + Integer.valueOf(dateParts[0]);
    // higher sum = later
    String[] currentDateParts = requestDate.split("/");
    int currentDateSum = (Integer.valueOf(currentDateParts[2]) * 100) + (Integer.valueOf(currentDateParts[1]) * 10)
        + Integer.valueOf(currentDateParts[0]);
    // date is today or later than current date
    if (dateSum < currentDateSum) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(requestDate, systemDate);
      return;
    }

    // NON IDEAL CHECKS
    if ((Double.valueOf(attendees) / venue.getCapacity()) < 0.25) {
      int newAttendees = (int) (venue.getCapacity() * 0.25);
      MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(attendees, String.valueOf(newAttendees),
          String.valueOf(venue.getCapacity()));
    } else if ((Integer.valueOf(attendees) / venue.getCapacity()) > 1.0) {
      int newAttendees = venue.getCapacity();
      MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(attendees, String.valueOf(newAttendees),
          String.valueOf(venue.getCapacity()));
    }

    // SUCCESFUL BOOKING
    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(bookingRef, venue.getName(), requestDate, attendees);
    venue.addBooking(venueCode, requestDate, email, attendees, bookingRef);

    updateVenueAvailability(venue);
  }

  // newly added method to get next day date
  private String getNextDayDate(String date) {
    String[] dateSplit = date.split("/");
    String nextDayDate;
    // if single digit add the zero before
    if ((Integer.valueOf(dateSplit[0]) / 10) < 1) {
      dateSplit[0] = String.valueOf(Integer.valueOf(dateSplit[0]) + 1);
      nextDayDate = "0" + dateSplit[0] + "/" + dateSplit[1] + "/" + dateSplit[2];
      return nextDayDate;
    }

    dateSplit[0] = String.valueOf(Integer.valueOf(dateSplit[0]) + 1);
    nextDayDate = dateSplit[0] + "/" + dateSplit[1] + "/" + dateSplit[2];
    return nextDayDate;
  }

  // new method, update all availabilities
  private void updateAllVenueAvailability() {
    String date = systemDate;
    for (Venue i : venues) {
      while (!i.checkDateAvailability(date)) {
        date = getNextDayDate(date);
      }
      i.setNextAvailableDate(date);
    }
  }

  private void updateVenueAvailability(Venue venue) {
    String date = systemDate;
    while (!venue.checkDateAvailability(date)) {
      date = getNextDayDate(date);
    }
    venue.setNextAvailableDate(date);
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
    // if venue code does not exist
    if (!codes.containsKey(venueCode)) {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
      return;
    }

    // print the header
    Venue venue = codes.get(venueCode);
    MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venue.getName());

    // if there are no bookings
    if (venue.getBookingReferences().isEmpty()) {
      MessageCli.PRINT_BOOKINGS_NONE.printMessage(venue.getName());
      return;
    }

    // print out each booking
    for (String reference : venue.getBookingReferences().keySet()) {
      MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(reference, venue.getBookingReferences().get(reference).getDate());
    }
  }

  //
  public boolean checkBookingReference(String bookingReference) {
    
    return true;
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
