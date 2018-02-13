/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.dao;

import ec.edu.espe.distribuidas.prosth.mongo.model.Detalle;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author js_cm
 */
public class DetalleDAO extends BasicDAO<Detalle, ObjectId> {
    
    public DetalleDAO(Class<Detalle> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
}
