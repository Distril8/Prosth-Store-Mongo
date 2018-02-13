/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.dao;

import ec.edu.espe.distribuidas.prosth.mongo.model.Categoria;
import ec.edu.espe.distribuidas.prosth.mongo.model.Producto;
import ec.edu.espe.distribuidas.prosth.mongo.service.CategoriaService;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author js_cm
 */
public class ProductoDAO extends BasicDAO<Producto, ObjectId> {
    
    public ProductoDAO(Class<Producto> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
    
    public List<Producto> findbyCategoria (Integer Codigo){
        CategoriaService categoriaPorCodigo = null;
        Categoria categoria = categoriaPorCodigo.obtenerPorCodigo(Codigo);
        Query<Producto> q = getDatastore().createQuery(Producto.class);
        q.criteria("categoria").equal(categoria);
        return q.asList();
    }
}
