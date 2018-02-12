/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.mongo.web;





import ec.edu.espe.distribuidas.prosth.mongo.model.Proveedor;
import ec.edu.espe.distribuidas.prosth.mongo.service.ProveedorService;
import ec.edu.espe.distribuidas.prosth.mongo.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Protesis Store Corp.
 */
@Named
@ViewScoped
public class ProveedorBean extends BaseBean implements Serializable {

    private List<Proveedor> proveedores;

    private Proveedor proveedor;

    private Proveedor proveedorSel;

    @Inject
    private ProveedorService proveedorService;

    @PostConstruct
    public void init() {
        this.proveedores = this.proveedorService.obtenerTodos();
        this.proveedor = new Proveedor();
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    @Override
    public void agregar() {
        this.proveedor = new Proveedor();
        super.agregar();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.proveedor = new Proveedor();
        this.proveedor.setCodigo(this.proveedorSel.getCodigo());
        this.proveedor.setNombre(this.proveedorSel.getNombre());
        this.proveedor.setDescripcion(this.proveedorSel.getDescripcion());
    }
    
    public void eliminar() {
        try {
            this.proveedorService.eliminar(this.proveedorSel.getCodigo());
            this.proveedores = this.proveedorService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.proveedorSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.proveedor = this.proveedorSel;
    }

    public void cancelar() {
        super.reset();
        this.proveedor = new Proveedor();
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.proveedorService.crear(this.proveedor);
                FacesUtil.addMessageInfo("Se agregó el Proveedor: " + this.proveedor.getNombre());
            } else {
                this.proveedorService.modificar(this.proveedor);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Proveedor: " + this.proveedor.getNombre());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.proveedor = new Proveedor();
        this.proveedores = this.proveedorService.obtenerTodos();
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Proveedor getProveedorSel() {
        return proveedorSel;
    }

    public void setProveedorSel(Proveedor proveedorSel) {
        this.proveedorSel = proveedorSel;
    }

    public ProveedorService getProveedorService() {
        return proveedorService;
    }

    public void setProveedorService(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }
}
