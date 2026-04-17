import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents a utility class for counting trending topics.
 */
public class TrendingTopics {

  /**
   * Counts the number of occurrences of each topic in the given list.
   *
   * @param topics the list of topics
   * @return a map where each key is a topic and each value is its occurrence count
   */
  public Map<String, Long> countTopics(List<String> topics) {
    return topics.stream()
        .collect(Collectors.groupingBy(topic -> topic, Collectors.counting()));
  }
}