package Prueba;

/**
 * Created by AntonioRang on 10/5/17.
 */
public class Algoritmos {
    public static void main(String[] args) {

        int[] lineSearch = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(LinearSearch (lineSearch, 5));

        System.out.println(BinarySearch (lineSearch, 10));

        int[] selectionS = {10,17,1,3,2,-20,90,78,100,109};
        System.out.println(selectionSort(selectionS));


        int[] insertionS = {10,17,1,3,2,100,99,900,60,-3};
        System.out.println(insertionSort(insertionS));

        int[] bubbleS = {10,17,1,3,2,100,99,900,60,-3};
        System.out.println(bubbleSort(bubbleS));



    }

    public static String insertionSort(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(j<i && arr[j] > arr[i]){
                    shiftContentsRight(arr, j, i);
                }
            }
        }



        String returnString= "[" + arr[0];


        for(int i =1; i< arr.length; i++) {
            returnString += ", " + arr[i];
        }

        returnString += "]";

        return  returnString;

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






    public static String selectionSort(int arr[]){
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


        String returnString= "[" + arr[0];


        for(int i =1; i< arr.length; i++) {
            returnString += ", " + arr[i];
        }

        returnString += "]";

        return  returnString;
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


    public static String bubbleSort(int[] arr){
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
        String returnString= "[" + arr[0];


        for(int i =1; i< arr.length; i++) {
            returnString += ", " + arr[i];
        }

        returnString += "]";

        return  returnString;
    }




}
