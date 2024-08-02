package ec.edu.ups.consumoenergia.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//Esta clase representará los registros de consumo y deuda asociados a un usuario.


@Entity
public class ConsumoDeuda {

    @Id
    private String id;
    private String cedulaUsuario;
    private double consumo;
    private double deuda;

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }
}