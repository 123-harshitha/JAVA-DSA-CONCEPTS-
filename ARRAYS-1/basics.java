public class basics {
    public static void main(String[] args){
        int[] arr = { 1,3,2,6,8,4,5,7};
        int key = 8;
        int result = linearSearch(arr, key);
        if(result == -1){
            System.out.println("Element not found in the array");
        }else{
            System.out.println("Element found at index: " + result);
        }
    }
    public static int linearSearch(int[] arr ,int key){
        for(int i =0 ; i< arr.length ; i++){
            if(arr[i]==key){
                return i ;
            }
        }
        return -1;
    }
}
