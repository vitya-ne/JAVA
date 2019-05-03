package com.epolsoft;

import java.lang.reflect.Method;
import static java.lang.System.out;

public class Reflection3 {


    public static void showClassName( Class refl_class ) {
        out.print( ReflectionCommon.getClassName( refl_class ) );
    }

    /*
        Выводим данные о методах интерфейса
    */
    public static void showInterfaceMethods( Class cl_interface ) {
        Method[] methods;

        try {
            methods = cl_interface.getDeclaredMethods();
        } catch ( SecurityException x ) {
            x.printStackTrace();
            return;
        }

        for ( Method m: methods ) {
            out.println( "    " + ReflectionCommon.getMethodInfo( m ) );
        }

    }

    /*
        Выводим данные о интерфейсах класса
    */
    public static void showInterfacesMethods( Class refl_class ) {
        Class[] interfaces;

        out.print( "\n  INTERFACES METHODS:" );

        try {
            interfaces = refl_class.getInterfaces();

        } catch ( SecurityException x ) {
            x.printStackTrace();
            return;
        }

        for ( Class i: interfaces ) {
            out.println( "\n    " + ReflectionCommon.getClassName( i ) );
            showInterfaceMethods( i );
        }

    }

    /*
        Выяснить, какие методы принадлежат реализуемому интерфейсу/интерфейсам
    */
    public static void main( String[] args ) {
        Class refl_class = ReflectionCommon.getReflectionClass();

        out.println( "\nREFLECTION - 3" );

        if ( refl_class == null ) {
            out.print( "\nERROR!" );
            return;
        }

        // Получить информацию о имени класса
        showClassName( refl_class );

        // Получить информацию о методах интерфейсов
        showInterfacesMethods( refl_class );
    }
}