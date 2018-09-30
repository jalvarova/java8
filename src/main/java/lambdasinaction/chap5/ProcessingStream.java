package lambdasinaction.chap5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ProcessingStream {

  public static void main(String[] args) {

    List<String> lenguaje = Arrays.asList("C#", "Java", "Kotlin", "JavaScript", "C++");

    Stream<String> s = lenguaje.stream();

    s.forEach(System.out::println);

    Stream<String> sf = lenguaje
        .stream()
        .filter(x -> x.contains("J"));
    sf.forEach(System.out::println);
  }
}