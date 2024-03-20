package csci2011.plummerlab6;

/**
 *
 * @author chad.plummer
 */
public class PlummerLab6 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.println("Displaying array with " + array.length + " items:");
        displayArray(array);
        
        System.out.println("Calling displayReverse(Hello World!)");
        displayReverse("Hello World!");
        System.out.println();
        System.out.println("Calling factorial(5)");
        System.out.println(factorial(5));
        System.out.println();
        System.out.println("Calling factorial(20)");
        System.out.println(factorial(20));
        System.out.println();
        
        System.out.println("Calling binarySearch to search for 14");
        int[] array2 = {3, 6, 11, 14, 19, 23, 28, 33, 37};
        binarySearch(array2, 14);
        
        int[] array3 = {10, 11, 2, 3, 5, 4, 6, 7, 9, 1, 8};
        System.out.println("Array before calling quicksort");
        displayArray(array3);
        quicksort(array3);
        System.out.println("Array after calling quicksort");
        displayArray(array3);
    }
    /**
     * 
     * @param array used to identify which array is to be called
     * @param index used to identify which char within the array is being pointed to
     *displayArray uses recursion to print out each char of an array in the order that they are in
     * within the array
     **/
    private static void displayArray(int[] array, int index){
            if (index == array.length){
                System.out.println();
            }
            else{
                System.out.format("%3d", array[index]);
                displayArray(array, index + 1);
            }
        }
    //this is the public method for displayArray that is used in main
    public static void displayArray(int[] array){    
        displayArray(array, 0);
    }
    //displayReverse recursively displays each char in the array in reverse order
    public static void displayReverse(String plainText){
        if(plainText.length() == 0){
            
        }
        else{
            displayReverse(plainText.substring(1));
            System.out.print(plainText.charAt(0));
        }
    }
    //factorial recursively calls itself to find the factorial of a number
    public static long factorial(int number){
        if (number <= 1){
            return 1;
        }
        else{
            return number * factorial(number - 1);
        }
    }
    //displayArrayIndexes recursively calls itself to display each number with a space on both sides
    public static void displayArrayIndexes(int[] array, int current, int first, int middle, int last){
        if (current == array.length){
            System.out.println();
        }
        else{
            if(current == first){
                if(current == middle){
                    if(current == last){
                        System.out.format("FML");
                    }
                    else{
                        System.out.format("%3s" ,"FM");
                    } 
                }
                else{
                    System.out.format("%3s", "F");
                }
            }
            else if (current == middle && current != first){
                if(current == last){
                    System.out.format("%3s", "ML");
                }
                else{
                    System.out.format("%3s", "M");
                }
            }
            else if (current == last && current != middle){
                System.out.format("%3s", "L");
            }
            else{
                System.out.print("   ");
            }
            displayArrayIndexes(array, current + 1 , first, middle, last);            
        }
    }
    //bindarySearch calls displayArray and displayArrayIndexes and calls itself recursively to search for the number 14
    private static int binarySearch(int[] array, int query, int first, int last){
        int result = -1;
        int mid = (first + last) / 2;
        displayArray(array);
        displayArrayIndexes(array, 0, first, mid, last);
            if (query < array[mid]){
                result = binarySearch(array, query, first, mid-1);
            }
            else if (query == array[mid]){
                result = mid;
            }
            else if (query > array[mid]){
                result = binarySearch(array, query, mid + 1, last);
            }
            return result;
        
    }
    //this is the public method for binarySearch called within main
    public static void binarySearch(int[] array, int query){
        int result = binarySearch(array, query, 0, array.length-1);
        System.out.println("Result: " + result);
    }
    //partition splits the list in half with numbers above the pivot to the right and those below to the left
    private static int partition(int[] arr, int pi, int start, int last){
        int i = start;
        int j = last;
        
        while(i < j){
            while(arr[i] <= pi && i <= j){
                i++;
            }
                   
            while(arr[j] >= pi && i <= j){
                j--;
            }
            
            if(i < j){
                swap(arr, i, j);
            }
        }
        return j;
    }
    //used to swap the value of two indexes of an array. Called within partition and quicksort
    private static void swap(int [] arr, int index, int index2){
        int temp = arr[index];
        arr[index] = arr[index2];
        arr[index2] = temp;
    }
    //quicksort calls partition and then recursively calls itself to sort each half of the array.
    private static void quicksort(int[] arr, int start, int last){
        if(start >= last){
            
        }
        else{
            int pivot = partition(arr, arr[start], start, last);
            swap(arr, start, pivot);
            quicksort(arr, start, pivot - 1);
            quicksort(arr, pivot + 1, last);
        }
    }
    public static void quicksort(int[] arr){
        quicksort(arr, 0, arr.length-1);
    }
}
