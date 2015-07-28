package com.appexperts.core.lang.string;

public class StringClassExample {

    public static void main(String[]args){
        //Initialization with literal
        String str1 = "Hello World";
        System.out.println("str1:"+str1);

        //Initialization with char array
        char arr[] = {'H','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println("str2:"+str2);

        //Concatenation using + operator
        String str3 = "World";
        str3 = str2 + " " + str3;
        System.out.println("str3:"+str3);

        //find out the length of a string
        System.out.println(str3.length());

        //You can even apply that to literals, as with all String API methods
        //As we said. literals are implemented as String instances
        System.out.println("Length: "+"abcdefg".length());

        //Substring from position 2 to position 10
        String c = str1.substring(2,10);
        System.out.println("Substring :"+c);

        //Substring from position 1 to position 4
        System.out.println("Literal Substring :"+"abcdefghigklm".substring(1,4));

        // Get the charcter array of the string.
        char[] chars = c.toCharArray();
        System.out.println("Char array : ["+chars[0]+","+chars[1]+","+chars[2]+"]");

        //find the first index of a char inside a string
        int i = str1.indexOf('W');
        System.out.println("Index of 'W':"+i);

        //find the first index of a string inside another string after a certain position
        i = str1.indexOf("orld",5);
        System.out.println("Index of 'orld':"+i);

        //find the last index of a string inside another string
        i = str1.lastIndexOf("l");
        System.out.println("lAST Index of 'L':"+i);

        //find the last index of a string inside another string after a certain position
        // scanning the string backwards
        i = str1.lastIndexOf("l",7);
        System.out.println("lAST Index of 'L':"+i);

        //find a character in a certain position
        char cr = str1.charAt(5);
        System.out.println("Character at position 5:"+cr);

        //Lower case
        System.out.println("ABCEFAFA".toLowerCase());

        //Upper case
        System.out.println("abcasipasc".toUpperCase());

        //replace occurrences of a character
        str1 = str1.replace('o','0');
        System.out.println(str1);

        //Trim white spaces from the end and the beginning
        String str4 = "    Java";
        System.out.println(str4);
        System.out.println(str4.trim());

        //Split !!!
        String str5= "Java is great";
        String[] strArray = str5.split(" ");

        System.out.println(strArray[0]+","+strArray[1]+","+strArray[2]);

        str5= "Java-is-great";
        strArray = str5.split("-");
        System.out.println(strArray[0]+","+strArray[1]+","+strArray[2]);

        str5= "Java is great";
        strArray = str5.split("/*");
        System.out.println(strArray[0]+","+strArray[1]+","+strArray[2]+","+strArray[3]+","+strArray[4]+
                ","+strArray[5]+","+strArray[6]+","+strArray[7]+","+strArray[8]);

        //contains and equals
        System.out.println("Contains :" + "qwerty".contains("ert")); 
        System.out.println ("Equals :"+str5.equals("java is great"));
        System.out.println ("Equals ignore case:"+str5.equalsIgnoreCase("java is great"));

        // Compare lexicographically two strings
        System.out.println("Compare:" + str5.compareTo("abc"));

        String s1 = "abc"; 
        String s3 = new String("abc");


        System.out.println(s1==s3);
        System.out.println(s1.equalsIgnoreCase(s3));

        s3 = s3.intern();

        System.out.println(s1==s3);



    }

}
