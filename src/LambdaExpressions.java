import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Used to refer to https://github.com/winterbe/java8-tutorial
 */
public class LambdaExpressions {

    public void LearnJava8() {

        List<Lambda> lambdaList = new ArrayList<>();

        lambdaList.add(new Lambda("o", 1));
        lambdaList.add(new Lambda("n", 2));
        lambdaList.add(new Lambda("n", 3));
        lambdaList.add(new Lambda("u", 4));
        lambdaList.add(new Lambda("m", 5));
        lambdaList.add(new Lambda("i", 6));
        lambdaList.add(new Lambda("l", 7));
        lambdaList.add(new Lambda("l", 8));
        lambdaList.add(new Lambda("a", 9));

        // no anonymous classes
        Collections.sort(lambdaList, (Lambda a, Lambda b) -> {
            return a.compare(b);
        });

        // Functional interfaces used to persist lambda expression and define comparator
        MyComparator<Lambda> myComparator = (a, b) -> a.compare(b);
        myComparator.compare(lambdaList.get(1), lambdaList.get(1));

        // Method referencing - Class Method referencing
        Lambda forReferencing = new Lambda("a", 1);
        MyComparator<Lambda> lambdaMyComparator = Lambda::compare;
        System.out.println("Class Method :" +lambdaMyComparator.compare(lambdaList.get(1), lambdaList.get(1)));

        // Object method referencing
        MyComparator<Lambda> lambdaMyComparator1 = forReferencing::compare1;
        System.out.println("Object method :" +lambdaMyComparator1.compare(lambdaList.get(1), lambdaList.get(1)));

        //constructor referencing
        LambdaFactory<Lambda> myFactory = Lambda::new;
        Lambda a = myFactory.create("adfa", 1);

        // One line isPalindrome tester made possible by Functional interface predicate, lambda
        Predicate<String> isPalindrome = (d) -> d.equals(new StringBuffer(d).reverse().toString());
        System.out.println(isPalindrome.test("aba"));

        Predicate<String> isEmpty = String::isEmpty;
        isEmpty.test("aba");

        // Functions Syntax: Input argument(1), return value
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<Integer, String> toString = String::valueOf;
        toInteger.andThen(toString).apply("123");

        // andThen and compose are opposites of 'Function' interface methods that allow composition
        // of multiple functions together.
        Function<String, String> selfCompose = toString.compose(toInteger);

        //Consumer
        Consumer<String> printer = (e) -> System.out.println(e);

        // Testing optional usage
        String b = "abcd";
        Optional<String> myOptional = Optional.of(b);
        myOptional.ifPresent(printer);
        myOptional.orElse("dcba");


        // stream and its operations or most of them
        Optional<String> out =  lambdaList.stream().filter((l) -> l.solluda > 3)
                .sorted((k, m) -> k.ennada.compareTo(m.ennada))
                .map((f) -> f.ennada)
                .reduce((g, h) -> g + "." + h);
        out.ifPresent((o) -> System.out.println(o));

        // Map operations
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.entrySet().stream().forEach((entry) -> System.out.println(entry));
        map.forEach((id, val) -> System.out.println(id + ": " + val));

        // similar to putIfAbsent there are other functions
        map.computeIfPresent(6, (num, value) -> value + num);
        map.computeIfAbsent(6, (num) -> "val" + num);

        // elegant way of setting counters using new map functions
        Map<Integer, Integer> intMap = new HashMap<>();
        intMap.putIfAbsent(23, 1);
        intMap.computeIfPresent(23, (num, val) -> val++);

        // instead of System.currentTimeMillis()
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        // creating Date object using Instant
        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date

        LocalDate date = LocalDate.now();
        date.plus(2, ChronoUnit.MONTHS);

    }

    public static void main(String[] args) {
        LambdaExpressions myLambda = new LambdaExpressions();
        myLambda.LearnJava8();
    }
}

class Lambda {
    public String ennada;

    public int solluda;

    public Lambda(String a, int b) {
        ennada = a;
        solluda = b;
    }

    public int compare(Lambda b) {
        return ennada.compareTo(b.ennada);
    }

    public int compare1(Lambda b, Lambda c) {
        return c.ennada.compareTo(b.ennada);
    }
}

@FunctionalInterface
interface MyComparator<T> {
    int compare(T a, T b);
}

interface LambdaFactory<L extends Lambda> {
    L create(String a, int b);
}