package ua.training;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

    int [] array = new int[]{0,1,3,5,-1,7,9,2,4,6,8};

    int summ = 0;
    for (int i = 0; i < array.length; i++){
        summ +=i;
    }
    double averageWithoutStream = (double) summ/array.length;

        double averageWithStream = IntStream.of(array)
                .average().orElse(0);

        double minElement = IntStream.of(array).min().orElse(0);

        int indexOfMinElement = IntStream.range(0,array.length)
                .reduce((i,j) -> array[i] > array[j] ? j : i)
                .orElse(0);

        long countZeroElements = IntStream.of(array)
                .filter(x -> x == 0).count();

        long countElementsMoreThanZero = IntStream.of(array)
                .filter(x->x>0).count();

        printText("averageWithoutStream: " + averageWithoutStream);
        printText("averageWithStream: " + averageWithStream);
        printText("minElement: " + minElement);
        printText("indexOfMinElement: " + indexOfMinElement);
        printText("countZeroElements: " + countZeroElements);
        printText("countElementsMoreThanZero: " + countElementsMoreThanZero);
        printText("All elements from massive multiply on 100: ");

        IntStream.of(array)
                .map(x -> x*100).forEach(System.out::println);

    }
    private static void printText ( String value){
        System.out.println(value);
    }
}
