package com.epolsoft;

import java.lang.reflect.Field;

import static java.lang.System.out;

public class Reflection10 {

    private static void showFieldValue( Object instance, Field field ) {

        if ( ReflectionCommon.isPrivateField( field ) ) {
            out.println( "\n    VALUE: " +
                    ReflectionCommon.showFieldValue( instance, field )
            );
        } else {
            out.println( "\n    is not private" );
        }
    }

    private static void doWithField( String class_name, String field_name ) {
        Object instance;
        Field field;

        instance = ReflectionCommon.createInstance( class_name );

        if ( instance == null ) {
            out.print( "\nERROR!" );
            return;
        }

        out.print( ReflectionCommon.getClassName( instance ) );

        field = ReflectionCommon.getField( instance, field_name );

        if ( field == null ) {
            out.print( "\nERROR! Field not found" );
            return;
        }

        out.print( "\n  PRIVATE FIELD:" +
                ReflectionCommon.getName( field )
        );

        showFieldValue( instance, field );
    }

    /*
        Напечатать значение private поля
        CLI PARAMS: "java.lang.String serialVersionUID"
    */
    public static void main( String[] args ) {
        out.println( "\nREFLECTION - 10" );

//        if ( args.length < 2 ) {
//            out.println( "\nPlease set program arguments: <ClassName> <FieldName>" );
//            out.println( "Example:" );
//            out.println( "java.lang.String serialVersionUID" );
//            return;
//        }
//
//        doWithField( args[0], args[1] );
        doWithField( "java.lang.String", "serialVersionUID" );
    }
}