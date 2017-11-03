package Prueba;

import java.util.Arrays;

/**
 * Created by AntonioRang on 10/5/17.
 */
public class Algoritmos {
    public static void main(String[] args) {

        int[] lineSearch = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(LinearSearch (lineSearch, 5));
        System.out.println(BinarySearch (lineSearch, 10));


        System.out.println("Selection Sort");
        int[] selectionS = {10,17,1,3,2,-20,90,78,100,109};
        System.out.println(Arrays.toString(selectionS));
        selectionSort(selectionS);
        System.out.println("Selection Sort: "+Arrays.toString(selectionS));
        System.out.println("\n\n");



        System.out.println("Inserion Sort");
        int[] insertionS = {10,17,1,3,2,100,99,900,60,-3};
        System.out.println(Arrays.toString(insertionS));
        insertionSort(insertionS);
        System.out.println("Insertion Sort: "+Arrays.toString(insertionS));
        System.out.println("\n\n");


        System.out.println("Bubble Sort");
        int[] bubbleS = {10,17,1,3,2,100,99,900,60,-3};
        System.out.println(Arrays.toString(bubbleS));
        bubbleSort(bubbleS);
        System.out.println("Bubble Sort: "+Arrays.toString(bubbleS));
        System.out.println("\n\n");


        System.out.println("Heaps");
        int uArray[] ={1,0, 24,18,-2,10};
        System.out.println(Arrays.toString(uArray)+"\n");
        System.out.println("MakeHeap:");
        makeHeap(uArray);
        System.out.println(Arrays.toString(uArray)+"\n");

        System.out.println("RemoveTopItem:");
        removeTopItem(uArray, uArray.length);
        System.out.println(Arrays.toString(uArray));
        System.out.println("\n");
        
        System.out.println("HeapShort con:");
        int notHeap[] ={1,0, 24,18,-2,10};
        System.out.println(Arrays.toString(notHeap));
        heapSort(notHeap);
        System.out.println(Arrays.toString(notHeap)+"\n");


        int uArray1[] = {10,4,1,240,1024,23,21,348,0,8000,10004,3,14};

        System.out.println("Before: " + Arrays.toString(uArray1));
        quickSort(uArray1, 0, uArray1.length-1);
        System.out.println("After quicksort: " + Arrays.toString(uArray1));
        int notHeap[] ={1,0, 24,18,-2,10};
        heapSort(notHeap);
        System.out.println(Arrays.toString(notHeap)+"\n");
        System.out.println("\n\n");

        System.out.println("Merge Sort");
        int[] uArray3 = {10,17,1,3,2,100,99,900,60,-3};
        int[] scratch = new int[uArray3.length];
        System.out.println(Arrays.toString(uArray3));
        mergeSort(uArray3, scratch, 0, uArray3.length-1);
        System.out.println("Merge Sort: "+Arrays.toString(uArray3));
        System.out.println("\n\n");



    }

