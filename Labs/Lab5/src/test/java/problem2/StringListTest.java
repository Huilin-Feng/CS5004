package problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringListTest {

  private StringList empty() {
    return new EmptyStringList();
  }

  private StringList list(String... items) {
    StringList result = empty();
    // 反向构建，保证 list("a","b","c") 的顺序是 a -> b -> c
    for (int i = items.length - 1; i >= 0; i--) {
      result = new ConsStringList(items[i], result);
    }
    return result;
  }

  @Test
  public void testIsEmpty() {
    assertTrue(empty().isEmpty());
    assertFalse(list("a").isEmpty());
  }

  @Test
  public void testSize() {
    assertEquals(0, empty().size());
    assertEquals(1, list("a").size());
    assertEquals(3, list("a", "b", "c").size());
  }

  @Test
  public void testContains() {
    StringList xs = list("bob", "alice", "carol");
    assertTrue(xs.contains("bob"));
    assertTrue(xs.contains("alice"));
    assertFalse(xs.contains("dave"));
    assertFalse(empty().contains("anything"));
  }

  @Test
  public void testContainsAll_basic() {
    StringList xs = list("a", "b", "c");
    assertTrue(xs.containsAll(empty()));
    assertTrue(xs.containsAll(list("a")));
    assertTrue(xs.containsAll(list("b", "c")));
    assertFalse(xs.containsAll(list("a", "d")));
  }

  @Test
  public void testFilterLargerThan() {
    // 题目：移除 length > maxLength 的元素
    StringList xs = list("a", "bb", "ccc", "dddd");
    StringList filtered = xs.filterLargerThan(2);
    // 只保留 length <= 2 的："a", "bb"
    assertEquals(2, filtered.size());
    assertTrue(filtered.contains("a"));
    assertTrue(filtered.contains("bb"));
    assertFalse(filtered.contains("ccc"));
    assertFalse(filtered.contains("dddd"));
  }

  @Test
  public void testHasDuplicates_false() {
    assertFalse(empty().hasDuplicates());
    assertFalse(list("a").hasDuplicates());
    assertFalse(list("a", "b", "c").hasDuplicates());
  }

  @Test
  public void testHasDuplicates_true() {
    assertTrue(list("a", "b", "a").hasDuplicates());
    assertTrue(list("x", "x").hasDuplicates());
  }

  @Test
  public void testRemoveDuplicates() {
    StringList xs = list("a", "b", "a", "c", "b");
    StringList noDup = xs.removeDuplicates();

    assertFalse(noDup.hasDuplicates());
    assertTrue(noDup.contains("a"));
    assertTrue(noDup.contains("b"));
    assertTrue(noDup.contains("c"));
    assertEquals(3, noDup.size());
  }

  @Test
  public void testRemoveDuplicates_onEmptyAndSingleton() {
    assertEquals(0, empty().removeDuplicates().size());
    assertEquals(1, list("z").removeDuplicates().size());
  }
}
