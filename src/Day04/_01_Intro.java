package Day04;

import org.testng.annotations.*;

public class _01_Intro {

    /*
     @BeforeSuit
       @BeforeTest
         @BeforeGroup
           @BeforeClass
             @BeforeMethod
               @Test
               @Test
             @AfterMethod
           @AfterClass
        @AfterGroup
     @AfterTest
   @AfterSuit
    */

    @BeforeSuite
    void bsuit(){
        System.out.println("Before Suit");
    }
    @BeforeTest
    void btest(){
        System.out.println("Before Test");
    }
    @BeforeGroups
    void bgroups(){
        System.out.println("Before Group");
    }
    @BeforeClass
    void bclass(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    void bmetod(){
        System.out.println("Before Method");
    }
    @Test
    void TestIntro1_1(){
        System.out.println("Test Intro 1");
    }
    @Test
    void TestIntro1_2(){
        System.out.println("Test Intro 2");
    }
    @AfterMethod
    void amethod(){
        System.out.println("After method");
    }
    @AfterClass
    void aclass(){
        System.out.println("After Class");
    }
    @AfterGroups
    void agroups(){
        System.out.println("After Group");
    }
    @AfterTest
    void atest(){
        System.out.println("After Test");
    }
    @AfterSuite
    void asuite(){
        System.out.println("After Suite");
    }

}
