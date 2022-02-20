package com.lon;

public class code {
    public static void main (String[] args) {

        int a = 20,
                b = 30,
                c = 35,
                d = 35;
        boolean t = true,
                f = false;
        byte e = 50;
        short ee = 40;
        long g = 100L;
        double h = 0.008;
        float i = 0.006F;
        char ch = 'T', ln='G';
        String aString = "passed";

        System.out.println("a+b =" + (a + b));
        System.out.println("a-b =" + (a-b));
        System.out.println("c/d =" + (c/d));
        System.out.println("c%d =" + (c%d));
        System.out.println("a++ =" + (a++));
        System.out.println("b-- =" + (b--));
        System.out.println("--c =" + (--c));
        System.out.println("++d =" + (++d));
        System.out.println("short + long =" + (ee + g));
        System.out.println("double + float =" + (h + i));
        System.out.println("a==b =" + (a==b));
        System.out.println("a!=b =" + (a!=b));
        System.out.println("a<b =" + (a<b));
        System.out.println("a<=b =" + (a<=b));
        System.out.println("c>b =" + (c>b));
        System.out.println("c>=b =" + (c>=b));
        System.out.println("t || f=" + (t || f));
        System.out.println("t && f=" + (t && f));
        System.out.println("byte type overflow" + (e+1) + "" + (e-200) );
        System.out.println(ch+ln);
        System.out.println(aString);




    }
}