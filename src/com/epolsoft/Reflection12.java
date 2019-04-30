package com.epolsoft;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static java.lang.System.out;

public class Reflection12 {

    private static void invokeMethod( Object instance, Method method, Integer p_value ) {
        Object result;

        try {
            result = method.invoke( instance, p_value );
            out.println( "\n    INVOKE RESULT: " + result );
        } catch ( IllegalAccessException | InvocationTargetException e ) {
            e.printStackTrace();
        }

    }

    private static Parameter getParameter( Method m, int i ) {
        Parameter[] params;

        params = m.getParameters();

        if ( params.length > 0 && params.length < i ) {
            return params[i];
        } else {
            return null;
        }

    }

    private static void doWithMethod( String method_name, int param_value ) {
        Class class_instance;
        Object instance;
        Method method;
        Parameter param;

        class_instance = ReflectionCommon.getReflectionClass();
        instance = ReflectionCommon.createInstance( class_instance );

        if ( instance == null ) {
            out.print( "\nERROR! Class not found" );
            return;
        }

        out.print( ReflectionCommon.getName( instance ) );

        method = ReflectionCommon.getMethod( class_instance, method_name );

        if ( method == null ) {
            out.print( "\nERROR! Method not found " + method_name );
            return;
        }

        if ( ReflectionCommon.isPrivateMethod( method ) ) {
            out.println( "\nERROR! Method is not private" );
            return;
        }

        param = getParameter( method, 0 );

        if ( param == null ) {
            out.print( "\nERROR! Method has not param" );
            return;
        }

        out.print( ReflectionCommon.getClassName( instance ) );
        out.print( "\n  METHOD:" );
        out.println( "\n    " + ReflectionCommon.getMethodInfo( method ) );

        invokeMethod( instance, method, param_value );
    }

    /*
        Вызвать private метод с параметрами.
        CLI PARAMS: "java.lang.String" "charAt" "4"
    */
    public static void main( String[] args ) {

        out.println( "\nREFLECTION - 12" );

        doWithMethod( "setName", 4 );
    }
}