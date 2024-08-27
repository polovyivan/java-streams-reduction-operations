package com.polovyi.ivan.tutorials;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamReduction {

    public static void main(String[] args) {
        System.out.println("Count method");

        long example1 = Stream.of(1, 2, 3)
                .count();
        // 3
        System.out.println("example1 = " + example1);

        long example2 = Stream.of(1, 2, 3)
                .filter(n -> n != 1)
                .count();
        // 2
        System.out.println("example2 = " + example2);

        long example3 = IntStream.of(1, 2, 3)
                .count();
        System.out.println("example3 = " + example3);

        System.out.println("Min method");
        Optional<Integer> example4 = Stream.of(1, 2, 3)
                .min(Integer::compare);
        // Optional[1]
        System.out.println("example4 = " + example4);

        Optional<Integer> example5 = Stream.<Integer>empty()
                .min(Integer::compare);
        // Optional.empty
        System.out.println("example5 = " + example5);

        Optional<LocalDate> example6 = Stream.of(
                        LocalDate.of(2024, 8, 25),
                        LocalDate.of(2024, 8, 26))
                .min(Comparator.comparing(LocalDate::toEpochDay));
        // Optional[2024-08-25]
        System.out.println("example6 = " + example6);

        Optional<LocalDate> example7 = Stream.of(
                        LocalDate.of(2024, 8, 25),
                        LocalDate.of(2024, 8, 26))
                .min(Comparator.naturalOrder());
        // Optional[2024-08-25]
        System.out.println("example7 = " + example7);

        OptionalInt example8 = IntStream.of(1, 2, 3)
                .min();
        // OptionalInt[1]
        System.out.println("example8 = " + example8);

        System.out.println("Max method");
        Optional<Integer> example9 = Stream.of(1, 2, 3)
                .max(Integer::compare);
        // Optional[3]
        System.out.println("example9 = " + example9);

        Optional<Integer> example10 = Stream.<Integer>empty()
                .max(Integer::compare);
        // Optional.empty
        System.out.println("example10 = " + example10);

        Optional<LocalDate> example11 = Stream.of(
                        LocalDate.of(2024, 8, 25),
                        LocalDate.of(2024, 8, 26))
                .max(Comparator.comparing(LocalDate::toEpochDay));
        // Optional[2024-08-26]
        System.out.println("example11 = " + example11);

        Optional<LocalDate> example12 = Stream.of(
                        LocalDate.of(2024, 8, 25),
                        LocalDate.of(2024, 8, 26))
                .max(Comparator.naturalOrder());
        // Optional[2024-08-26]
        System.out.println("example12 = " + example12);

        OptionalInt example13 = IntStream.of(1, 2, 3)
                .max();
        // OptionalInt[3]
        System.out.println("example13 = " + example13);

        System.out.println("Reduce method");
        Optional<Integer> example14 = Stream.of(0, 1, 2)
                .reduce((a, b) -> a + b);
        // Optional[3] (0 + 1 + 2 = 3)
        // I.  a(0) + b(1) = 1
        // II. a(1) + b(2) = 3
        System.out.println("example14 = " + example14);

        Optional<Integer> example15 = Stream.<Integer>empty()
                .reduce((a, b) -> a + b);
        // Optional.empty
        System.out.println("example15 = " + example15);

        Integer example16 = Stream.of(1, 2, 3)
                .reduce(10, (a, b) -> a + b);
        // 16 (10 + 1 + 2 + 3 = 16)
        // I.  a(10) + b(1) = 11
        // II. a(11) + b(2) = 13
        // II. a(13) + b(3) = 16
        System.out.println("example16 = " + example16);

        Integer example17 = Stream.<Integer>empty()
                .reduce(10, (a, b) -> a + b);
        // 10
        System.out.println("example17 = " + example17);

        Integer example18 = Stream.of(1, 2, 3)
                .parallel()
                .reduce(0, (a, b) -> a + b, Integer::sum);
        // 6
        System.out.println("example18 = " + example18);

        Integer example19 = Stream.<Integer>empty()
                .parallel()
                .reduce(0, (a, b) -> a + b, Integer::sum);
        // 0
        System.out.println("example19 = " + example19);

        Integer example20 = Stream.of(1, 2, 3)
                .parallel()
                .reduce(10, (a, b) -> a + b, Integer::sum);
        // 36
        System.out.println("example20 = " + example20);

        OptionalInt example21 = IntStream.of(0, 1, 2)
                .reduce((a, b) -> a + b);
        // Optional[3]
        System.out.println("example21 = " + example21);

        int example22 = IntStream.of(0, 1, 2)
                .reduce(10, (a, b) -> a + b);
        // 13
        System.out.println("example22 = " + example22);


        System.out.println("Sum method");
        int example23 = IntStream.of(1, 2, 3)
                .sum();
        // 6
        System.out.println("example23 = " + example23);

        long example24 = LongStream.of(1L, 2L, 3L)
                .sum();
        // 6
        System.out.println("example24 = " + example24);

        double example25 = DoubleStream.of(1.1, 2.2, 3.3)
                .sum();
        // 6.6
        System.out.println("example25 = " + example25);


        System.out.println("Average method");
        OptionalDouble example26 = IntStream.of(1, 2, 3)
                .average();
        // OptionalDouble[2.0]
        System.out.println("example26 = " + example26);

        OptionalDouble example27 = LongStream.of(1L, 2L, 3L)
                .average();
        // OptionalDouble[2.0]
        System.out.println("example27 = " + example27);

        OptionalDouble example28 = DoubleStream.of(1.1, 2.2, 3.3)
                .average();
        // OptionalDouble[2.1999999999999997]
        System.out.println("example28 = " + example28);


        System.out.println("Summary statistics method");
        IntSummaryStatistics example29 = IntStream.of(1, 2, 3)
                .summaryStatistics();
        long example29Count = example29.getCount();
        // 3
        System.out.println("count = " + example29Count);
        long example29Sum = example29.getSum();
        // 6
        System.out.println("example29Sum = " + example29Sum);
        int example29Min = example29.getMin();
        // 1
        System.out.println("example29Min = " + example29Min);
        int example29Max = example29.getMax();
        // 3
        System.out.println("example29Max = " + example29Max);
        double example29Average = example29.getAverage();
        // 2.0
        System.out.println("example29Average = " + example29Average);
        example29.combine(IntStream.of(4, 5, 6)
                .summaryStatistics());
        // {count=6, sum=21, min=1, average=3,500000, max=6}
        System.out.println("example29 = " + example29);

        example29.accept(10);
        // {count=7, sum=31, min=1, average=4,428571, max=10}
        System.out.println("example29 = " + example29);

        IntSummaryStatistics example30 = IntStream.empty()
                .summaryStatistics();
        // {count=0, sum=0, min=2147483647, average=0,000000, max=-2147483648}
        System.out.println("example30 = " + example30);


    }
}
