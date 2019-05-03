package com.epolsoft;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.out;

public class Reflection6 {

    private static void invokeMethod( Object instance, Method method ) {
        Object result;

        try {
            result = method.invoke( instance );
            out.println( "\n    INVOKE RESULT: " + result );
        } catch ( IllegalAccessException | InvocationTargetException e ) {
            e.printStackTrace();
        }

    }

    private static void doWithMethod( String class_name, String method_name ) {
        Object instance;
        Method method;

        instance = ReflectionCommon.createInstance( class_name );

        if ( instance == null ) {
            out.print( "\nERROR!" );
            return;
        }

        method = ReflectionCommon.getMethod( instance, method_name );

        if ( method == null ) {
            out.print( "\nERROR!" );
            return;
        }

        out.print( ReflectionCommon.getClassName( instance ) );
        out.print( "\n  METHOD:" );
        out.println( ReflectionCommon.getMethodInfo( method ) );

        invokeMethod( instance, method );
    }

    /*
        Вызвать метод объекта по имени.
        Имя метода неизвестно до момента выполнения программы.
        CLI PARAMS: "java.lang.String" "isEmpty"
    */
    public static void main( String[] args ) {
        String class_name, method_name;

        out.println( "\nREFLECTION - 6" );

        if ( args.length < 2 ) {
            out.println("\nPlease set program arguments: <ClassName> <ClassMethod>");
            out.println("Example:");
            out.println("java.lang.String isEmpty");
            return;
        }

        class_name = args[0];
        method_name = args[1];

        doWithMethod( class_name, method_name );
    }
}