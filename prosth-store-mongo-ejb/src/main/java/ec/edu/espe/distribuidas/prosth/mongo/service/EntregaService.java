/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.prosth.mongo.dao.EntregaDAO;
import ec.edu.espe.distribuidas.prosth.mongo.model.Entrega;
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
public class EntregaService {
    @EJB
    private MongoPersistence mp;
    private EntregaDAO entregaDao;
    
    @PostConstruct
    public void init() {
        this.entregaDao = new EntregaDAO(Entrega.class, mp.context());
    }

    public List<Entrega> obtenerTodos() {
        return this.entregaDao.find().asList();
    }
    
    public Entrega obtenerPorCodigo(Integer codigo) {
        return this.entregaDao.findOne("codigo", codigo);
    }
    
//    public List<Entrega> buscarPorTipo(Integer codigo) {
//        return this.productoDao.findbyCategoria(codigo);
//    }

    public void crear(Entrega entrega) {
        
        this.entregaDao.save(entrega);
    }

    public void modificar(Entrega entrega) {
        Entrega aux = this.entregaDao.findOne("codigo", entrega.getCodigo());
        entrega.setId(aux.getId());
        this.entregaDao.save(entrega);
    }

    public void eliminar(Integer codigo) {
        Entrega entrega = this.entregaDao.findOne("codigo", codigo);
        this.entregaDao.delete(entrega);
    }
}
