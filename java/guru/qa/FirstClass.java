package guru.qa;

public class FirstClass {

    byte aByte =10; //8 bit -128...127
    short aShort=100; //16 -32768...32767

    //самый используемый
    int aInt=1000; //32
    long aLong=100L; //64

    float aFloat=0.0F; // 32
    //самый используемый (если просто хранить)
    double aDouble=0.0D; // 64

    char aChar='c';
    boolean aBoolean= false;

    public static void main (String[] args) {

        //System.out.println(5+10);

        //System.out.println(2!=3);

        int a=10;
        int b=10;
        a=a+b;
        a+=b;

        //System.out.println(5%2);

        boolean result =(3>2) || false;

        Book Sun = new Book();

        Sun.doReadBook();

    }


}
