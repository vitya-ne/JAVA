package com.epolsoft;

import java.lang.reflect.Method;

import static java.lang.System.out;

public class Reflection4 {
    public static void showItemClassName( Object item ) {
        out.print( ReflectionCommon.getClassName( item ) );
    }

    private static Class createObject( String class_name ) {
        return ReflectionCommon.getReflectionClass( class_name );
    }


    /*
        Создать экземпляр класса, причем имя класса неизвестно до момента выполнения программы.
        (считывается из файла, или вводиться с клавиатуры, или передается как параметр
        командной строки при запуске)
    */
    public static void main( String[] args ) {
        Class class_instance;
        Object instance;

        out.println( "\nREFLECTION - 4" );

        if ( args.length > 0 ) {
            class_instance = ReflectionCommon.getReflectionClass( args[0] );

            instance = ReflectionCommon.createInstance( class_instance );

            if ( instance == null ) {
                out.print( "\nERROR!" );
                return;
            }

            showItemClassName( instance );
        }
    }
}