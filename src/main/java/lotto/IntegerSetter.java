package lotto;

import java.util.Set;

public class IntegerSetter {

    static void loopFromSet(Set<Integer> set) {
        for (Integer i : set) {
            System.out.println((i));
        }
    }

    static int CompareSets(Set<Integer> set, Set<Integer> set2) {
        int match = 0;
        for (Integer temp : set) {
            if (set2.contains(temp)) {
                match++;
            }
        }
        return match;
    }
}
