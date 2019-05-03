package com.epolsoft;

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
        CLI PARAMS: "java.lang.String"
    */
    public static void main( String[] args ) {
        Object instance;

        out.println( "\nREFLECTION - 4" );

        if ( args.length == 0 ) {
            out.println( "\nPlease set program arguments: <ClassName>" );
            out.println( "Example:" );
            out.println( "java.lang.String" );
            return;
        }

        instance = ReflectionCommon.createInstance( args[0] );

        if ( instance == null ) {
            out.print( "\nERROR!" );
            return;
        }

        showItemClassName( instance );
    }
}