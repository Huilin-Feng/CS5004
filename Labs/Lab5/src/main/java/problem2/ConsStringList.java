package problem2;

/**
 * Represents a non-empty list of Strings.
 */
public class ConsStringList implements StringList {

  private String first;
  private StringList rest;

  /**
   * Constructs a non-empty list node.
   *
   * @param first the first string
   * @param rest the rest of the list
   */
  public ConsStringList(String first, StringList rest) {
    this.first = first;
    this.rest = rest;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    return 1 + this.rest.size();
  }

  @Override
  public boolean contains(String s) {
    return this.first.equals(s) || this.rest.contains(s);
  }

  @Override
  public boolean containsAll(StringList other) {
    if (other.isEmpty()) {
      return true;
    }
    // other must be ConsStringList if it's not empty
    ConsStringList o = (ConsStringList) other;
    return this.contains(o.first) && this.containsAll(o.rest);
  }

  @Override
  public StringList filterLargerThan(int maxLength) {
    if (this.first.length() > maxLength) {
      return this.rest.filterLargerThan(maxLength);
    }
    return new ConsStringList(this.first, this.rest.filterLargerThan(maxLength));
  }

  @Override
  public boolean hasDuplicates() {
    return this.rest.contains(this.first) || this.rest.hasDuplicates();
  }

  @Override
  public StringList removeDuplicates() {
    StringList cleanedRest = this.rest.removeDuplicates();
    if (cleanedRest.contains(this.first)) {
      return cleanedRest;
    }
    return new ConsStringList(this.first, cleanedRest);
  }
}
