/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.mongo.service;


import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.prosth.mongo.dao.UsuarioDAO;
import ec.edu.espe.distribuidas.prosth.mongo.model.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Protesis Store Corp.
 */
@Stateless
@LocalBean
public class UsuarioService {
    
    @EJB
    private MongoPersistence mp;
    private UsuarioDAO usuarioDAO;

    @PostConstruct
    public void init() {
        this.usuarioDAO = new UsuarioDAO(Usuario.class, mp.context());
    }
    
    public List<Usuario> obtenerTodos() {
        return this.usuarioDAO.find().asList();
    }

    public Usuario obtenerPorCodigo(String codigo) {
        return this.usuarioDAO.findOne("codigo", codigo);
    }

    public void crear(Usuario usuario) {
        this.usuarioDAO.save(usuario);
    }

    public void modificar(Usuario usuario) {
        Usuario aux = this.usuarioDAO.findOne("codigo", usuario.getCodigo());
        usuario.setId(aux.getId());
        this.usuarioDAO.save(usuario);
    }
    
    public void obtenerPorEmail(String email){
        this.usuarioDAO.findbyMail(email);
    }

}
