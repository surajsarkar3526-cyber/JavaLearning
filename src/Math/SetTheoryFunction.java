package Math;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SetTheoryFunction {
    public static void main(String[] args) {

        Set<Integer> A = new HashSet<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> B = new HashSet<>(Arrays.asList(3,4,5));

        System.out.println("Set A : "+A);
        System.out.println("Set B : "+B);

        Set<Integer> union = new HashSet<>(A);
        union.addAll(B);

        System.out.println("Union : "+union);

        Set<Integer> intersection = new HashSet<>(A);
        intersection.retainAll(B);

        System.out.println("Intersection : "+intersection);

        Set<Integer> difference = new HashSet<>(A);
        difference.retainAll(B);

        System.out.println("A - B" + difference);

        Set<Integer> symmetric = new HashSet<>(A);
        symmetric.addAll(B);

        Set<Integer> common = new HashSet<>(A);
        common.retainAll(B);

        symmetric.removeAll(common);

        System.out.println("Symmetric difference :  "+symmetric);
    }
}
