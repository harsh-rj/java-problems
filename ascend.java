// Java Program to Print an Integer Array in Ascending Order
public class ascend {

    public static void main(String[] args) {
        int[] x = { 56, 23, 1, 0, -65, 465, 6, 9 };
        int least, temp;
        for (int i = 0; i < x.length; i++) { // for loop for each element of the array
            least = i;
            for (int j = i + 1; j < x.length; j++) {
                if (x[least] > x[j]) { // comparing each element of the array with elements after it
                    least = j; // if next element is smaller then replcing it with the previous least
                }
            }
            /*
             * replacing the least with the element where we started
             * so the smaller elements are placed at first
             */
            temp = x[i];
            x[i] = x[least];
            x[least] = temp;
        }
        for (int i : x) { // printing modified array using for-each loop
            System.out.print(i + " ");
        }
    }
}

/*
    Output;
    -65 0 1 6 9 23 56 465
 */
