public class MyClass {
    // ROTATED BINARY SEARCH USING RECURSION
    public static void main(String args[]) {
      int[] arr = {5, 6, 7, 8, 1, 2, 3, 4};

      System.out.println(search(arr, 8, 0, arr.length-1));
    }
    
    static int search(int[] arr, int target, int start, int end){
        
        // cannot find in Array(base condition)
        if(start>end) return -1;
        
        // calculate mid of range(taking care of Integer Overflow)
        int mid = start + (end - start)/2;
        
        // element found return the index
        if(arr[mid]==target) return mid;
        
        // if mid is in increasing order range like between 1,2,3,4,5 and not 5,6,7,1,2,3,4
        if(arr[start]<=arr[mid]){
            // if target exists in that range(left part)
            if(target>=arr[start] && target<=arr[mid]){
                // search in the left part only
                return search(arr, target, start, mid-1);
            }else{
                // search in the right part
                return search(arr, target, mid+1, end);
            }
        }
        
        // if target exists on right side of mid and is less than end 
        if(arr[mid]<=target && target<=arr[end]){
            // search in right side
            return search(arr, target, mid+1, end);
        }
          
        // search in the left side      
        return search(arr, target, start, mid-1);
        
    }
}