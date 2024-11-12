import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int ITERATIONS = 10_000; // Количество итераций для тестов

    public static void main(String[] args) {
        List<Comparing.CollectionResult> results = new ArrayList<>();

        Comparing.testAdd(results, ITERATIONS);
        Comparing.testDelete(results, ITERATIONS);
        Comparing.testGet(results, ITERATIONS);

        Comparing.printResultsTable(results);
    }
}