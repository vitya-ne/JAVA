package com.epolsoft;

import static java.lang.System.out;

public class Reflection1 {

    public static void showClassName( Class class_item ) {
        System.out.println( "\n" + ReflectionCommon.getClassName( class_item ) );
    }

    /*
        Получить класс объекта
    */
    public static void main( String[] args ) {

        Class refl_class = ReflectionCommon.getReflectionClass();

        if ( refl_class == null ) {
            out.print( "\nERROR!" );
            return;
        }

        showClassName( refl_class );
    }
}
