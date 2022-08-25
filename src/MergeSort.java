import java.sql.Array;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {

        int[] RandomNumbers = new int[20000000];

        for(int i = 0; i < RandomNumbers.length; i++){
            Random num = new Random();

            RandomNumbers[i] = num.nextInt(101);
        }

        long Start1 = System.nanoTime();
        Merge(RandomNumbers);
        long End1 = System.nanoTime();

        System.out.println(End1-Start1);

//        for(int i = 0; i < RandomNumbers.length; i++){
//            System.out.println(RandomNumbers[i]);
//        }



    }

    private static void Merge(int[] array){
        int inputLength = array.length;

        //Check if there's more than 1 in the array or not
        if(inputLength < 2){
            return;
        }


        //Split it in half
        int midIndex = inputLength/2;

        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength-midIndex]; //This is just in case the array has an odd number of things in it


        //Fill up the arrays
        for(int i = 0; i < midIndex; i++){
            leftHalf[i] = array[i];
        }
        for(int i = midIndex; i < inputLength; i++){
            rightHalf[i - midIndex] = array[i]; //The reason for the 'i-midIndex' is, so it starts at 0 in the rightHalf and not 5
        }

        //Recursive
        Merge(leftHalf);
        Merge(rightHalf);

        PutTogether(array, leftHalf, rightHalf);
    }


    private static void PutTogether(int[] array, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int leftItt = 0, rightItt = 0, mergeItt = 0;

        //Place the numbers within the arrays into one big array (Hence the merging)
        while(leftItt < leftSize && rightItt < rightSize){
            //If the left half is less than the right, put add to the array
            if(leftHalf[leftItt] <= rightHalf[rightItt]){
                array[mergeItt] = leftHalf[leftItt];
                leftItt++;
            }else{
                array[mergeItt] = rightHalf[rightItt];
                rightItt++;
            }

            mergeItt++;
        }

        //Whatever may be left over on the left side
        while(leftItt < leftSize){
            array[mergeItt] = leftHalf[leftItt];
            leftItt++;
            mergeItt++;
        }


        //Whatever may be left over on the right side
        while(rightItt < rightSize){
            array[mergeItt] = rightHalf[rightItt];
            rightItt++;
            mergeItt++;
        }

    }
}
