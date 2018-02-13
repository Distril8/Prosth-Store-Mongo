/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.prosth.mongo.dao.DetalleDAO;
import ec.edu.espe.distribuidas.prosth.mongo.model.Detalle;
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
public class DetalleService {
    @EJB
    private MongoPersistence mp;
    private DetalleDAO detalleDao;
    
    @PostConstruct
    public void init() {
        this.detalleDao = new DetalleDAO(Detalle.class, mp.context());
    }

    public List<Detalle> obtenerTodos() {
        return this.detalleDao.find().asList();
    }

    public Detalle obtenerPorCodigo(Integer codigo) {
        return this.detalleDao.findOne("codigo", codigo);
    }

    public void crear(Detalle detalle) {
        
        this.detalleDao.save(detalle);
    }

    public void modificar(Detalle detalle) {
        Detalle aux = this.detalleDao.findOne("codigo", detalle.getCodigo());
        detalle.setId(aux.getId());
        this.detalleDao.save(detalle);
    }

    public void eliminar(Integer codigo) {
        Detalle detalle = this.detalleDao.findOne("codigo", codigo);
        this.detalleDao.delete(detalle);
    }
}
