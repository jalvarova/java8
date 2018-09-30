package lambdasinaction.chap3;

import java.io.*;

public class ExecuteAround {

    public static void main(String... args) throws IOException {

        CalculatorOperation calculatorOperation;

        OperationsNumerics operationsNumerics = (x, y) -> 1.0 + 2.0;
        System.out.println("Numeros" + operationsNumerics + "\n");
        // method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

        String oneLine = processBufferFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);

        String twoLines = processBufferFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);

    }

    public static String processFileLimited() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("D:\\6.-FeelingProgramming\\bcp\\java8\\src\\main\\resources/lambdasinaction/chap3/data.txt"))) {
            return br.readLine();
        }
    }


    public static String processBufferFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\6.-FeelingProgramming\\bcp\\java8\\src\\main\\resources/lambdasinaction/chap3/data.txt"))) {
            return p.process(br);
        }
    }

    public static String processFile(FileProcessor fr) {
        return "";
    }


    public interface BufferedReaderProcessor {
        public String process(BufferedReader b) throws IOException;

    }

    public interface FileProcessor {
        public String procces(File file);
    }
}
