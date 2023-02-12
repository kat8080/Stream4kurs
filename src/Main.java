import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        findMinMax(Stream.of(1, 3, 4, 5, 8, 56, -54),
                Integer::compareTo, (min, max) -> {
                    System.out.println("min: " + min + "   max: " + max);
                });

        List<Integer> number = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).toList();
        byEvenNumber(number.stream());
    }

    //ЗАДАЧА 1
    public static <T> void findMinMax(Stream<? extends T> stream,
                                          Comparator<? super T> order,
                                          BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    //ЗАДАЧА 2
    public static void byEvenNumber(Stream<Integer> number) {
        List<Integer> l = number.filter(i -> i % 2 == 0).toList();
        System.out.println("Колличество четных чисел " + l.size());
        l.forEach(i -> System.out.print(i+" "));
    }
}