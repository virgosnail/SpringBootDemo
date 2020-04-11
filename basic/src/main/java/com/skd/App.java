package com.skd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Hello world!
 *
 */
@Component
public class App 
{
    @Autowired
    List<TestInterface> list;

    public void say(){
        System.out.println(list.size());
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println(123);

    }
}
