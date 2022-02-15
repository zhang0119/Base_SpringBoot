package com.example;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("junit5功能测试类")
public class Junit5Test {

    @Test
    @DisplayName("异常断言")
    void testException(){

        assertThrows(ArithmeticException.class,()->{int i = 10/2;},"业务逻辑出现问题!");
    }

    @Test
    @DisplayName("组合断言")
    void testAll(){
        Assertions.assertAll("test",
                            ()->assertTrue(true && true),
                ()->assertEquals(1,2));
    }

    @DisplayName("测试断言")
    @Test
    void result(){
        int count = cal(1, 3);
        //Assertions.assertEquals(4,count,"断言逻辑出现问题！");
        Object o1 = new Object();
        Object o2 = new Object();
        assertSame(o1,o2,"不是同一个对象!");
    }

    int cal(int i,int j){
        return i+j;
    }

    @DisplayName("测试displayName注解")
    @Test
    void testDisplayName(){

        System.out.println("111");
    }

    @Disabled  //表示这个方法不执行,禁用方法
    @Test
    void test2(){

        System.out.println("222");
    }

    // 加上这个注解后，它会每次在目标方法执行之前执行
    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试就要开始了...");
    }

    //每个方法测试完后在运行这个方法
    @AfterEach
    void testAfterEach(){
        System.out.println("测试已结束!");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试快要开始了...");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有的测试都结束了...");
    }
}
