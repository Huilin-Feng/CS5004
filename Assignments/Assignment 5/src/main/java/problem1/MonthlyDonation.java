package problem1;

import java.time.LocalDateTime;

public class MonthlyDonation extends Donation {
  private LocalDateTime cancellationDateTime;

  public MonthlyDonation(double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
    this.cancellationDateTime = null;
  }

  public LocalDateTime getCancellationDateTime() {
    return cancellationDateTime;
  }

  public void setCancellationDateTime(LocalDateTime cancellationDateTime) {
    if (cancellationDateTime != null &&
        cancellationDateTime.isBefore(getCreationDateTime())) {
      throw new IllegalArgumentException(
          "Cancellation date/time cannot be before creation date/time.");
    }
    this.cancellationDateTime = cancellationDateTime;
  }

  @Override
  public double getAmountForYear(int year) {
    LocalDateTime creation = getCreationDateTime();

    if (year < creation.getYear()) {
      return 0;
    }

    int startMonth = 1;
    int endMonth = 12;

    if (year == creation.getYear()) {
      startMonth = creation.getMonthValue();
    }

    if (cancellationDateTime != null && year > cancellationDateTime.getYear()) {
      return 0;
    }

    if (cancellationDateTime != null && year == cancellationDateTime.getYear()) {
      endMonth = cancellationDateTime.getMonthValue();
    }

    if (endMonth < startMonth) {
      return 0;
    }

    int months = endMonth - startMonth + 1;
    return months * getAmount();
  }
}
