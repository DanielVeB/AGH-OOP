package pl.edu.agh.student.danielkurosz.Matrix;

import java.util.Scanner;
/**
 *
 * @author DanielKurosz
 */
class Matrix {
    private int[][] table;

    /**
     *
     * @param _x size of rows in matrix
     * @param _y size of columns in matrix
     */
    Matrix(int _x, int _y) {
        table = new int[_x][_y];
    }

    /**
     *
     * @param a copy matrix a
     */
    Matrix(Matrix a) {
        this.table = new int[a.table.length][a.table[0].length];
        for (int i = 0; i < a.table.length; ++i) {
            System.arraycopy(a.table[i], 0, table[i], 0, a.table[0].length);
        }
    }

    void display() {
        for (int[] aTable : table) {
            for (int j :aTable) {
                System.out.print(j+" | ");
            }
            System.out.println();
        }
    }

    void setTable() {
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i < table.length; ++i) {
            for (int j = 0; j < table[0].length; ++j) {
                System.out.print((i+1)+" rzad, "+(j+1)+" kolejka: ");
                table[i][j]=scanner.nextInt();
            }

        }
    }

    /**
     *
     * @param a matrix which will be added to the current matrix
     * @return new matrix after adding
     */
    Matrix add(Matrix a)throws OwnException{
        if(!check(a))throw new OwnException("Macierz jest zlych wymiarow");
        Matrix newmatrix=new Matrix(table.length,table[0].length);
        for (int i=0;i<table.length;++i){
            for (int j=0;j<table[0].length;++j){
                newmatrix.table[i][j]=table[i][j]+a.table[i][j];
            }
        }
        return newmatrix;
    }
    /**
     *
     * @param a matrix which will be substacted to the current matrix
     * @return new matrix after substracting
     */
    Matrix sub(Matrix a)throws OwnException{
        if(!check(a))throw new OwnException("Macierz jest zlych wymiarow");
        Matrix newmatrix=new Matrix(table.length,table[0].length);
        for (int i=0;i<table.length;++i){
            for (int j=0;j<table[0].length;++j){
                newmatrix.table[i][j]=table[i][j]-a.table[i][j];
            }
        }
        return newmatrix;
    }
    /**
     *
     * @param a matrix which will be multiplied to the current matrix
     * @return new matrix after multiply
     */
    Matrix mul(Matrix a)throws OwnException{
        if(!checkformultiply(a))throw new OwnException("Macierz jest zlych wymiarow");
        Matrix newmatrix=new Matrix(table.length,a.table[0].length);
        int sum;
        for(int i=0;i<newmatrix.table.length;++i){
            for (int j=0;j<newmatrix.table[0].length;++j){
                sum=0;
                for(int k=0;k<a.table.length;++k){
                    sum+=table[i][k]*a.table[k][j];
                }
                newmatrix.table[i][j]=sum;
            }
        }
        return newmatrix;
    }

    /**
     *
     * @param a Matrix
     * @return true when matrix a has the same dimensions like current matrix
     */
    private boolean check(Matrix a){
        return (this.table.length==a.table.length && this.table[0].length==a.table[0].length);
    }

    /**
     *
     * @param a Matrix
     * @return true when matrix a has the same dimensions like current matrix
     */
    private boolean checkformultiply(Matrix a){
        return (this.table[0].length==a.table.length );
    }
}

class OwnException extends Exception{
    OwnException(String message){
        System.out.print(message);
    }
}
