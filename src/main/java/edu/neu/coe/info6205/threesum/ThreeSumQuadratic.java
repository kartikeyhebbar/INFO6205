package edu.neu.coe.info6205.threesum;

import java.util.*;

/**
 * Implementation of ThreeSum which follows the approach of dividing the solution-space into
 * N sub-spaces where each sub-space corresponds to a fixed value for the middle index of the three values.
 * Each sub-space is then solved by expanding the scope of the other two indices outwards from the starting point.
 * Since each sub-space can be solved in O(N) time, the overall complexity is O(N^2).
 * <p>
 * NOTE: The array provided in the constructor MUST be ordered.
 */
public class ThreeSumQuadratic implements ThreeSum {
    /**
     * Construct a ThreeSumQuadratic on a.
     * @param a a sorted array.
     */
    public ThreeSumQuadratic(int[] a) {
        this.a = a;
        length = a.length;
    }

    public Triple[] getTriples() {
        List<Triple> triples = new ArrayList<>();
        for (int i = 0; i < length-1; i++) triples.addAll(getTriples(i));
        Collections.sort(triples);
        return triples.stream().distinct().toArray(Triple[]::new);
    }

    /**
     * Get a list of Triples such that the middle index is the given value j.
     *
     * @param j the index of the middle value.
     * @return a Triple such that
     */
    public List<Triple> getTriples(int i) {
        List<Triple> triples = new ArrayList<>();
        // TO BE IMPLEMENTED  : for each candidate, test if a[i] + a[j] + a[k] = 0.
        Set<Integer> set = new HashSet<>();

        for(int j=i+1; j<length; j++) {
            int thirdNum = -(a[i] + a[j]);

            // if the set contains the computed third number, it means we have a valid triplet
            if(set.contains(thirdNum)) {
                List<Integer> temp = Arrays.asList(a[i], a[j], thirdNum);
                temp.sort(null);    // sort the triplet set
                triples.add(new Triple(temp.get(0), temp.get(1), temp.get(2)));
            }
            // we will add the j'th value of the array to the set
            set.add(a[j]);
        }
        return triples;
    }

    private final int[] a;
    private final int length;
}