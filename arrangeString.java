/* Given a string containing uppercase alphabets and integer digits (from 0 to 9), 
the task is to print the alphabets in the lexicographical order (alphabetical order of dictionaries)
followed by the sum of digits. 

example;
J7N3F82E9V2N --> EFJNNV31 */

public class arrangeString {
    public static int[] ascendInt(int[] x) { // adding ascendInt method which I created in previous problems
        int least, temp;
        for (int i = 0; i < x.length; i++) {
            least = i;
            for (int j = i + 1; j < x.length; j++) {
                if (x[least] > x[j]) {
                    least = j;
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
        return x;
    }

    public static String arrangeStr(String s) {
        s = s.toUpperCase();
        int sum = 0; // int to store sum of extracted numerics
        String alpha = ""; // int to store alphabets
        for (int i = 0; i < s.length(); i++) {
            if (48 <= (int) s.charAt(i) && (int) s.charAt(i) <= 57) { // checking whether the ascii code of the current char is from 48-57 or not
                /*
                 * does not work since typecasting char to int gives ascii code not the integer
                 * char
                 * sum = sum + (int) (s.charAt(i));
                 */
                sum = sum + Integer.parseInt(String.valueOf(s.charAt(i))); //adding all the ints in a single int variable
            } 
            else if (65 <= (int) s.charAt(i) && (int) s.charAt(i) <= 90) {
                alpha = alpha + String.valueOf(s.charAt(i)); //adding all alphabets in a new string 'alpha'
            } else {
                return "only alphanumerics are allowed";
            }
        }
        int[] asciiValue = new int[alpha.length()]; //creating an array to store ascii code of each char of alpha
        for (int i = 0; i < alpha.length(); i++) {
            asciiValue[i] = (int) alpha.charAt(i); //storing ascii code
        }
        ascendInt(asciiValue); //arranging all ascii codes in ascending order
        String ascendedString = "";
        int num;
        //converting all the ascii codes of each char again into char and storing into string 'ascendedString'
        for (int i = 0; i < asciiValue.length; i++) {
            num = asciiValue[i];
            ascendedString += String.valueOf((char) num); 
        }
        ascendedString += String.valueOf(sum); //adding 'sum' at the end of string 'ascendedString'
        return ascendedString;
    }

    public static void main(String[] args) {
        String input = "td5bb7j3ch55t28h3";
        System.out.println(arrangeStr(input));
    }
}

/* 
    input: "td5bb7j3ch55t28h3;
    output;
    BBCDHHJTT38 👍
*/