/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.dao;


import ec.edu.espe.distribuidas.prosth.mongo.model.Entrega;



import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author js_cm
 */
public class EntregaDAO extends BasicDAO<Entrega, ObjectId> {
    
    public EntregaDAO(Class<Entrega> objectEntity, Datastore ds) {
        super(objectEntity, ds);
    }

//    
//    public List<Producto> findbyCategoria (Integer Codigo){
//        CategoriaService categoriaPorCodigo = null;
//        Categoria categoria = categoriaPorCodigo.obtenerPorCodigo(Codigo);
//        Query<Producto> q = getDatastore().createQuery(Producto.class);
//        q.criteria("categoria").equal(categoria);
//        return q.asList();
//    }

//     public void ProductoByCategoria(String categoria){
//        // We return documents with the find method by setting a <b>criteria</ b> element equal to the cuisine.
//        // Devolvemos los documentos con el método find estableciendo un <b>criteria</b> igual para el elemento cuisine.
//        FindIterable<Document> iterable = ds.getCollection("producto").find(new Document("categoria", categoria));
//        // Iterate the results and apply a block to each resulting document.
//        // Iteramos los resultados y aplicacimos un bloque para cada documento.
//     }

}
