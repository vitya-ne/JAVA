package com.epolsoft;

import java.lang.reflect.Field;

import static java.lang.System.out;

public class Reflection10 {

    private static void showFieldValue( Object instance, String field_name ) {
        Field field;

        field = ReflectionCommon.getField( instance, field_name );

        if ( field == null ) {
            out.print( "\nERROR! Field not found" );
            return;
        }

        out.print( "\n  PRIVATE FIELD:" );
        out.print( ReflectionCommon.getName( field ) );

        if ( ReflectionCommon.isPrivateField( field ) ) {
            out.println( "\n    VALUE: " +
                    ReflectionCommon.showFieldValue( instance, field )
            );
        } else {
            out.println( "\n    is not private" );
        }


    }


    /*
        Напечатать значение private поля
        CLI PARAMS: "java.lang.String"
    */
    public static void main( String[] args ) {
        Object instance;

        out.println( "\nREFLECTION - 10" );

        if ( args.length < 2 ) {
            out.println( "\nPlease set program arguments: <ClassName> <FieldName>" );
            out.println( "Example:" );
            out.println( "java.lang.String serialVersionUID" );
            return;
        }

        instance = ReflectionCommon.createInstance( args[0] );

        if ( instance == null ) {
            out.print( "\nERROR!" );
            return;
        }

        out.print( ReflectionCommon.getClassName( instance ) );

        showFieldValue( instance, "serialVersionUID" );

    }
}