    public static void insertionSort(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(j<i && arr[j] > arr[i]){
                    shiftContentsRight(arr, j, i);
                }
            }
        }

    }

    public static void shiftContentsRight(int arr[], int start, int end) {
        if((start < 0 || start > arr.length) ) {
            throw new IndexOutOfBoundsException();
        }

        int valueToMove = arr[end];

        for(int i = arr.length-1; i >= start; i--) {

            if(i < end) {
                arr[i + 1] = arr[i];
            }
        }

        arr[start] = valueToMove;

    }






    public static void selectionSort(int arr[]){
        int smallest=0, place=0;
        for (int i = 0; i < arr.length; i++) {
            smallest=arr[i];

            for (int j = i; j < arr.length; j++) {

                if(smallest>=arr[j]) {
                    smallest=arr[j];
                    place=j;
                }
            }

            arr[place]=arr[i];
            arr[i]=smallest;
        }
    }


    public static int LinearSearch(int[] Array, int target) {

        int response = -1;


        for(int j=0; j < Array.length; j++) {

            if(Array[j]==target) {
                response = 1;
                return response;
            }

            if (Array[j]>target) {
                response = -1;
                return response;
            }
        }

        return response;

    }



    public static int BinarySearch(int[] Array, int target) {

        int min = 0;
        int max = Array.length-1;

        while(min<=max) {
            int mid = (max+min)/2;
            if(target<Array[mid]) {
                max=mid-1;
            }
            else if(target>Array[mid]) {
                min=mid+1;
            }
            else  {
                return mid;
            }
        }

        return -1;

    }


    public static void bubbleSort(int[] arr){
        boolean notSorted =true;

        while(notSorted){
            notSorted =false;

            for (int i = 1; i < arr.length; i++) {
                if(arr[i] < arr[i-1]){
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    notSorted = true;
                }
            }

        }

    }


    public static void makeHeap(int arr[]){

        for (int i = 0; i < arr.length; i++) {
            int index=i;

            while(i != 0){
                int parent = (index-1) / 2 ;

                if(arr[index] <= arr[parent]){
                    break;
                }

                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;

                index = parent;
            }

        }
    }

    public static int removeTopItem(int arr[], int count){

        int result= arr[0];

        arr[0] = arr[count-1];

        int index =0;


        while(true){
            int childi = 2 *index +1;
            int childi2 = 2* index +2;

            if(childi >= count){
                childi =index;
            }

            if(childi2 >= count){
                childi2 = index;
            }

            if(arr[index] >= arr[childi] && arr[index] >= arr[childi2]){
                break;
            }
            int swapChild = childi;
            if(arr[childi2] > arr[childi]){
                swapChild = childi2;
            }

            int temp = arr[index];
            arr[index] = arr[swapChild];
            arr[swapChild] = temp;

            index = swapChild;

        }

        return result;
    }

    public static void heapSort(int arr[]){
    		int value;
        int k = arr.length;	
        makeHeap(arr);
        
        for (int i = arr.length-1; i >= 0; i--) {
            value = removeTopItem(arr, k);
            arr[i] = value;
            k--;
        }

    }
    
    public static void quickSort(int[] arr, int start, int end){
        // If the list has no more than one element, it's sorted
        if(start >= end){
            return;
        }
        // Use the first item as the dividing item
        int divider = arr[start];

        // Move items < divider to the front of the array and
        //items >= divider to the end of the array

        Stack<Integer> before = new Stack<Integer>();
        Stack<Integer> after = new Stack<Integer>();

        for (int i = start+1; i <= end ; i++) {
            if(arr[i] < divider){
                before.push(arr[i]);
            } else{
                after.push(arr[i]);
            }
        }

        int j = start;
        while(! before.empty()){
            arr[j++] = before.pop();
        }
        int middle = j++;
        arr[middle] = divider;

        while(! after.empty()){
            arr[j++] = after.pop();
        }


        //Recursively sort the two halves
        quickSort(arr, start, middle - 1);
        quickSort(arr, middle + 1, arr.length-1);

    }

    public static void mergeSort(int [] arr, int[] arrs, int start, int end) {

        if (start >= end) {
            return;
        }

        int midpoint = (start+end)/2;

        mergeSort(arr,arrs,start,midpoint);
        mergeSort(arr,arrs,midpoint+1,end);

        int leftIndex = start;
        int rightIndex = midpoint + 1;

        int scratchIndex = leftIndex;

        while(leftIndex <= midpoint && rightIndex <= end) {

            if(arr[leftIndex] <= arr[rightIndex]) {
                arrs[scratchIndex] = arr[leftIndex++];

            }else {
                arrs[scratchIndex] = arr[rightIndex++];

            }

            scratchIndex++;
        }

        for (int i = leftIndex; i <= midpoint ; i++) {
            arrs[scratchIndex++] = arr[i];

        }

        for (int i = rightIndex; i <= end ; i++) {
            arrs[scratchIndex++] = arr[i];

        }

        for (int i = start; i <= end; i++) {
            arr[i]=arrs[i];
        }

    }


}
