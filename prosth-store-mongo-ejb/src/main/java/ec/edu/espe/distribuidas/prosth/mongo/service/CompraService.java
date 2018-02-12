/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.prosth.mongo.dao.CompraDAO;
import ec.edu.espe.distribuidas.prosth.mongo.model.Categoria;
import ec.edu.espe.distribuidas.prosth.mongo.model.Compra;
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
public class CompraService {

    @EJB
    private MongoPersistence mp;
    private CompraDAO compraDao;
    
    @PostConstruct
    public void init() {
        this.compraDao = new CompraDAO(Compra.class, mp.context());
    }

    public List<Compra> obtenerTodos() {
        return this.compraDao.find().asList();
    }

    public Compra obtenerPorCodigo(Integer codigo) {
        return this.compraDao.findOne("codigo", codigo);
    }

    public void crear(Compra compra) {
        this.compraDao.save(compra);
    }

    public void modificar(Compra compra) {
        Compra aux = this.compraDao.findOne("codigo", compra.getCodigo());
        compra.setId(aux.getId());
        this.compraDao.save(compra);
    }

    public void eliminar(Integer codigo) {
        Compra compra = this.compraDao.findOne("codigo", codigo);
        this.compraDao.delete(compra);
    }
}

