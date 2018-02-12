/*

 */
package ec.edu.espe.distribuidas.prosth.mongo.service;


import ec.edu.espe.distribuidas.nosql.mongo.MongoPersistence;
import ec.edu.espe.distribuidas.prosth.mongo.dao.ProveedorDAO;
import ec.edu.espe.distribuidas.prosth.mongo.model.Proveedor;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Hades Cruise Corp.
 */
@Stateless
@LocalBean
public class ProveedorService {

    @EJB
    private MongoPersistence mp;
    private ProveedorDAO proveedorDao;
    
    @PostConstruct
    public void init() {
        this.proveedorDao = new ProveedorDAO(Proveedor.class, mp.context());
    }

    public List<Proveedor> obtenerTodos() {
        return this.proveedorDao.find().asList();
    }

    public Proveedor obtenerPorCodigo(Integer codigo) {
        return this.proveedorDao.findOne("codigo", codigo);
    }

    public void crear(Proveedor proveedor) {
        this.proveedorDao.save(proveedor);
    }

    public void modificar(Proveedor proveedor) {
        this.proveedorDao.save(proveedor);
    }

    public void eliminar(Integer codigo) {
        Proveedor proveedor = this.proveedorDao.findOne("codigo", codigo);
        this.proveedorDao.delete(proveedor);
    }
}
