/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
       /* String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1,2));      
        System.out.println(indexOf(arr1,'l'));  
        System.out.println(indexOf(arr1,'l',3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
        */
        int num_tests = 3;
        System.out.println("Testing 'hashCode':");

        char[] arr1 = {'a'};
        char[] arr2 = "lemon".toCharArray();
        char[] arr3 = {};

        boolean test1 = ArrCharOps.hashCode(arr1) == (long) 97;
        boolean test2 = ArrCharOps.hashCode(arr2) == (long) 300179;
        boolean test3 = ArrCharOps.hashCode(arr3) == (long) 0;

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
        System.out.println(ArrCharOps.hashCode(arr1));
        System.out.println(ArrCharOps.hashCode(arr2));
        System.out.println(ArrCharOps.hashCode(arr3));


    
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
        return arr[index];
    }

    /** If the two arrays have the same value in every index, 
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]!= arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        for (int i = fromIndex; i < arr.length; i++){
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        int lastIndex = -1;
        for (int i = 0; i < arr.length; i++){
            if (charAt(arr, i) == ch) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    /* Returns an array which is the concatanation of the two given arrays.
    */
    public static char[] concat(char[] arr1, char[] arr2) {
        int fullLength = arr1.length + arr2.length;
        char[] fullArr = new char[fullLength];
        for (int i1 = 0; i1 < arr1.length; i1++) {
            fullArr[i1] = arr1[i1];
        }

        for (int i2 = arr1.length; i2 < fullLength; i2++){
            fullArr[i2] = arr2[i2 - arr1.length];
        }

        return fullArr;
    }

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        int length = endIndex - beginIndex;
        char[] subArr = new char[length];
        for (int i = 0; i < length; i++) {
            subArr[i] = arr[beginIndex + i];
        }
        return subArr;
    }

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {
        double hash = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            j = arr[i];

            hash = hash + j*(Math.pow(7, arr.length - i - 1));
        }

        return (long)hash;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        if (length1 <= 0 || length2 <= 0) {
            return -2;
        }
        char ch1;
        char ch2;
        if (length1 < length2) {
            for (int i = 0; i < length1; i++) {
                ch1 = str1.charAt(i);
                ch2 = str2.charAt(i);
                if (ch1 < ch2) {
                    return -1;
                } else if (ch1 > ch2) {
                    return 1;
                }
            }
            return -1;
        } else if (length2 < length1) {
            for (int i = 0; i < length2; i++) {
                ch1 = str2.charAt(i);
                ch2 = str1.charAt(i);
                if (ch1 < ch2) {
                    return 1;
                } else if (ch1 > ch2) {
                    return -1;
                }
            }
            return 1;
        }
        for (int i = 0; i < length1; i++) {
            ch1 = str1.charAt(i);
            ch2 = str2.charAt(i);
            if (ch1 < ch2) {
                return -1;
            } else if (ch1 > ch2) {
                return 1;
            }
        }
        return 0;
    }
}
