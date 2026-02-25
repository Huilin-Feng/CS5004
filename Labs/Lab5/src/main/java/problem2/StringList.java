package problem2;

/**
 * ADT representing a list of Strings.
 */
public interface StringList {

  /**
   * Checks whether the list is empty.
   *
   * @return true if empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Returns the number of elements in the list.
   *
   * @return the size of the list
   */
  int size();

  /**
   * Checks whether the given String is contained in the list.
   *
   * @param s the string to search for
   * @return true if present, false otherwise
   */
  boolean contains(String s);

  /**
   * Checks whether all elements of the given list are contained in this list.
   *
   * @param other another StringList
   * @return true if this list contains all elements of other, false otherwise
   */
  boolean containsAll(StringList other);

  /**
   * Removes all elements whose length is greater than maxLength.
   *
   * @param maxLength the maximum allowed length
   * @return a new list with long strings removed
   */
  StringList filterLargerThan(int maxLength);

  /**
   * Checks if the list has at least one duplicate element.
   *
   * @return true if there is a duplicate, false otherwise
   */
  boolean hasDuplicates();

  /**
   * Returns a list with all duplicates removed.
   *
   * @return a new list without duplicates
   */
  StringList removeDuplicates();
}
