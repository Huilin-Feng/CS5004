package problem1;

import java.time.LocalDateTime;

public class OneTimeDonation extends Donation {

  public OneTimeDonation(double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
  }

  @Override
  public double getAmountForYear(int year) {
    if (getCreationDateTime().getYear() == year) {
      return getAmount();
    }
    return 0;
  }
}
