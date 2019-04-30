package com.epolsoft;

import java.lang.reflect.Field;

import static java.lang.System.out;

public class Reflection11 {

    private static void showFieldValue( Object instance, Field field, String label ) {
        Object value = ReflectionCommon.showFieldValue( instance, field );

        out.println( label + value );
    }

    private static void setFieldIntValue( Object instance, Field field, int new_value ) {
        field.setAccessible( true );
        try {
            field.set( instance, new_value );
        } catch ( IllegalAccessException e ) {
            e.printStackTrace();
        }
    }

    private static void doWithIntField( String class_name, String field_name, String new_value ) {
        Object instance;
        Field field;

        instance = ReflectionCommon.createInstance(class_name);

        if (instance == null) {
            out.print("\nERROR! Class not found");
            return;
        }

        field = ReflectionCommon.getField(instance, field_name);

        if (field == null) {
            out.print("\nERROR! Field not found");
            return;
        }

        out.print( ReflectionCommon.getClassName( instance ) );
        out.print( ReflectionCommon.getName( field ) );

        if ( ReflectionCommon.isPrivateField( field ) ) {
            showFieldValue( instance, field, "\n    OLD VALUE: " );
            setFieldIntValue( instance, field, Integer.parseInt( new_value ) );
            showFieldValue( instance, field, "\n    NEW VALUE: ");
        } else {
            out.println( "\n    is not private" );
        }
    }

    /*
        Модифицировать значение private поля
        CLI PARAMS: "java.lang.String hash 88888"
    */
    public static void main( String[] args ) {
        Object instance;

        out.println( "\nREFLECTION - 11" );

        if ( args.length < 3 ) {
            out.println("\nPlease set program arguments: <ClassName> <FieldName> <NewValue>");
            out.println("Example:");
            out.println("java.lang.String hash 8888");
            return;
        }

        doWithIntField( args[0], args[1], args[2] );


    }
}