package com.epolsoft;

import java.lang.reflect.Field;

import static java.lang.System.out;

public class Reflection5 {
    private static void showField( Field field ) {
        int f_modifiers = field.getModifiers();
        out.println("\n    NAME: ["+field.getName()+"]"+
                "\n    "+
                ReflectionCommon.getModifiersInfo(f_modifiers )+
                ", TYPE: "+field.getType().getCanonicalName()
        );
    }

    private static void showFieldValue( Object instance, Field field, String label ) {
        field.setAccessible( true );
        try {
            out.print( label + field.get( instance ));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void setFieldStringValue( Object instance, Field field, int new_value) {
        field.setAccessible( true );
        try {
            field.set( instance, new_value );
        } catch ( IllegalAccessException e ) {
            e.printStackTrace();
        }
    }

    private static void doWithField(String class_name, String field_name ) {
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

        out.print( ReflectionCommon.getClassName( instance ) );

        showField( field );
        showFieldValue( instance, field, "\n    OLD VALUE: " );

        setFieldStringValue( instance, field, 8888 );

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

        if ( args.length == 2 ) {
            class_name = args[0];
            field_name = args[1];

            doWithField( class_name, field_name );
        }
    }
}