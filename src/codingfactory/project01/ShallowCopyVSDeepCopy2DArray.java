package codingfactory.project03;

import java.util.Arrays;

/**
 *  This program was designed for showing the deference between the shallow copy and the deep copy of a mutable Array (primitive data types).
 *  After the creation of the original 2D array, we write and implement methods in order to achieve our goal.
 * @author Panos V.
 * @version 1.0
 */
public class ShallowCopyVSDeepCopy2DArray {

    static int[][] originalArray = { {12, 14, 21, 47, 12},      // The initialization of our original 2D Array.
                                     {19, 42, 85, 13, 25},
                                     {21, 33, 46, 17, 57} };

    public static void main(String[] args) {
        int [][] shallowCopiedArray = shallowCopy(originalArray);   // We create and initialize this array by using a method that shallow copies the original array.
        int [][] deepCopiedArray = deepCopy(originalArray);         // We create and initialize this array by using a method that deep copies the original array.

        printArray("The original array values: ", originalArray);
        printArray("The starting values of shallow copied array: ", shallowCopiedArray);
        printArray("The starting values of deep copied array: ", deepCopiedArray);

        deepCopiedArray[1][4] = 99;

        displayFirstCase(shallowCopiedArray);
        displaySecondCase(deepCopiedArray);
    }

    /**
     *  This method creates a new array using the shallow copy method and more specific the "Arrays.copyOf()" method, which passes
     *  the references, and simultaneously access to the values, of our original array to the new one.
     * @param array The typical parameter for the 2d array.
     * @return  The new copied array.
     */
    private static int[][] shallowCopy(int[][] array) {
        return Arrays.copyOf(originalArray, originalArray.length);
    }

    /**
     *  This method creates a new array using two "for" statements in order to pass every single value of the original array to the new array.
     * @param array The typical parameter for the 2d array.
     * @return  The new copied array.
     */
    private static int[][] deepCopy(int[][] array) {
        int[][] deepCopiedArray = new int[originalArray.length][originalArray[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                deepCopiedArray[i][j] = array[i][j];
            }
        }

        return deepCopiedArray;
    }

    /**
     *  This method is responsible for displaying the array to the console.
     * @param message A String to describe each of the arrays that are displayed in the console.
     * @param array The typical parameter for the 2d array.
     */
    private static void printArray(String message, int[][] array) {
        System.out.println(message);
        for (int[] elements : array) {
            for (int element : elements) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     *  This method contains the proofs of what the shallow copy can do to the original array.
     * @param shallowCopiedArray A typical parameter for passing the 2D array we want when the method is being invoked.
     */
    private static void displayFirstCase(int[][] shallowCopiedArray) {
        System.out.println();
        System.out.println("The value of the element at position[1][2] in the original array is: " + originalArray[1][2]);

        shallowCopiedArray[1][2] = 200;

        System.out.println("The value of the element at position[1][2] in the shallow copied array has changed to: " + shallowCopiedArray[1][2]);
        System.out.println("The value of the element at position[1][2] in the original array, after the change was made in the shallow copied array, is now: " + originalArray[1][2] +
                           "\n This means that there is a major security risk for our data when we provide someone with a shallow copy of our references when our\ndata is mutable, like " +
                           "in primitives data types.");
    }

    /**
     *  This method proves that the deep copy of a mutable (primitive data type) array is the only safe option to maintain the integrity of the
     *  original array and keep our data safe from any unwanted changes.
     * @param deepCopiedArray A typical parameter for passing the 2D array we want when the method is being invoked.
     */
    private static void displaySecondCase(int[][] deepCopiedArray) {
        System.out.println();
        System.out.println("The value of the element at position[1][4] in the original array is: " + originalArray[1][4]);
        System.out.println("The value of the element at position[1][4] in the shallow copied array has changed to: " + deepCopiedArray[1][4]);
        System.out.println("The value of the element at position[1][2] in the original array, after the change was made in the deep copied array, is now: " + originalArray[1][4] +
                           "\n As you can see nothing has changed in the original array because when we create a new array with deep copy we create a new array totally\nindependent from the original. " +
                           "That means we don't just pass the references of the original array, we create a complete new array which\nhappens to have, at the time of creation, the same values with the original array.");
    }
}
