package com.epolsoft;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static java.lang.System.in;
import static java.lang.System.out;

public class Reflection8 {

    private static void showPrivateFields( Object instance ) {
        Field[] fields;

        out.print( "\n  PRIVATE FIELDS:" );

        fields = ReflectionCommon.getDeclaredFields( instance );

        if ( fields.length == 0 ) {
            out.print( " --" );
            return;
        }

        for ( Field f: fields ) {
            int modifiers = f.getModifiers();
            if ( Modifier.isPrivate( modifiers ) ) {
                out.println( "\n    " + ReflectionCommon.getFieldInfo( f ) );
            }
        }
    }

    private static void showPublicFields( Object instance ) {
        Field[] fields;

        out.print( "\n  PUBLIC FIELDS:" );

        fields = ReflectionCommon.getDeclaredFields( instance );

        if ( fields.length == 0 ) {
            out.print( " --" );
            return;
        }

        for ( Field f: fields ) {
            int modifiers = f.getModifiers();
            if ( Modifier.isPublic( modifiers ) ) {
                out.println( "\n    " + ReflectionCommon.getFieldInfo( f ) );
            }
        }
    }

    /*
        Получить список публичных полей.
        Получить список приватных полей.
        CLI PARAMS: "java.lang.String"
    */
    public static void main( String[] args ) {
        Object instance;

        out.println( "\nREFLECTION - 8" );

        if ( args.length > 0 ) {
            instance = ReflectionCommon.createInstance( args[0] );

            if ( instance == null ) {
                out.print( "\nERROR!" );
                return;
            }

            out.print( ReflectionCommon.getClassName( instance.getClass() ) );

            showPublicFields( instance );
            showPrivateFields( instance );
        }
    }
}