package com.epolsoft;

import java.lang.reflect.*;

import static java.lang.System.out;

public class Reflection2 {

    /*
        Выводим данные о имени класса
    */
    public static void showClassName( Class refl_class ) {
        out.print( ReflectionCommon.getClassName( refl_class ) );
    }

    /*
        Выводим данные о модификаторах класса
    */
    public static void showClassModifiers( Class refl_class ) {
        int modifiers = refl_class.getModifiers();

        out.print( ReflectionCommon.getModifiersInfo( modifiers ) );
    }

    /*
        Выводим данные о свойствах/полях класса
    */
    public static void showClassFields( Class refl_class ) {
        Field[] fields;

        out.print( "\n  FIELDS:" );

        try {
            fields = refl_class.getDeclaredFields();
        } catch ( SecurityException x ) {
            x.printStackTrace();
            return;
        }

        for ( Field f: fields ) {
            int f_modifiers = f.getModifiers();

            if ( !Modifier.isFinal( f_modifiers )) {
                out.println( "\n    NAME: [" + f.getName() + "]" +
                        "\n    " +
                        ReflectionCommon.getModifiersInfo( f_modifiers ) +
                        ", TYPE: " + f.getType().getCanonicalName()
                );
            }

        }

    }

    /*
        Выводим данные о константах класса
    */
    public static void showClassConstants( Class refl_class ) {
        Field[] fields;

        out.print( "\n  CONSTANTS:" );

        fields = ReflectionCommon.getDeclaredFields( refl_class );

        if ( fields.length == 0 ) {
            out.print( " --" );
            return;
        }

        for ( Field f: fields ) {
            int f_modifiers = f.getModifiers();

            if ( Modifier.isFinal( f_modifiers ) ) {
                out.println( "\n    NAME: [" + f.getName() + "]" +
                        "\n    " +
                        ReflectionCommon.getModifiersInfo( f_modifiers ) +
                        ", TYPE: " + f.getType() +
                        ", GENERIC TYPE: " + f.getGenericType()
                );
            }
        }

    }

    /*
        Выводим данные о свойствах класса
    */
    public static void showClassMethods( Class refl_class ) {
        Method[] methods;

        out.print( "\n  METHODS:" );

        try {
            methods = refl_class.getDeclaredMethods();
        } catch ( SecurityException x ) {
            x.printStackTrace();
            return;
        }

        for ( Method m: methods ) {
            out.println( "\n    " + ReflectionCommon.getMethodInfo( m ) );
        }

    }

    /*
        Выводим данные о конструкторах класса
    */
    public static void showConstructors( Constructor[] constructors ) {
        for (Constructor c : constructors) {
            out.println("\n    " +
                    ReflectionCommon.getName( c ) +
                    "\n    " +
                    ReflectionCommon.getModifiersInfo( c.getModifiers() ) +
                    "\n    " +
                    ReflectionCommon.getParamsInfo( c.getParameters() )
            );
        }
    }

    /*
        Выводим данные о всех конструкторах класса
    */
    public static void showClassConstructors( Class refl_class ) {
        out.print( "\n  CONSTRUCTORS:" );

        try {
            showConstructors( refl_class.getDeclaredConstructors() );
        } catch ( SecurityException x ) {
            x.printStackTrace();
        }
    }

    /*
        Выводим данные о родительских классах
    */
    public static void showClassSuper( Class refl_class ) {
        Class superclass;

        out.print( "\n  SUPERCLASSES:" );

        try {
            superclass = refl_class.getSuperclass();

            while ( superclass != null ) {
                out.print( "\n    " );
                showClassName( superclass );
                out.print( "\n      " );
                showClassModifiers( superclass );
                superclass = superclass.getSuperclass();
                out.print( "\n" );
            }

        } catch ( SecurityException x ) {
            x.printStackTrace();
        }
    }

    /*
        Получить информацию о модификаторах класса, полях, методах, константах, конструкторах
        и суперклассах
    */
    public static void main( String[] args ) {
        Class refl_class = ReflectionCommon.getReflectionClass();

        out.println( "\n REFLECTION - 2" );

        if ( refl_class == null ) {
            out.print( "\nERROR!" );
            return;
        }

        // Получить информацию о имени
        showClassName( refl_class );

        // ..модификаторах класса
        out.print( "\n  " );
        showClassModifiers( refl_class );

        // ..полях
        showClassFields( refl_class );

        // ..константах
        showClassConstants( refl_class );

        // ..методах
        showClassMethods( refl_class );

        // ..конструкторах
        showClassConstructors( refl_class );

        // ..суперклассах
        showClassSuper( refl_class );
    }
}