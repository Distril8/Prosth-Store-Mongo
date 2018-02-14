/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.prosth.mongo.dao.UsuarioDAO;
import ec.edu.espe.distribuidas.prosth.mongo.model.Categoria;
import ec.edu.espe.distribuidas.prosth.mongo.model.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Hendrix
 */
@Stateless
@LocalBean
public class AutenticacionService {
    
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
    
   

    public Usuario obtenerPorCodigo(Integer codigo) {
        return this.usuarioDAO.findOne("codigo", codigo);
    }
    
    public List<Usuario> buscarPorMail(String mail) {
        return this.usuarioDAO.findbyMail(mail);
    }

    public void crear(Usuario usuario) {
        
        this.usuarioDAO.save(usuario);
    }

    public void modificar(Usuario usuario) {
        Usuario aux = this.usuarioDAO.findOne("codigo", usuario.getCodigo());
        usuario.setId(aux.getId());
        this.usuarioDAO.save(usuario);
    }

    public void eliminar(Integer codigo) {
        Usuario producto = this.usuarioDAO.findOne("codigo", codigo);
        this.usuarioDAO.delete(producto);
    }
    
    
    
    
    
    
//    public Usuario login(String mail, String clave) {
//        List<Usuario> usuarios = this.usuarioDAO.findByMail(mail);
//        Usuario usuario = usuarios.get(0);
//        if (usuario!=null && usuario.getPassword().equals(clave)) {
//            return usuario;
//        } else {
//            return null;
//        }
//    }
}
