package GREEDY_ALOGORITHM;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapscak {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50; // capacity of knapsack

        // Step 1: Calculate ratio (value/weight) for each item
        double ratio[][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i; 
            ratio[i][1] = val[i] / (double) weight[i]; 
        }

        // Step 2: Sort items in descending order of ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> -o[1]));

        int capacity = W;
        double finalValue = 0;

        // Step 3: Pick items
        for (int i = 0; i < ratio.length; i++) {
            int idx = (int) ratio[i][0];

            if (capacity >= weight[idx]) {
                finalValue += val[idx];
                capacity -= weight[idx];
            } else {
                double fraction = (double) capacity / weight[idx];
                finalValue += val[idx] * fraction;
                break; 
            }
        }

        // Final Output
        System.out.println("the Maximum Value  is " + finalValue);
    }
}

