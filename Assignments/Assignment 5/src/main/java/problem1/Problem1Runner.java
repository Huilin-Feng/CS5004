package problem1;

import java.time.LocalDateTime;

public class Problem1Runner {
  public static void main(String[] args) {
    NonProfit nonprofit = new NonProfit("Helping Hands");

    OneTimeDonation d1 = new OneTimeDonation(100,
        LocalDateTime.of(2026, 2, 15, 17, 45));

    MonthlyDonation d2 = new MonthlyDonation(25,
        LocalDateTime.of(2026, 2, 15, 17, 45));

    Pledge d3 = new Pledge(500,
        LocalDateTime.of(2026, 3, 1, 10, 0));
    d3.setProcessingDateTime(LocalDateTime.of(2027, 1, 10, 9, 0));

    nonprofit.addDonation(d1);
    nonprofit.addDonation(d2);
    nonprofit.addDonation(d3);

    System.out.println("2026 total: " + nonprofit.getTotalDonationsForYear(2026));
    System.out.println("2027 total: " + nonprofit.getTotalDonationsForYear(2027));
  }
}
