package pl.edu.agh.student.danielkurosz.Matrix;

public class MatrixProgram {
    public static void main(String[] args) {
        Matrix matrix=new Matrix(2,3);
        Matrix matrix3=new Matrix(3,4);
        matrix.setTable();
        matrix3.setTable();
        matrix.display();
        Matrix matrix1=new Matrix(matrix);
        Matrix matrix2=new Matrix(2,3);
        try {
            matrix2=matrix.add(matrix1);
            matrix2.display();
            matrix2=matrix.mul(matrix3);
            matrix2.display();
        }catch (OwnException e){

        }

    }


}
