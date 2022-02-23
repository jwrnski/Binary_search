package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void Start(){
        System.out.print("Insert array size: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        makeArray(size);
    }

    public static void makeArray(int size){
        int[] tab = new int[size];
        System.out.print("Insert lower limit of randomized numbers: ");
        Scanner in = new Scanner(System.in);
        int lower = in.nextInt();
        System.out.print("Insert upper limit of randomized numbers: ");
        int upper = in.nextInt();
        System.out.print("Would you like to print the array before sorting? Select [y/n]");
        char decision = in.next().charAt(0);
        switch (decision){
            case 'y' | 'Y':
                print(tab, upper, lower, size);
                break;
            case 'n' | 'N':
                Random numbers = new Random();
                for(int c=0; c<size; c++) {
                    int r = numbers.nextInt(upper-lower)+lower;
                    tab[c] = r;
                }
                sort(tab, size);
                break;
        }
    }

    public static void sort(int[] tab, int size){
        System.out.println("\nSorted array:");
        int temp;
        for(int j=1; j<size; j++) {
            for(int i=0; i<size-1; i++) {
                if(tab[i] > tab[j]) {
                    temp = tab[j];
                    tab[j] = tab[i];
                    tab[i] = temp;
                }
            }
        }
        for(int c=0; c<size; c++) System.out.print(tab[c] + " ");
        binarySearch(tab, size);
    }
    public static void print(int[] tab, int upper, int lower, int size){
        Random numbers = new Random();
        for(int c=0; c<size; c++) {
            int r = numbers.nextInt(upper-lower)+lower;
            tab[c] = r;
            System.out.print(tab[c] + " ");
        }
        sort(tab, size);
    }

    public static void binarySearch(int[] tab, int size){
        int mid = size/2;
        int left = 0;
        int right = size-1;
        boolean found = false;
        Scanner in = new Scanner(System.in);
        System.out.print("\n\nEnter a searched number: ");
        int num = in.nextInt();
        while(!found && left <= right){
            if(num > tab[mid]) {
                left = mid+1;
                mid = (left+right) / 2;
            }
            else if(num < tab[mid]){
                right = mid-1;
                mid = (right+left) / 2;
            }
            else if(num == tab[mid]) found = true;
        }
        if(found) System.out.println("Number found.\nIndex: " + mid);
        else System.out.println("Number is not on the list.");
    }

    public static void main(String[] args) {
        Start();
    }
}

