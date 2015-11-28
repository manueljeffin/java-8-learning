import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Used to refer to https://github.com/winterbe/java8-tutorial
 */
public class LambdaExpressions {

    private void InsteadofAnon() {

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
}
