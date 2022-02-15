import java.util.*;

public class Main {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    arr.add(5);
      
    int[] nums = new int[arr.size()];
    int i=0;
    for(int val: arr){
        nums[i] = val;
        i++;
    }

    for(int num: nums){
      System.out.println(num);
    }
  }
}