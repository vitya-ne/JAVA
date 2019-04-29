package com.epolsoft;

import java.lang.reflect.*;

public class ReflectionCommon {

    /*
        Получаем класс объекта
    */
    public static Class getReflectionClass() {
        Class source;

        return getReflectionClass( "com.epolsoft.Reflection_Source" );

    }

    public static Class getReflectionClass( String class_name ) {
        Class source;

        try {
            source = Class.forName( class_name );

            return source;
        } catch ( ClassNotFoundException err ) {
            //err.printStackTrace();
            return null;
        }
    }

    /*
        Возвращаем представление имени класса
    */
    public static String getClassName( Object instance ) {
        return getClassName( instance.getClass() );
    }

    public static String getClassName( Class refl_class ) {
        String class_name = refl_class.getName();

        return "CLASS [" + class_name + "]";
    }

    /*
        Возвращаем представление имени для Executable и его наследников
    */
    public static String getName( Object class_instance ) {
        return "NAME: [" + class_instance.getClass() + "]";
    }

    public static String getName( Class class_instance ) {
        return "NAME: [" + class_instance.getName() + "]";
    }

    public static String getModifiersInfo( int modifiers ) {
        return "MODIFIERS: " + Modifier.toString( modifiers );
    }

    public static String getParamsInfo( Parameter[] params ) {
        String result_str = "PARAMETERS:";

        if ( params.length < 1 ) {
            result_str += " -";
        } else {
            for (Parameter p : params) {
                result_str += " " + p.getName() + " { " + p.getType().getTypeName() + " }";
            }
        }

        return result_str;
    }

    public static String getMethodInfo( Method m ) {
        return getMethodInfo( m, "\n    " );
    }

    public static String getMethodInfo( Method m, String splitter ) {
        return getName( m.getClass() ) +
                splitter +
                getModifiersInfo( m.getModifiers() ) +
                splitter +
                getParamsInfo( m.getParameters() ) +
                splitter + "RETURN TYPE " + m.getReturnType().getTypeName();
    }

    public static Object createInstance( String class_name ) {
        if ( class_name.length() == 0 ) {
            return null;
        }

        return createInstance( getReflectionClass( class_name ) );
    }


    public static Object createInstance( Class class_instance ) {
        if ( class_instance == null ) {
            return null;
        }

        try {
            return class_instance.newInstance();
        } catch ( InstantiationException | IllegalAccessException e ) {
            //e.printStackTrace();
            return null;
        }
    }

    public static Field getField( Object instance, String field_name ) {
        return getField( instance.getClass(), field_name );
    }


    public static Field getField( Class class_instance, String field_name ) {
        try {
            return class_instance.getDeclaredField( field_name );
        } catch ( NoSuchFieldException e ) {
            //e.printStackTrace();
            return null;
        }
    }

    public static String getFieldInfo( Field f ) {
        return getFieldInfo( f, "\n    " );
    }

    public static String getFieldInfo( Field f, String splitter ) {
        return getName( f.getClass() ) +
                splitter +
                getModifiersInfo( f.getModifiers() ) +
                splitter +
                "TYPE: " + f.getType().getTypeName();
    }

    public static Field[] getDeclaredFields( Object instance ) {
        return getDeclaredFields( instance.getClass() );
    }

    public static Field[] getDeclaredFields( Class class_instance ) {
        try {
            return class_instance.getDeclaredFields();
        } catch ( SecurityException x ) {
            //x.printStackTrace();
            return null;
        }
    }

    public static Method getMethod( Object instance, String method_name ) {
        return getMethod( instance.getClass(), method_name );
    }

    public static Method getMethod( Class class_instance, String method_name ) {
        try {
            return class_instance.getDeclaredMethod( method_name );
        } catch ( NoSuchMethodException e ) {
            //e.printStackTrace();
            return null;
        }
    }

    public static Method[] getDeclaredMethods( Object instance ) {
        return getDeclaredMethods( instance.getClass() );
    }

    public static Method[] getDeclaredMethods( Class class_instance ) {
        try {
            return class_instance.getDeclaredMethods();
        } catch ( SecurityException x ) {
            //x.printStackTrace();
            return null;
        }
    }
}
