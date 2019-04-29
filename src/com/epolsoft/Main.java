package com.epolsoft;



public class Main {



    public static void main(String[] args) {
        int X_MAX = 3;
        int Y_MAX = 3;

        System.out.print("\nMatrix size:[" + X_MAX + ":" + Y_MAX + "]" );

        System.out.print("\nEnter first matrix data:");
        Matrix m1 = new Matrix( X_MAX, Y_MAX );
        System.out.print("\nEnter second matrix data:");
        Matrix m2 = new Matrix( X_MAX, Y_MAX );

        m1.printData();
        m2.printData();

        m1.addMatrix( m2 );

        System.out.print("\n M1 + M2:");
        m1.printData();

        m1.subMatrix( m2 );

        System.out.print("\n M1 - M2:");
        m1.printData();

    }
}
