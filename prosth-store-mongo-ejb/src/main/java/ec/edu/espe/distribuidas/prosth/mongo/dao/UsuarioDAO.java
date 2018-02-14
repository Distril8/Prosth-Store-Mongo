/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.dao;

import ec.edu.espe.distribuidas.prosth.mongo.model.Usuario;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author js_cm
 */
public class UsuarioDAO extends BasicDAO<Usuario, ObjectId>  {
    public UsuarioDAO(Class<Usuario> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }
    
    public List<Usuario> findbyMail (String mail){
        Query<Usuario> q = getDatastore().createQuery(Usuario.class);
        q.criteria("email").equal(mail);
        return q.asList();
    }
}
