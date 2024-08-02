package ec.edu.ups.consumoenergia.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


//Esta clase proporcionará métodos para buscar información sobre un usuario, como sus datos personales, consumos y deudas.


@Stateless
public class UsuarioService {

    @PersistenceContext(unitName = "ConsumoEnergiaPU")
    private EntityManager em;

    public Usuario getUsuarioPorCedula(String cedula) {
        return em.find(Usuario.class, cedula);
    }

    public List<ConsumoDeuda> getConsumoDeudaPorCedula(String cedula) {
        return em.createQuery("SELECT c FROM ConsumoDeuda c WHERE c.cedulaUsuario = :cedula", ConsumoDeuda.class)
                 .setParameter("cedula", cedula)
                 .getResultList();
    }
}