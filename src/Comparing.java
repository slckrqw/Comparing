import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Comparing {

    private static final Random random = new Random();

    static void testAdd(List<CollectionResult> results, int iterations) {
        long startTime, endTime;

        // Тестируем добавление элементов в ArrayList
        List<Integer> arrayList = new ArrayList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            arrayList.add(random.nextInt());
        }
        endTime = System.nanoTime();
        results.add(new CollectionResult("ArrayList add", iterations, endTime - startTime));

        // Тестируем добавление элементов в LinkedList
        List<Integer> linkedList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            linkedList.add(random.nextInt());
        }
        endTime = System.nanoTime();
        results.add(new CollectionResult("LinkedList add", iterations, endTime - startTime));
    }

    static void testDelete(List<CollectionResult> results, int iterations) {
        long startTime, endTime;

        // Тестируем удаление элементов из ArrayList
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            arrayList.add(random.nextInt());
        }
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            arrayList.remove(0); // Удаляем первый элемент
        }
        endTime = System.nanoTime();
        results.add(new CollectionResult("ArrayList remove", iterations, endTime - startTime));

        // Тестируем удаление элементов из LinkedList
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            linkedList.add(random.nextInt());
        }
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            linkedList.remove(0); // Удаляем первый элемент
        }
        endTime = System.nanoTime();
        results.add(new CollectionResult("LinkedList remove", iterations, endTime - startTime));
    }

    static void testGet(List<CollectionResult> results, int iterations) {
        long startTime, endTime;

        // Тестируем получение элемента из ArrayList
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            arrayList.add(random.nextInt());
        }
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            arrayList.get(random.nextInt(iterations)); // Получаем случайный элемент
        }
        endTime = System.nanoTime();
        results.add(new CollectionResult("ArrayList get", iterations, endTime - startTime));

        // Тестируем получение элемента из LinkedList
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            linkedList.add(random.nextInt());
        }
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            linkedList.get(random.nextInt(iterations)); // Получаем случайный элемент
        }
        endTime = System.nanoTime();
        results.add(new CollectionResult("LinkedList get", iterations, endTime - startTime));
    }

    static void printResultsTable(List<CollectionResult> results) {
        System.out.printf("%20s | %15s | %12s\n", "Метод", "Количество вызовов", "Время выполнения (нс)");
        System.out.println("-------------------------------------------------------------------------------");
        for (CollectionResult result : results) {
            System.out.printf("%20s | %15d | %12d\n",
                    result.methodName,
                    result.iterations,
                    result.executionTime);
        }
    }

    static class CollectionResult {
        String methodName;
        int iterations;
        long executionTime;

        public CollectionResult(String methodName, int iterations, long executionTime) {
            this.methodName = methodName;
            this.iterations = iterations;
            this.executionTime = executionTime;
        }
    }
}
