import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WarAndPiece {
    public static void main(String[] args) throws IOException {
        getWordsStream()
                .map(String::toLowerCase)
                .filter(word->word.length() > 3)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((pair1,pair2)-> pair2.getValue().compareTo(pair1.getValue()))
                .limit(20)
                .forEach(System.out::println);
    }
    public static Stream<String> getWordsStream() throws IOException {
        return new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Torents\\book1.txt"), Charset.forName("windows-1251")))
                .lines()
                .flatMap(lines-> Arrays.stream(lines.split(" ")));
    }
}
