package pl.edu.agh.student.danielkurosz.Punkt;

public class Punkt3D extends Punkt2D{
    protected double z;

    public Punkt3D(double _x, double _y,double _z) {
        super(_x, _y);
        z=_z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public double distance(){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
    }
}
