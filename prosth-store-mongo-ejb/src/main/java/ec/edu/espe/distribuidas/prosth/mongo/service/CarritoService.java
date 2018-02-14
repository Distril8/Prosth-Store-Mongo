/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.prosth.mongo.dao.CarritoDAO;
import ec.edu.espe.distribuidas.prosth.mongo.model.Carrito;
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
public class CarritoService {
    
    @EJB
    private MongoPersistence mp;
    private CarritoDAO carritoDao;
    
    @PostConstruct
    public void init() {
        this.carritoDao = new CarritoDAO(Carrito.class, mp.context());
    }

    public List<Carrito> obtenerTodos() {
        return this.carritoDao.find().asList();
    }

    public void crear(Carrito carrito) {
        this.carritoDao.save(carrito);
    }

    public void modificar(Carrito carrito) {
        Carrito aux = this.carritoDao.findOne("codigo", carrito.getCodigo());
        carrito.setId(aux.getId());
        this.carritoDao.save(carrito);
    }
    
    public void eliminar(Integer codigo) {
        Carrito carrito = this.carritoDao.findOne("codigo", codigo);
        this.carritoDao.delete(carrito);
    }
}
