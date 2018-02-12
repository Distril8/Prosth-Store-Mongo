/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.service;

import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.prosth.mongo.dao.CategoriaDAO;
import ec.edu.espe.distribuidas.prosth.mongo.model.Categoria;
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
public class CategoriaService {

    @EJB
    private MongoPersistence mp;
    private CategoriaDAO categoriaDao;
    
    @PostConstruct
    public void init() {
        this.categoriaDao = new CategoriaDAO(Categoria.class, mp.context());
    }

    public List<Categoria> obtenerTodos() {
        return this.categoriaDao.find().asList();
    }

    public Categoria obtenerPorCodigo(Integer codigo) {
        return this.categoriaDao.findOne("codigo", codigo);
    }

    public void crear(Categoria categoria) {
        this.categoriaDao.save(categoria);
    }

    public void modificar(Categoria categoria) {
        Categoria aux = this.categoriaDao.findOne("codigo", categoria.getCodigo());
        categoria.setId(aux.getId());
        this.categoriaDao.save(categoria);
    }

    public void eliminar(Integer codigo) {
        Categoria categoria = this.categoriaDao.findOne("codigo", codigo);
        this.categoriaDao.delete(categoria);
    }
}

