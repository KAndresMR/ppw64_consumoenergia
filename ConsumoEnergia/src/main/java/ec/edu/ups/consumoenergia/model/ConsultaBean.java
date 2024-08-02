package ec.edu.ups.consumoenergia.model;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.List;

//El Managed Bean es una clase Java que actúa como controlador en JSF. Se encargará de manejar la interacción entre la vista (página JSF) y la lógica de negocio (EJB).

@Named
@RequestScoped
public class ConsultaBean {

    private String cedula;
    private Usuario usuario;
    private List<ConsumoDeuda> consumoDeudas;

    @EJB
    private UsuarioService usuarioService;

    public void consultar() {
        usuario = usuarioService.getUsuarioPorCedula(cedula);
        if (usuario != null) {
            consumoDeudas = usuarioService.getConsumoDeudaPorCedula(cedula);
        }
    }

    // Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ConsumoDeuda> getConsumoDeudas() {
        return consumoDeudas;
    }

    public void setConsumoDeudas(List<ConsumoDeuda> consumoDeudas) {
        this.consumoDeudas = consumoDeudas;
    }
}