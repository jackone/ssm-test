package cn.test;

import org.junit.Test;

public class Test01 {
    static int a=3;
    public static void changeStr(int str){
         str=2;
         a=4;
        System.out.println("a"+a);
    }
    public static void main(String[] args){
        int str=1234;
        changeStr(str);
        System.out.println(str);
    }
    @Test
    public void test001(){

    }
}
