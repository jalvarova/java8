package lambdasinaction.chap5;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationTest {

  public static void main(String[] args) throws FileNotFoundException {

    List<Double> number = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
    List<Double> number1 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
    List<List<Double>> someNumbers = Arrays.asList(number, number1);

    someNumbers.stream().map(x -> {
      System.out.println(x);
      return x;
    }).distinct().findFirst();

    number.stream().reduce(
        (x, y) ->
            Math.pow(x, y))
        .map(x -> {
          System.out.println(x);
          return x;
        });

    System.out.println(number);


    FileReader file = new FileReader("C:\\test\\a.txt");
    BufferedReader fileInput = new BufferedReader(file);


    try {
      // Print first 3 lines of file "C:\test\a.txt"
      for (int counter = 0; counter < 3; counter++)
        System.out.println(fileInput.readLine());

      fileInput.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


