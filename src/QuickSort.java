import java.util.Random;

public class QuickSort {


    public static void main(String[] args) {

        //First, let's get some random numbers to work with
        Random rand = new Random();
        int [] TestArray = new int [20000000];
        for(int i = 0; i < TestArray.length; i++){
            TestArray[i] = rand.nextInt(100);
        }

        long Start1 = System.nanoTime();
        quickSort(TestArray);
        long End1 = System.nanoTime();

        System.out.println(End1-Start1);


    }

    //Overloaded
    private static void quickSort(int [] array){
        quickSort(array, 0, array.length - 1);
    }
    private static void quickSort(int[] array, int LowIndex, int HighIndex){


        //If the low index has already gone past the high index and visa versa, the sorting is done so we simply return it
        if(LowIndex >= HighIndex){
            return;
        }


        //It's slightly faster to choose a random pivot all the time
        int PivotIndex = new Random().nextInt(HighIndex-LowIndex) + LowIndex;
        int Pivot = array[PivotIndex];

        //This will swap the random pivot chosen with the high index to make the sorting easier
        Swap(array, PivotIndex, HighIndex);



        int LeftPointer = LowIndex;
        int RightPointer = HighIndex;


        while(LeftPointer < RightPointer){

            //While the left pointer is less than the pivot value, keep moving to the right
            while(array[LeftPointer] <= Pivot && LeftPointer < RightPointer){
                LeftPointer++;
            }

            //While the right pointer is more than the pivot value, keep moving to the left
            while(array[RightPointer] >= Pivot && LeftPointer < RightPointer){
                RightPointer--;
            }

            //Once they have both met their criteria, swap them both
            Swap(array, LeftPointer, RightPointer);

        }



        Swap(array, LeftPointer, HighIndex);


        //This is a recursive sort for the right and left side
        quickSort(array, LowIndex, LeftPointer-1);
        quickSort(array, LeftPointer+1, HighIndex);

    }


    private static void Swap(int[] array, int Index1, int Index2){
        int temp = array[Index1];
        array[Index1] = array[Index2];
        array[Index2] = temp;

    }
    private static void PrintArray(int[] array){
        for (int j : array) {
            System.out.println(j);
        }
    }










}
