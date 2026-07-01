package ArraysLearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        List<List<Integer>> interval = new ArrayList<>();
        interval.add(Arrays.asList(1,3));
        interval.add(Arrays.asList(2,6));
        interval.add(Arrays.asList(8,10));
        interval.add(Arrays.asList(15,18));
        interval.add(Arrays.asList(9,11));

        List<List<Integer>> result = getIntervalByOptimal(interval);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> getIntervalByOptimal(List<List<Integer>> arr) {
        int n = arr.size();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (ans.isEmpty() || arr.get(i).getFirst() > ans.get(ans.size() - 1).getLast()) {
                ans.add(Arrays.asList(arr.get(i).getFirst(), arr.get(i).getLast()));
            } else {
                ans.getLast(). set(
                  1, Math.max(ans.getLast().getLast() , arr.get(i).getLast())
                );
            }
        }
        return ans;
    }

    public static List<List<Integer>> getOverlappingInterval(List<List<Integer>> arr) {
        int n = arr.size();
        List<List<Integer>> ansList = new ArrayList<>();
        Collections.sort(arr, (a, b) -> Integer.compare(a.get(0), b.get(0)));


        for (int i = 0; i < n; i++) {
            int start = arr.get(i).getFirst();
            int end = arr.get(i).getLast();

            if (!ansList.isEmpty() && end <= ansList.get(ansList.size() - 1).getLast()) {
                continue;
            }

            for (int j = 0; j < n; j++) {
                if (arr.get(j).getFirst() <= end) {
                    end = Math.max(end, arr.get(j).getLast());
                } else {
                    break;
                }
            }

            ansList.add(Arrays.asList(start, end));
        }

        return ansList;
    }
}
