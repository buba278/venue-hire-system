package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  // list of venues 
  private ArrayList<Venue> venues = new ArrayList<Venue>();
  // numbers to words for printing
  private final String[] numbers = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; 

  public VenueHireSystem() {}

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
      MessageCli.VENUE_ENTRY.printMessage(venue.getName(), venue.getCode(), String.valueOf(venue.getCapacity()), String.valueOf(venue.getHireFee()));
    }

    // less than 10 entries
    else if (venues.size() < 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", this.numbers[venues.size()], "s");
      for (Venue i : venues) {
        MessageCli.VENUE_ENTRY.printMessage(i.getName(), i.getCode(), String.valueOf(i.getCapacity()), String.valueOf(i.getHireFee()));
      }
    }

    // 10 or more entries
    else if (venues.size() >= 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(venues.size()), "s");
      for (Venue i : venues) {
        MessageCli.VENUE_ENTRY.printMessage(i.getName(), i.getCode(), String.valueOf(i.getCapacity()), String.valueOf(i.getHireFee()));
      }
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // TODO implement this method
  }
// 
  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
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
