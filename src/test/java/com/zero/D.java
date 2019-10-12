package com.zero;

/**
 * Created by asd on 2019/10/11.
 */
public class D {

    public static void main(String[] args) {
        System.out.println(new D().b);
    }

    private int a = getCode();
    private int b = 10;
    private int getCode(){
        return b;
    }
    public static String test(int code) {
        String str = "";
        if (code % 2 != 1) {
            code = code /2;
            str = "90=" + 2;
        }
        if (code % 3 != 1) {
            code = code /3;
            str = str +"*"+ 3;
        }
        if (code % 5 != 1) {
            code = code /5;
            str = str +"*"+ 5;
        }
        if (code != 1) {
            System.out.println(str);
            test(code);
            System.out.println(str);
        }
        return str;
    }
}
