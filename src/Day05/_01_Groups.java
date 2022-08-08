package Day05;

import org.testng.annotations.Test;

public class _01_Groups {

    @Test(groups = "SmokeTest")
    void test1(){
        System.out.println("Test 1 SmokeTest");
    }
    @Test(groups = "Regression")
    void test3(){
        System.out.println("Test 3 Regression");
    }
    @Test(groups = "Regression")
    void test5(){
        System.out.println("Test 5 Regression");
    }
    @Test(groups = "Regression")
    void test2(){
        System.out.println("Test 2 Regression");
    }
    @Test(groups = "SmokeTest")
    void test4(){
        System.out.println("Test 4 SmokeTest");
    }
    @Test(groups = "SmokeTest")
    void test6(){
        System.out.println("Test 6 SmokeTest");
    }

    void test7(){
        System.out.println("Test 7");
    }





}
