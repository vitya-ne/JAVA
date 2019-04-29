package com.epolsoft;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Ref;

import static java.lang.System.out;

public class Reflection7 {

    private static void showPrivateMethods( Object instance ) {
        Class class_instance = instance.getClass();
        Method[] methods;

        out.print( "\n  PRIVATE METHODS:" );

        methods = ReflectionCommon.getDeclaredMethods( instance );

        if ( methods.length == 0 ) {
            out.print( " --" );
            return;
        }

        for ( Method m: methods ) {
            int modifiers = m.getModifiers();
            if ( Modifier.isPrivate( modifiers ) ) {
                out.println( "\n    " + ReflectionCommon.getMethodInfo( m ) );
            }
        }
    }
    private static void showPublicMethods( Object instance ) {
        Class class_instance = instance.getClass();
        Method[] methods;

        out.print( "\n  PUBLIC METHODS:" );

        methods = ReflectionCommon.getDeclaredMethods( instance );

        if ( methods.length == 0 ) {
            out.print( " --" );
            return;
        }

        for ( Method m: methods ) {
            int modifiers = m.getModifiers();
            if ( Modifier.isPublic( modifiers ) ) {
                out.println( "\n    " + ReflectionCommon.getMethodInfo( m ) );
            }
        }
    }

    /*
        Получить список публичных методов.
        Получить список приватных методов
        CLI PARAMS: "java.lang.String"
    */
    public static void main( String[] args ) {
        Object instance;

        out.println( "\nREFLECTION - 7" );

        if ( args.length > 0 ) {

            instance = ReflectionCommon.createInstance( args[0] );

            if ( instance == null ) {
                out.print( "\nERROR!" );
                return;
            }

            out.print( ReflectionCommon.getClassName( instance.getClass() ) );

            showPublicMethods( instance );
            showPrivateMethods( instance );
        }
    }
}