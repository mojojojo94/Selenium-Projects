Iterative way:
1) Initialize start and end indexes. 
start = 0, end = n-1
2) In a loop, swap arr[start] with arr[end] and change start and end as follows.
start = start +1; end = end – 1

Java
// Java program to reverse an array

import java.io.*;
 
class ReverseArray {
 
    /* Function to reverse arr[] from start to end*/
    static void rvereseArray(int arr[], int start, int end)
    {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        rvereseArray(arr, start+1, end-1);
    }
 
    /* Utility that prints out an array on a line */
    static void printArray(int arr[], int size)
    {
        int i;
        for (i=0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
 
    /*Driver function to check for above functions*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr, 6);
        rvereseArray(arr, 0, 5);
        System.out.println("Reversed array is ");
        printArray(arr, 6);
    }
}

Output:
1 2 3 4 5 6 
Reversed array is 
6 5 4 3 2 1 
Time Complexity: O(n)

////////////////////////////////////////////////////////////


Recursive Way:
1) Initialize start and end indexes
start = 0, end = n-1
2) Swap arr[start] with arr[end]
3) Recursively call reverse for rest of the array.

// Recursive Java Program to reverse an array
import java.io.*;
 
class ReverseArray {
 
    /* Function to reverse arr[] from start to end*/
    static void rvereseArray(int arr[], int start, int end)
    {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        rvereseArray(arr, start+1, end-1);
    }
 
    /* Utility that prints out an array on a line */
    static void printArray(int arr[], int size)
    {
        for (int i=0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
 
    /*Driver function to check for above functions*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr, 6);
        rvereseArray(arr, 0, 5);
        System.out.println("Reversed array is ");
        printArray(arr, 6);
    }
}

Output:
1 2 3 4 5 6 
Reversed array is 
6 5 4 3 2 1 
Time Complexity: O(n)