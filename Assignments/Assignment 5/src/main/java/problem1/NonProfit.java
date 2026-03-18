package problem1;

import java.util.ArrayList;
import java.util.List;

public class NonProfit {
  private String name;
  private List<Donation> donations;

  public NonProfit(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name cannot be null or blank.");
    }
    this.name = name;
    this.donations = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public List<Donation> getDonations() {
    return new ArrayList<>(donations);
  }

  public void addDonation(Donation donation) {
    if (donation == null) {
      throw new IllegalArgumentException("Donation cannot be null.");
    }
    donations.add(donation);
  }

  public double getTotalDonationsForYear(int year) {
    double total = 0;
    for (Donation donation : donations) {
      total += donation.getAmountForYear(year);
    }
    return total;
  }
}
