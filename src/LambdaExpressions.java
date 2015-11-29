import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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