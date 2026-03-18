public class Program2 {

  public static void printArray(Integer[] arr) {
    for (Integer element : arr) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  public static void printArray(Double[] arr) {
    for (Double element : arr) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  public static void printArray(Character[] arr) {
    for (Character element : arr) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  public static void printArray(String[] arr) {
    for (String element : arr) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Integer[] intArr = {1, 2, 3, 4, 5};
    Double[] doubArr = {1.1, 2.2, 3.3, 4.4};
    Character[] charArr = {'H', 'E', 'L', 'L', 'O'};
    String[] strArr = {"once", "upon", "a", "time"};

    printArray(intArr);
    printArray(doubArr);
    printArray(charArr);
    printArray(strArr);
  }
}
