/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.dao;

import ec.edu.espe.distribuidas.prosth.mongo.model.TipoUsuario;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author js_cm
 */
public class TipoUsuarioDAO extends BasicDAO<TipoUsuario, ObjectId> {
    public TipoUsuarioDAO(Class<TipoUsuario> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
}
