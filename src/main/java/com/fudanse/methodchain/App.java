package com.fudanse.methodchain;

import com.fudanse.methodchain.model.Method;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Method method = new Method.Builder().field("String").build();
        System.out.println(method.getField());
    }
}
