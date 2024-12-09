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
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;

        if (isDecimal(num)) {
            ans = Integer.parseInt(num);
        }

        if (!isNumber(num)) {
            ans = num2Decimal(num);
        }
        return ans;
    }

    /**
     * gets an input a String representing a number in base [2,16], returns a substring of the number's value in that same base
     *
     * @param num1 input, String representing the number in base [2,16]
     * @return the number as a String
     */
    public static String getNumber(String num1) { // "10101110b2"
        if (!num1.contains("b")) {
            return num1;
        }
        return num1.substring(0, num1.indexOf("b"));
    }

    /**
     * gets an input a String representing a number in base [2,16], returns a substring of the number's base
     *
     * @param base input, the number's base
     * @return the base as a String
     */
    public static String getBase(String base) {
        if (validBase(base)) {
            String Base = base.substring(base.indexOf("b") + 1, base.length());
            return Base;
        } else {
            return "A";
        }
    }


    /**
     * run over every char element of the given string
     * start from the last index of the string, multiply every element in the base to the power of the iterator (i in that case)
     *
     * @param number the number represented in the String
     * @return the total value of all iterations combined (or equivalently, the value of the number after converting to decimal)
     */
    public static int num2Decimal(String number) {
        StringBuilder numberString = new StringBuilder(getNumber(number));
        numberString.reverse();
        int decimalSum = 0;
        int base = valueOf(getBase(number));
        for (int i = 0; i < numberString.length(); i++) {
            decimalSum += char2Int(numberString.charAt(i)) * Math.pow(base, i);
        }
        return decimalSum;
    }

    public static String num2Template(String number, String base) {
        String delimiter = "b";
        return String.join(delimiter, number, base);
    }

    /**
     * Gets Input of a number in a given base and return's the number in decimal notation
     *
     * @param number the number
     * @param base   the redix (the base)
     * @return
     */
    public static StringBuilder decimal2Base(int number, int base) {
        StringBuilder decimal = new StringBuilder();
        if (base == 10) {
            StringBuilder base10 = new StringBuilder();
            base10.append(number);
            return base10;
        }
        int remainder = 0, sum = 0;
        while (number != 0) {
            remainder = number % base;
            decimal.append(remainder);
            number = number / base;
        }
        return decimal.reverse();
    }

    /**
     * a Wrapper for the Integer.parseInt() function
     *
     * @param number a String, representing a number
     * @return the value of the number inside the String
     */
    public static int valueOf(String number) {
        return Integer.parseInt(number);
    }

    /**
     * Takes a char representing a number and converts it to an int
     *
     * @param letter a char representing a number
     * @return the number the char represented
     */
    public static int char2Int(char letter) {

        if (letter >= '0' && letter <= '9') {
            //return letter -'0';
            return Character.getNumericValue(letter);
        } else if (letter >= 'A' && letter <= 'Z') {
            return (letter - 'A') + 10;
        }
        return -1;
    }

    public static int String2Int(String ltr) {
        char letter = ltr.charAt(0);
        if (letter >= '0' && letter <= '9') {
            return letter - '0';
        } else if (letter >= 'A' && letter <= 'G') {
            return letter - 'A' + 10;
        }
        return -1;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        ans = isFormatValid(a);
        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";

        if (base == 10) {
            ans = num + "bA";
        }
        if (isValid(Integer.toString(num))) {
            String number = decimal2Base(num, base).toString();
            ans = number + "b" + base;
        }
        return ans;
    }

    /**
     * Checks if the given number is fit to the base
     *
     * @return true if the number template is valid, false if the number template is not valid
     */
    public static boolean isValid(String number) {
        int baseInteger = 0;

        if (number.contains("b")) {
            if (validBase(number)) {
                String base = number.substring(number.indexOf("b") + 1, number.length());
                if (base.matches("[A-G]")) {
                    baseInteger = char2Int(base.charAt(0));
                }
                if (base.matches("[2-9]")) {
                    baseInteger = char2Int(base.charAt(0));
                }
                for (char redix : getNumber(number).toCharArray()) {
                    if (Character.isLetter(redix)) {
                        if ((char2Int(redix) > baseInteger) || (char2Int(redix) == baseInteger)) {
                            return false;
                        }
                    }
                    if (Character.isDigit(redix)) {
                        if (((redix - '0') > baseInteger)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean validBase(String number) {
        //if (number.contains("b"))
        String Base = number.substring(number.indexOf("b") + 1, number.length());
        if ((Base.length() == 1) && (Base.matches("[2-9A-G]"))) {
            return true;
        }
        return false;
    }

    public static boolean isBase(String base) {
        int Base = valueOf(base);
        if (Base >= 2 && Base <= 16) {
            return true;
        }
        return false;
    }

    public static boolean isFormatValid(String number) {
        if (!number.contains("b")) { // if the given number in base 10
            return isDecimal(number);
        } else {
            int baseInteger = 0;
            String base = number.substring(number.indexOf("b") + 1, number.length());
            if ((base.length() != 1) && (!base.matches("[2-9A-G]"))) {
                return false;
            }
            if (base.matches("[A-G]")) {
                baseInteger = char2Int(base.charAt(0));
            }
            if (base.matches("[2-9]")) {
                baseInteger = char2Int(base.charAt(0));
            }
            for (char redix : getNumber(number).toCharArray()) {
                if (Character.isLetter(redix)) {
                    if ((char2Int(redix) > baseInteger) || (char2Int(redix) == baseInteger)) {
                        return false;
                    }
                }
                if (Character.isDigit(redix)) {
                    if (((redix - '0') > baseInteger)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isDecimal(String number) {
        for (char digit : number.toCharArray()) {
            if (char2Int(digit) > 10 || Character.isLetter(digit)) {
                return false;
            }
        }
        return true;
    }

    public static void ErrorPrint(String number) {
        System.out.println("ERR num1 is in the wrong format! (" + number + ")");
    }


    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here
        if (valueOf(n1) != valueOf(n2)) {
            ans = false;
        }
        return ans;
    }

    public static String[] stringArray(String n1, String n2, String Product, String Sum) {
        return new String[]{n1, n1, Product, Sum};
    }


    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        // add your code here
        int indexCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (valueOf(arr[i]) > valueOf(arr[0])) {
                indexCounter = indexCounter + 1;
            }
        }
        ans = indexCounter;
        return ans;
    }

    public static void maxIndexPrint(String[] arr, int maxIndex) {
        StringBuilder str = new StringBuilder("max index over ");
        for (String index : arr) {
            str.append("[" + index + ",");
        }
        str.append("] is " + arr[maxIndex]);
        System.out.println(str);
    }

    /**
     *
     * @param num1
     * @param num2
     * @param base
     */
    public static String sumOf(String num1, String num2, String base) {
        if (isFormatValid(num1) && isFormatValid(num2)) {
            String onlyNum1 = getNumber(num1);
            String onlyNum2 = getNumber(num2);
            int Num1 = number2Int(onlyNum1);
            int Num2 = number2Int(onlyNum2);
            int decimalSum = Num1 + Num2;
            int baseValue = valueOf(base);
            String sumByBase = String.valueOf(decimal2Base(decimalSum, baseValue));
            return sumByBase;
            //System.out.println(num1 + " + " + num2 + " = " + num2Template(sumByBase, base));
        }
        return "";
    }

    /**
     *
     * @param num1
     * @param num2
     * @param base
     */
    public static String productOf(String num1, String num2, String base) {
        if (isFormatValid(num1) && isFormatValid(num2)) {
            String onlyNum1 = getNumber(num1);
            String onlyNum2 = getNumber(num2);
            int Num1 = number2Int(onlyNum1);
            int Num2 = number2Int(onlyNum2);
            int decimalSum = Num1 * Num2;
            int baseValue = valueOf(base);
            String sumByBase = String.valueOf(decimal2Base(decimalSum, baseValue));
            return sumByBase;
            //System.out.println(num1 + " + " + num2 + " = " + num2Template(sumByBase, base));
        }
        return "";
    }
}
