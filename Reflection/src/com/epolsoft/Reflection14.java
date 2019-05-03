package com.epolsoft;

import java.lang.reflect.Method;

import static java.lang.System.out;

class ReflectionTest14 {
    public static void main( String[] args ) {
        System.out.println( "Hello" );
    }
}

public class Reflection14 {


    private static void doChangeMess( String new_mess) {
        final String METHOD_NAME = "println";
        final String CLASS_NAME = "java.io.PrintStream";
        Class class_instance;
        Object instance;
        Method method;

        class_instance = ReflectionCommon.getReflectionClass( CLASS_NAME );

        if ( class_instance == null ) {
            out.print( "\nERROR! Class not found" );
            return;
        }

        out.print( ReflectionCommon.getClassName( class_instance ) );

        method = ReflectionCommon.getMethod( class_instance, METHOD_NAME, String.class );

        if ( method == null ) {
            out.print( "\nERROR! Method not found " + METHOD_NAME );
            return;
        }

        out.print( "\n  METHOD:" );
        out.println( ReflectionCommon.getMethodInfo( method ) );
//
//        out.println( "\n  INVOKE CONSTRUCTOR PARAM: " + param_value );
//        out.println( "\nNEW INSTANCE:" );
//        instance = invokeConstructor( constructor, param_value );
//
//        if ( instance != null ) {
//            out.print( ReflectionCommon.getClassName( instance ) );
//            out.print( "\n  FIELD:" );
//
//            field = getField( class_instance, "number" );
//
//            if ( field == null ) {
//                out.print( "\nERROR!" );
//                return;
//            }
//
//            out.println( ReflectionCommon.getFieldInfo( field ) );
//
//            showFieldValue( instance, field, "    VALUE: " );
//        }
    }

    /*
        Дан код: System.out.println("hello");
        Сделайте так, чтобы он напечатал “bue”. Запрещено трогать эту строку.
        Запрещено использовать System.out.println (кроме данной строки кода)

    */
    public static void main( String[] args ) {

        out.println( "\nREFLECTION - 14" );

        doChangeMess( "bue" );
    }
}