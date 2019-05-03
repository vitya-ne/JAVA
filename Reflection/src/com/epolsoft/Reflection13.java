package com.epolsoft;

import java.lang.reflect.*;

import static java.lang.System.out;

public class Reflection13 {
    private static Field getField( Class class_instance, String field_name ) {
        return ReflectionCommon.getField( class_instance, field_name );
    }

    private static void showFieldValue( Object instance, Field field, String label ) {
        Object value = ReflectionCommon.showFieldValue( instance, field );

        out.println( label + value );
    }

    private static Object invokeConstructor( Constructor constructor, Integer p_value ) {
        constructor.setAccessible( true );

        try {
            return constructor.newInstance( p_value );
        } catch ( InstantiationException | IllegalAccessException | InvocationTargetException e ) {
            //e.printStackTrace();
            return null;
        }

    }

    private static Constructor getParamConstructor( Class class_instance, int param_count ) {
        Constructor[] constructors = class_instance.getDeclaredConstructors();

        for ( Constructor c : constructors ) {
            int c_param_count = c.getParameterCount();

            if ( c_param_count == param_count ) {
                return c;
            }
        }

        return null;
    }

    private static void showConstructor( Constructor c ) {
        out.print( "\n  CONSTRUCTOR:" );
        out.println( ReflectionCommon.getName( c ) +
                "\n    " +
                ReflectionCommon.getModifiersInfo( c.getModifiers() ) +
                "\n    " +
                ReflectionCommon.getParamsInfo( c.getParameters() )
        );
    }

    private static void doWithConstructor( int param_value ) {
        Class class_instance;
        Object instance;
        Constructor constructor;
        Field field;

        class_instance = ReflectionCommon.getReflectionClass();

        if ( class_instance == null ) {
            out.print( "\nERROR! Class not found" );
            return;
        }

        out.print( ReflectionCommon.getClassName( class_instance ) );

        constructor = getParamConstructor( class_instance, 1 );

        if ( constructor == null ) {
            out.print( "\nERROR! Constructor with params not found" );
            return;
        }

        showConstructor( constructor );

        out.println( "\n  INVOKE CONSTRUCTOR PARAM: " + param_value );
        out.println( "\nNEW INSTANCE:" );
        instance = invokeConstructor( constructor, param_value );

        if ( instance != null ) {
            out.print( ReflectionCommon.getClassName( instance ) );
            out.print( "\n  FIELD:" );

            field = getField( class_instance, "number" );

            if ( field == null ) {
                out.print( "\nERROR!" );
                return;
            }

            out.println( ReflectionCommon.getFieldInfo( field ) );

            showFieldValue( instance, field, "    VALUE: " );
        }
    }

    /*
        Вызвать private конструктор с параметрами.
        CLASS: com.Reflection_Source
    */
    public static void main( String[] args ) {

        out.println( "\nREFLECTION - 13" );

        doWithConstructor( 4 );
    }
}