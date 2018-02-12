/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.prosth.mongo.dao.ConductorDAO;
import ec.edu.espe.distribuidas.prosth.mongo.model.Conductor;
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
public class ConductorService {
    @EJB
    private MongoPersistence mp;
    private ConductorDAO conductorDao;
    
    @PostConstruct
    public void init() {
        this.conductorDao = new ConductorDAO(Conductor.class, mp.context());
    }

    public List<Conductor> obtenerTodos() {
        return this.conductorDao.find().asList();
    }

    public Conductor obtenerPorCodigo(Integer codigo) {
        return this.conductorDao.findOne("codigo", codigo);
    }

    public void crear(Conductor conductor) {
        
        this.conductorDao.save(conductor);
    }

    public void modificar(Conductor conductor) {
        Conductor aux = this.conductorDao.findOne("codigo", conductor.getCodigo());
        conductor.setId(aux.getId());
        this.conductorDao.save(conductor);
    }

    public void eliminar(Integer codigo) {
        Conductor conductor = this.conductorDao.findOne("codigo", codigo);
        this.conductorDao.delete(conductor);
    }
}
