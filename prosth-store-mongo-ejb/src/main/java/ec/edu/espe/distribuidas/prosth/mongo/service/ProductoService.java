/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.prosth.mongo.dao.ProductoDAO;
import ec.edu.espe.distribuidas.prosth.mongo.model.Producto;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.bson.Document;

/**
 *
 * @author js_cm
 */
@Stateless
@LocalBean
public class ProductoService {
    @EJB
    private MongoPersistence mp;
    private ProductoDAO productoDao;
    
    @PostConstruct
    public void init() {
        this.productoDao = new ProductoDAO(Producto.class, mp.context());
    }

    public List<Producto> obtenerTodos() {
        return this.productoDao.find().asList();
    }
    
   

    public Producto obtenerPorCodigo(Integer codigo) {
        return this.productoDao.findOne("codigo", codigo);
    }
    
    public List<Producto> buscarPorTipo(Integer codigo) {
        return this.productoDao.findbyCategoria(codigo);
    }

    public void crear(Producto producto) {
        
        this.productoDao.save(producto);
    }

    public void modificar(Producto producto) {
        Producto aux = this.productoDao.findOne("codigo", producto.getCodigo());
        producto.setId(aux.getId());
        this.productoDao.save(producto);
    }

    public void eliminar(Integer codigo) {
        Producto producto = this.productoDao.findOne("codigo", codigo);
        this.productoDao.delete(producto);
    }
}
