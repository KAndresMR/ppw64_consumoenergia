package ec.edu.ups.consumoenergia.model;
import javax.persistence.Entity;
import javax.persistence.Id;

//Esta clase representará a los usuarios del sistema.

@Entity
public class Usuario {

    @Id
    private String cedula;
    private String nombre;
    private String apellido;
    private double consumoEnergia;
    private double deudaPendiente;

    // Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(double consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public double getDeudaPendiente() {
        return deudaPendiente;
    }

    public void setDeudaPendiente(double deudaPendiente) {
        this.deudaPendiente = deudaPendiente;
    }
}