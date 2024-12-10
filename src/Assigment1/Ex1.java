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
        if (isNumber(num)) {
            ans = num2Decimal(num);
        }
        if (num2Decimal(num) < 0) {
            ans = -1;
        }
        return ans;
    }

    /**
     * side method used to extract the number from the <number>b<base> template
     * gets an input a String representing a number in base [2,16], returns a substring of the number's value in that same base
     * @param num1 input, String representing the number in base [2,16]
     * @return the number as a String
     */
    public static String getNumber(String num1) {
        if (!num1.contains("b")) {
            return num1;
        }
        return num1.substring(0, num1.indexOf("b"));
    }

    /**
     * side method used to extract the base from the <number>b<base> template
     * gets an input a String representing a number in base [2,16], returns a substring of the number's base
     * @param base input, the number's base
     * @return the base as a String
     */
    public static String getBase(String base) {
        if (isBaseValid(base)) {
            String Base = base.substring(base.indexOf("b") + 1, base.length());
            return Base;
        } else {
            return "A";
        }
    }

    /**
     * run over every char element of the given string
     * start from the last index of the string, multiply every element in the base to the power of the iterator (i in that case)
     * @param number the number represented in the String
     * @return the total value of all iterations combined (or equivalently, the value of the number after converting to decimal)
     */
    public static int num2Decimal(String number) {
        if (!number.contains("b")) {
            number = number + "bA";
        }
        StringBuilder numberString = new StringBuilder(getNumber(number));
        numberString.reverse();
        int decimalSum = 0;
        int base = char2Int(getBase(number).charAt(0));
        for (int i = 0; i < numberString.length(); i++) {
            decimalSum += char2Int(numberString.charAt(i)) * Math.pow(base, i);
        }
        return decimalSum;
    }

    /**
     * gets a number and a base as inputs and outputs the number in the template <number>b<base>
     * @param number a string representing the number
     * @param base a string representing the base
     * @return a string in template <number>b<base>
     */
    public static String num2Template(String number, String base) {
        String delimiter = "b";
        return String.join(delimiter, number, base);
    }

    /**
     * Gets Input of a number in a decimal and return's the number in the given base
     * @param number the number
     * @param base the redix (the base)
     * @return the number converted to the given base
     */
    public static StringBuilder decimal2Base(int number, int base) {
        StringBuilder decimal = new StringBuilder();
        int remainder = 0;
        while (number != 0) {
            remainder = number % base;
            decimal.append(remainder);
            number = number / base;
        }
        return decimal.reverse();
    }

    /**
     * a Wrapper for the Integer.parseInt() function
     * @param number a String, representing a number
     * @return the value of the number inside the String
     */
    public static int valueOf(String number) {
        return Integer.parseInt(number);
    }


    /**
     * Takes a char representing a number and converts it to an int
     * @param letter a char representing a number
     * @return the number the char represented
     */
    public static int char2Int(char letter) {

        if (letter >= '0' && letter <= '9') {
            return Character.getNumericValue(letter);
        } else if (letter >= 'A' && letter <= 'Z') {
            return (letter - 'A') + 10;
        }
        return -1;
    }

    /**
     * checks if the given string is a valid number
     * @param a String representing a number
     * @return true if the given String is in a number format, false otherwise
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        if (!a.contains("b")) {
            a = a + "bA";
        }
        ans = isFormatValid(a);
        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";

        if (base == 10) {
            ans = num + "bA";
        }
          if (isNumber(String.valueOf(num))) {
            String number = decimal2Base(num, base).toString();
            ans = number + "b" + base;
        } else {
              ans = "";
          }
        return ans;
    }


    /**
     * Checks if the input is in a valid template <number>b<base>
     * the number can only hold values of (0~9) and (A~G)
     * @param number a string representing a number in template <number>b<base>
     * @return true for a valid template, false otherwise
     */
    public static boolean isFormatValid(String number) {
        if (!number.contains("b") || getNumber(number) == "" || number.contains(" ") || countOccurrences(number, 'b') || number.contains("-")) {
            return false;
        } else {
            int baseInteger = 0;
            String base = number.substring(number.indexOf("b") + 1, number.length());
            if ((base.length() != 1) || !base.matches("[2-9A-G]")) {
                return false;
            }
            if (base.matches("[A-G]") || base.matches("[2-9]")) {
                baseInteger = char2Int(base.charAt(0));
            }
            for (char DigitOrLetter : getNumber(number).toCharArray()) {
                if (Character.isLetterOrDigit(DigitOrLetter)) {
                    if (Character.isLetter(DigitOrLetter)) {
                        if (Character.isLowerCase(DigitOrLetter)) {
                            return false;
                        }
                        if (getNumericValue(DigitOrLetter) >= baseInteger) {
                            return false;
                        }
                    }
                    if (Character.isDigit(DigitOrLetter)) {
                        //if (((redix - '0') > baseInteger)) {
                        if (((DigitOrLetter - '0') >= baseInteger)) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        } return true;
    }

    /**
     * checks if the given base is a valid one (between 2~9 or between A~G)
     * @param number a String representing a base
     * @return true if the base is valid, false otherwise
     */
    public static boolean isBaseValid(String number) {
        String Base = number.substring(number.indexOf("b") + 1, number.length());
        if (Base.equals("10")) {
            return true;
        }
        if ((Base.length() == 1) && (Base.matches("[2-9A-G]"))) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        String num1 = String.valueOf(num2Decimal(n1));
        String num2 = String.valueOf(num2Decimal(n2));
        if (!num1.equals(num2)) {
            ans = false;
        }
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        fixArray(arr);
        int indexCounter = 0;
        String max = arr[0];
        for (int i = 0; i < arr.length; i++) {
                if (num2Decimal(arr[i]) > num2Decimal(max)) {
                    indexCounter  = indexCounter + 1;
                }
            }
            ans = indexCounter;
            return ans;
    }

    /**
     * removing all "b<base> from Strings
     * Side Method used in maxIndex
     * @param arr String Array
     */
    public static void fixArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getNumber(arr[i]);
            }
        }

    /**
     * computes the sum of num1 and num2
     * @param num1 String representing a number
     * @param num2 String representing a number
     * @param base String representing a base
     */
    public static String sumOf(String num1, String num2, String base) {
        if (isNumber(num1) && isNumber(num2)) {
            int Num1 = num2Decimal(num1);
            int Num2 = num2Decimal(num2);
            int decimalSum = Num1 + Num2;
            int baseValue = valueOf(base);
            String sumByBase = String.valueOf(decimal2Base(decimalSum, baseValue));
            return sumByBase;
        }
        return "";
    }

    /**
     * computes the product of num1 and num2
     * @param num1 String representing a number
     * @param num2 String representing a number
     * @param base String representing a base
     */
    public static String productOf(String num1, String num2, String base) {
           if (isNumber(num1) && isNumber(num2)) {
            int Num1 = num2Decimal(num1);
            int Num2 = num2Decimal(num2);
            int decimalSum = Num1 * Num2;
            int baseValue = valueOf(base);
            String sumByBase = String.valueOf(decimal2Base(decimalSum, baseValue));
            return sumByBase;
        }
        return "";
    }

    /**
     * gets the numeric value of a given character
     * @param letter a character
     * @return the numeric value of the given character
     */
    public static int getNumericValue(char letter) {
        return (letter - 'A') + 10;
    }

    /**
     * check if a given string has a certain character more than once
     * @param str a given string
     * @param targetChar the certain char
     * @return true if targetChar appears more than once, false otherwise
     */
    public static boolean countOccurrences(String str, char targetChar) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == targetChar) {
                count++;
            }
        }
        if (count > 1) {
            return true;
        }
        return false;
    }

}
