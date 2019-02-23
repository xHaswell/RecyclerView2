package mx.com.softwell.recyclerview2;

public class Alumno {

    private String nombre;
    private String noControl;

    public Alumno() {
    }

    public Alumno(String nombre, String noControl) {
        this.nombre = nombre;
        this.noControl = noControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNoControl() {
        return noControl;
    }

    public void setNoControl(String noControl) {
        this.noControl = noControl;
    }
}
