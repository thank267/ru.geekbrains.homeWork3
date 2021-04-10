import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Задание 1");
        generateAndChangeArray();
        System.out.println("=================================\n");

        System.out.println("Задание 2");
        arrayOfHundred();
        System.out.println("=================================\n");

        System.out.println("Задание 3");
        changeArray();
        System.out.println("=================================\n");

        System.out.println("Задание 4");
        squareArray();
        System.out.println("=================================\n");

        System.out.println("Задание 5");
        System.out.println("result array is  : " + Arrays.toString(initArray(10, 23)));
        System.out.println("=================================\n");

        System.out.println("Задание 6");
        minMaxInArray();
        System.out.println("=================================\n");

        System.out.println("Задание 7");
        System.out.println(checkBalance(new int[] {}));
        System.out.println(checkBalance(new int[] { 1 }));
        System.out.println(checkBalance(new int[] { 1, 1 }));
        System.out.println(checkBalance(new int[] { 1, 2, 2, 10, 15 }));
        System.out.println(checkBalance(new int[] { 1, 1, 3, 3, 8 }));
        System.out.println("=================================\n");

        System.out.println("Задание 8");
        System.out.println(Arrays.toString(shiftArray(new int[] {}, 1)));
        System.out.println(Arrays.toString(shiftArray(new int[] { 1 }, 2)));
        System.out.println(Arrays.toString(shiftArray(new int[] { 1, 1 }, 2)));
        System.out.println(Arrays.toString(shiftArray(new int[] { 2, 2, 2, 1, 2, 2, 10, 1 }, 34)));
        System.out.println(Arrays.toString(shiftArray(new int[] { 1, 1, 3, 3, 8 }, 256)));
        System.out.println(Arrays.toString(shiftArray(new int[] { 1, 1 }, -1)));
        System.out.println(Arrays.toString(shiftArray(new int[] { 2, 2, 2, 1, 2, 2, 10, 1 }, -34)));
        System.out.println(Arrays.toString(shiftArray(new int[] { 1, 1, 3, 3, 8 }, -256)));
        System.out.println("=================================\n");
    }

    /*
    * Задание 1
    */
    public static void generateAndChangeArray() {

        int[] initialArray = new Random().ints(10, 0, 2).toArray();

        System.out.println("initial array is : " + Arrays.toString(initialArray));

        for (int i = 0; i < initialArray.length; i++) {
            initialArray[i] = ~initialArray[i] & 1;
        }

        System.out.println("result array is  : " + Arrays.toString(initialArray));

    }

    /*
    * Задание 2
    */
    public static void arrayOfHundred() {

        int[] hundred = new int[100];

        for (int i = 1; i <= hundred.length; i++) {
            hundred[i - 1] = i;
        }

        System.out.println("result array is  : " + Arrays.toString(hundred));

    }

    /*
    * Задание 3
    */
    public static void changeArray() {

        int[] anArray = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        System.out.println("initial array is : " + Arrays.toString(anArray));

        for (int i = 0; i < anArray.length; i++) {
            int tmpValue = anArray[i];
            anArray[i] = tmpValue < 6 ? tmpValue * 2 : tmpValue;
        }

        System.out.println("result array is  : " + Arrays.toString(anArray));

    }

    /*
    * Задание 4
    */
    public static void squareArray() {

        int[][] sqArray = new int[11][11];

        for (int i = 0; i < sqArray.length; i++) {

            sqArray[i][i] = 1;
            sqArray[i][sqArray.length - 1 - i] = 1;
        }

        System.out.println("result array is  : " + Arrays.deepToString(sqArray));

    }

    /*
    * Задание 5 
    */
    public static int[] initArray(int len, int initialValue) {

        return IntStream.range(0, len).map(el -> initialValue).toArray();

    }

    /*
    * Задание 6
    */
    public static void minMaxInArray() {

        int[] initialArray = new Random().ints(10, 0, 20).toArray();

        System.out.println("initial array is : " + Arrays.toString(initialArray));

        int max = Arrays.stream(initialArray).max().orElseThrow();

        int min = Arrays.stream(initialArray).min().orElseThrow();

        System.out.println("max is  : " + max);

        System.out.println("min is  : " + min);

    }

    /*
    * Задание 7
    */
    public static boolean checkBalance(int[] anArray) {

        if (anArray.length <= 1) {
            return false;
        }

        boolean checker = false;

        for (int i = 1; i < anArray.length; i++) {

            int leftSum = 0;

            int rightSum = 0;

            for (int l = 0; l < i; l++) {
                leftSum += anArray[l];
            }

            for (int r = i; r < anArray.length; r++) {
                rightSum += anArray[r];
            }

            if (leftSum == rightSum) {

                checker = true;

            }

        }

        return checker;

    }

    /*
    * Задание 8
    */
    public static int[] shiftArray(int[] anArray, int toShift) {

        // нечего сдвигать
        if (anArray.length <= 1) {
            return anArray;
        }

        // ограничиваем число сдвигов длиной массива
        toShift = toShift % anArray.length;

        // сдвигаем вправо
        if (toShift > 0) {
            int last = anArray[anArray.length - 1];

            for (int i = anArray.length - 1; i > 0; i--) {

                anArray[i] = anArray[i - 1];

            }

            anArray[0] = last;

            toShift--;

            shiftArray(anArray, toShift);

        }

        // сдвигаем влево
        if (toShift < 0) {

            int first = anArray[0];

            for (int i = 1; i < anArray.length; i++) {

                anArray[i - 1] = anArray[i];

            }

            anArray[anArray.length - 1] = first;

            toShift++;

            shiftArray(anArray, toShift);

        }

        return anArray;

    }
}
