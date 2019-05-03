package com.epolsoft;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static java.lang.System.out;

public class Reflection7 {

    private static void showPrivateMethods( Object instance ) {
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
                out.println( ReflectionCommon.getMethodInfo( m ) );
            }
        }
    }
    private static void showPublicMethods( Object instance ) {
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
                out.println( ReflectionCommon.getMethodInfo( m ) );
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

        if ( args.length == 0 ) {
            out.println("\nPlease set program arguments: <ClassName>");
            out.println("Example:");
            out.println("java.lang.String");
            return;
        }

        instance = ReflectionCommon.createInstance( args[0] );

        if ( instance == null ) {
            out.print( "\nERROR!" );
            return;
        }

        out.print( ReflectionCommon.getClassName( instance ) );

        showPublicMethods( instance );
        showPrivateMethods( instance );
    }
}