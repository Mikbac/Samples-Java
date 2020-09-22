package pl.samples.VavrLibrary;

import io.vavr.Tuple;
import io.vavr.collection.CharSeq;
import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import io.vavr.control.Either;
import io.vavr.control.Option;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Predicates.isIn;
import static io.vavr.Predicates.is;


class Main {

    public static void main(String[] args) {

        // List(4, 5, 6)
        List.of(1, 2, 3, 4, 5, 6)
                .filter(i -> i > 3);

        final List<String> list = List.of("a", "bb", "ccc", "dddd");

        // 10
        list.foldLeft(0, (i, s) -> i + s.length());

        // abbcccdddd
        list.reduceLeft((acc, s) -> acc + s);

        // a, c
        CharSeq.of("abc")
                .filter(c -> c != 'b')
                .mkString(", ");

        // Lazy list
        Stream.tabulate(100, (i) -> i + 1);
        Stream.fill(100, () -> 10);

        // Map
        // Option <None>
        HashMap.of(1, "a", 2, "b", 3, "c")
                .get(5);

        // (1, a)
        HashMap.of(1, "a", 2, "b", 3, "c")
                .filterKeys(k -> k < 2);

        // (1, a), (2, b), (3, c)
        HashMap.of(1, "a", 2, "b", 3, "c")
                .filterValues(val -> val.length() == 1);

        // Option
        Option.of("123")
                .peek(System.out::println)
                .map(String::toUpperCase)
                .getOrElse("");

        // Empty Option
        Option.none();
        // Option from variable
        //Option.of(variable);
        // Option from JDK Option
        //Option.ofOptional(javaOptional);

        // Tuple
        HashMap.ofEntries(Tuple.of(1, "1"), Tuple.of(2, "2"), Tuple.of(3, "3"));

        // Either
        Either<String, Integer> ans1 = exampleOne(10);

        // Pattern Matching
        double ans2 =  Match(10).of(
                // var == 1
                Case($(is(1)), 1.0),
                // var == 2 || var == 3 || var == 4
                Case($(isIn(2, 3, 4)), 2.0),
                // var > 10
                Case($(i -> i > 10), 3.0),
                // else
                Case($(), 0)
        ).doubleValue();
    }

    // Either
    private static Either<String, Integer> exampleOne(final int var) {
        if(var != 10) {
            return Either.left("Var is not 10");
        } else {
            return Either.right(var);
        }
    }

}
