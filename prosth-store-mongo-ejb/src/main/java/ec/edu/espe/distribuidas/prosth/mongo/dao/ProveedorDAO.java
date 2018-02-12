/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.dao;


import ec.edu.espe.distribuidas.prosth.mongo.model.Proveedor;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author
 */
public class ProveedorDAO extends BasicDAO<Proveedor, ObjectId> {
    
    public ProveedorDAO(Class<Proveedor> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
    
}
