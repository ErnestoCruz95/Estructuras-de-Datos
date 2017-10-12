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

        int notHeap[] ={1,0, 24,18,-2,10};
        heapSort(notHeap);
        System.out.println(Arrays.toString(notHeap)+"\n");



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
        makeHeap(arr);
        int temp;
        int count = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            temp = removeTopItem(arr, arr.length-count);
            arr[i] = temp;
            count++;
        }

    }


}
