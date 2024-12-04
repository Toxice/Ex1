package Assigment1;
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {

        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return
         */
        public static int number2Int(String num) {
            int ans = -1;
            // add your code here

            ////////////////////
            return ans;
        }

    /**
     * gets an input a String representing a number in base [2,16], returns a substring of the number's value in that same base
     * @param num input, String representing the number in base [2,16]
     * @return the number as a String
     */
    public static String getNumber(String num) { // "10101110b2"
         return num.substring(0, num.indexOf("b"));
        }

    /**
     * gets an input a String representing a number in base [2,16], returns a substring of the number's base
     * @param base input, the number's base
     * @return the base as a String
     */
    public static String getBase(String base) {
        return base.substring(base.indexOf("b") + 1, base.length());
        }


    /**
     * run over every char element of the given string
     * start from the last index of the string, multiply every element in the base to the power of the iterator (i in that case)
     * @param number the number represented in the String
     * @param base the base represented in the String
     * @return the total value of all iterations combined (or equivalently, the value of the number after converting to decimal)
     */
    public static int num2Decimal(String number, String base) {
        int decimalSum = 0;
        for (int i = 0; i < number.length() ; i++) {
            number.charAt(number.length() - 1 - i);
            decimalSum += char2Int(number.charAt(number.length() - 1 - i)) * Math.pow(valueOf(base), i);
        }
        return decimalSum;
    }

    public static String decimal2Base(int decimal, int base) {
        String newBase = "";
        int remainder = 0, sum = 0;
        while (decimal > 0) {
            remainder = decimal % base;
            newBase = newBase + remainder;
            decimal = decimal/base;
            }
        return newBase;
    }


    public static int valueOf(String number) {
        return Integer.parseInt(number);
    }

    /**
     *
     * @param letter
     * @return
     */
    public static int char2Int(char letter) {

        if(letter >= '0' && letter <= '9'){
            return letter -'0';
        } else if(letter >= 'A' && letter <= 'G') {
                int n = letter -'A' + 10;
            }
            return -1;
        }

        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            boolean ans = true;
            // add your code here

            ////////////////////
            return ans;
        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            String ans = "";
            // add your code here

            ////////////////////
            return ans;
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = true;
            // add your code here

            ////////////////////
            return ans;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int ans = 0;
            // add your code here

            ////////////////////
            return ans;
        }
}
