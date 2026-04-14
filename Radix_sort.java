package radix_sort;

public class Radix_sort {
    public static void main(String[] args) {
        int[] numbers = {12,40,25,250};
        radixSort(numbers);
        for(int num : numbers){
            System.out.print(num+"  ");
        }
     
    }
    
    public static void radixSort(int[] arr){
        
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max )
                max = arr[i];
        }
        // max = 250
        
        for(int exp=1; max / exp >0; exp*=10){
            countingSort(arr, exp);
        }
        
    }
    //12,40,25,250
    public static void countingSort(int[] arr, int exp){
        
        int[] output = new int[arr.length];
        int[] counts = new int[10]; //0-9
        
        for(int i=0; i<arr.length; i++)    //counts[2]=1;
            counts[(arr[i] / exp)%10]++;
        
        for(int i=1; i<10; i++)
            counts[i] = counts[i]+counts[i-1];   // counts[ 0]=2;  counts[1]=2, counts[2]=3, counts[3]=3;  counts[5]=4
        
        for(int i=arr.length-1; i>=0; i--){
            output[ counts[(arr[i]/exp)%10]-1 ] = arr[i];   // output[0]=40  , output[1]=250 , output[2]=12 , output[3]=25
            counts[(arr[i]/exp)%10]--;
        }
        
        for(int i=0; i<arr.length; i++)
            arr[i] = output[i];
        
        
            
        
        
        
    }
    
}
