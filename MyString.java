public class MyString {
    public static void main(String[] args) {
        /*System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
        */System.out.println(contains("We need to leverage our core competencies", "synergy"));
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        str = str.toLowerCase();
        return str;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        if (length2 == 0){
            return true;
        }
        if (length1 >= length2) {
            for (int i = 0; i < length1 - length2 +1; i++) {
                for (int j = 0; j < length2; j++) {
                    /*if ( length1 - i < length2 - j) { // checking if length1 is long enough to contain length2
                        System.out.println(1);
                        return false;
                    }*/
                    if (str1.charAt(i + j) == str2.charAt(j)) {
                        //System.out.println(str1.charAt(i + j) + " this is equall to this " + str2.charAt(j)); // for debuging
                       if ( j == length2 - 1) {
                        //System.out.println(1); // for debuging
                        return true;
                        }
                    }  else {
                            break;
                       }
                    }
                }
            }
        //System.out.println(2);  // for debuging
        return false;
    }
}
