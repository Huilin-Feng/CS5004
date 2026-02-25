package problem2;

/**
 * Represents an empty list of Strings.
 */
public class EmptyStringList implements StringList {

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean contains(String s) {
    return false;
  }

  @Override
  public boolean containsAll(StringList other) {
    return other.isEmpty();
  }

  @Override
  public StringList filterLargerThan(int maxLength) {
    return this;
  }

  @Override
  public boolean hasDuplicates() {
    return false;
  }

  @Override
  public StringList removeDuplicates() {
    return this;
  }
}
