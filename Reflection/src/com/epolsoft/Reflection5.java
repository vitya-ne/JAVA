package com.epolsoft;

import java.lang.reflect.Field;

import static java.lang.System.out;

public class Reflection5 {
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

    private static void doWithField( String class_name, String field_name ) {
        Object instance;
        Field field;

        instance = ReflectionCommon.createInstance( class_name );

        if ( instance == null ) {
            out.print( "\nERROR!" );
            return;
        }

        field = ReflectionCommon.getField( instance, field_name );

        if ( field == null ) {
            out.print( "\nERROR!" );
            return;
        }

        out.println( ReflectionCommon.getClassName( instance ) );

        out.print( "  FIELD:" );

        out.println( ReflectionCommon.getFieldInfo( field ) );

        showFieldValue( instance, field, "\n    OLD VALUE: " );

        setFieldIntValue( instance, field, 8888 );

        showFieldValue( instance, field, "\n    NEW VALUE: " );
    }

    /*
        Получить и установить значение поля объекта по имени.
        Поле неизвестно до момента выполнения программы.
        CLI PARAMS: "java.lang.String" "hash"
    */
    public static void main( String[] args ) {
        String class_name, field_name;

        out.println( "\nREFLECTION - 5" );

        if ( args.length < 2 ) {
            out.println("\nPlease set program arguments: <ClassName> <ClassField>");
            out.println("Example:");
            out.println("java.lang.String hash");
            return;
        }

        class_name = args[0];
        field_name = args[1];

        doWithField( class_name, field_name );
    }
}