import java.util.ArrayList;
import java.util.List;

public class Pascal {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultlst = new ArrayList<>();

        if (numRows <= 0) return resultlst;

        // First row
        List<Integer> firstlst = new ArrayList<>();
        firstlst.add(1);
        resultlst.add(firstlst);

        List<Integer> prevlst = firstlst;

        for (int i = 2; i <= numRows; i++) {
            List<Integer> currlst = new ArrayList<>();
            currlst.add(1); // First element is always 1

            for (int j = 1; j < i - 1; j++) {
                currlst.add(prevlst.get(j - 1) + prevlst.get(j));
            }

            currlst.add(1); // Last element is always 1
            resultlst.add(currlst);
            prevlst = currlst;
        }

        return resultlst;
    }

    public static void main(String[] args) {
        Pascal s = new Pascal();
        System.out.println(s.generate(5));

    }
}
