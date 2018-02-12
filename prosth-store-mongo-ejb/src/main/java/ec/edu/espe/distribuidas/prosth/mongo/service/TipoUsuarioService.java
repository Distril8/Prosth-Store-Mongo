/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.prosth.mongo.dao.TipoUsuarioDAO;
import ec.edu.espe.distribuidas.prosth.mongo.model.TipoUsuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author js_cm
 */
@Stateless
@LocalBean
public class TipoUsuarioService {

    @EJB
    private MongoPersistence mp;
    private TipoUsuarioDAO tipoUsuarioDao;
    
    @PostConstruct
    public void init() {
        this.tipoUsuarioDao = new TipoUsuarioDAO(TipoUsuario.class, mp.context());
    }

    public List<TipoUsuario> obtenerTodos() {
        return this.tipoUsuarioDao.find().asList();
    }

    public TipoUsuario obtenerPorCodigo(Integer codigo) {
        return this.tipoUsuarioDao.findOne("codigo", codigo);
    }

    public void crear(TipoUsuario tipoUsuario) {
        this.tipoUsuarioDao.save(tipoUsuario);
    }

    public void modificar(TipoUsuario tipoUsuario) {
        this.tipoUsuarioDao.save(tipoUsuario);
    }

    public void eliminar(Integer codigo) {
        TipoUsuario tipoUsuario = this.tipoUsuarioDao.findOne("codigo", codigo);
        this.tipoUsuarioDao.delete(tipoUsuario);
    }
}