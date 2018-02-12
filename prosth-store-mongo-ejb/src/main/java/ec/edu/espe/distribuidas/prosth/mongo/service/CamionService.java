/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.prosth.mongo.dao.CamionDAO;
import ec.edu.espe.distribuidas.prosth.mongo.model.Camion;
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
public class CamionService {
    
    @EJB
    private MongoPersistence mp;
    private CamionDAO camionDao;
    
    @PostConstruct
    public void init() {
        this.camionDao = new CamionDAO(Camion.class, mp.context());
    }

    public List<Camion> obtenerTodos() {
        return this.camionDao.find().asList();
    }

    public void crear(Camion camion) {
        this.camionDao.save(camion);
    }

    public void modificar(Camion camion) {
        this.camionDao.save(camion);
    }
    
    public void eliminar(Integer codigo) {
        Camion camion = this.camionDao.findOne("codigo", codigo);
        this.camionDao.delete(camion);
    }
}
