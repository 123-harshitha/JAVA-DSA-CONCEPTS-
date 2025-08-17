package GREEDY_ALOGORITHM;

import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1 , 3, 0, 5,8, 5};
        int end [] = {2 ,4  , 6, 7, 9,9};

        //step1 ; store the activities {index , start , end}
       int activities[][] = new int[start.length][3];
       for(int i =0 ;i<start.length;i++){
          activities[i][0] = i;
          activities[i][1] = start[i];
          activities[i][2] = end[i];
       }

        //step2 : sort the activities based on the end time (greedy choice)

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        //step3 : select the first activity

        int maxAct = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        //step4 :check the remaining activities

        for(int i =1 ;i<end.length;i++){
            if(activities[i][1]>= lastEnd){
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd= activities[i][2];
            }
        }
        //step5 : print the result 
        System.out.println("maximimum number of activites " + maxAct);
        System.out.println("the selected activites(index)");
        for(int i : ans){
            System.out.println(i);
        }
    }
    

    
}
