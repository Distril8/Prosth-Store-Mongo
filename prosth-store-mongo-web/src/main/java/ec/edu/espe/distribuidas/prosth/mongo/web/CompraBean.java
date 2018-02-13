/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.mongo.web;



import static com.mongodb.client.model.Aggregates.skip;
import ec.edu.espe.distribuidas.prosth.mongo.model.Compra;
import ec.edu.espe.distribuidas.prosth.mongo.model.Proveedor;
import ec.edu.espe.distribuidas.prosth.mongo.service.CompraService;
import ec.edu.espe.distribuidas.prosth.mongo.service.ProveedorService;
import ec.edu.espe.distribuidas.prosth.mongo.web.util.FacesUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Protesis Store Corp.
 */
@Named
@ViewScoped
public class CompraBean extends BaseBean implements Serializable {

    private List<Compra> compras;
    private List<Proveedor> proveedores;
    private Integer proveedorBusqueda;

    private Compra compra;
    private Proveedor proveedor;
    private Proveedor proveedorSel;
    private Compra compraSel;

    @Inject
    private CompraService compraService;
    @Inject
    private ProveedorService proveedorService;

    @PostConstruct
    public void init() {
        this.compras = this.compraService.obtenerTodos();
        this.proveedores = this.proveedorService.obtenerTodos();
        this.compra = new Compra();
        this.proveedor = new Proveedor();
    }

   

    @Override
    public void agregar() {
        this.compra = new Compra();
        super.agregar();
        
    }

 
    public void detalle() {
        this.compra = new Compra();
 
        
    }
    
    public Date fecha(){
        Date fecha = new Date();
        return fecha;
    }
//    @Override
//    public void modificar() {
//        super.modificar();
//        this.compra = new Conductor();
//        this.compra.setCodigo(this.compraSel.getCodigo());
//        this.compra.setNombre(this.compraSel.getNombre());
//        this.compra.setApellido(this.compraSel.getApellido());
//        this.compra.setCi(this.compraSel.getCi());
//        this.compra.setFechaNace(this.compraSel.getFechaNace());
//        this.compra.setLicencia(this.compraSel.getLicencia());
//    }
    
//    public void eliminar() {
//        try {
//            this.conductorService.eliminar(this.conductorSel.getCodigo());
//            this.conductor = (Conductor) this.conductorService.obtenerTodos();
//            FacesUtil.addMessageInfo("Se elimino el registro ");
//            this.conductorSel = null;
//        } catch (Exception e) {
//            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
//        }
//    }

    public void cancelar() {
        super.reset();
        this.compra = new Compra();
    }
    
    public void nuevo() {
        //super.reset();
        //this.compra = new Compra();
    }


    public void guardar() {
        try {
            if (this.enAgregar) {
                this.compraService.crear(this.compra);
                FacesUtil.addMessageInfo("Se Realizo la compra: " + this.compra.getCodigo());
            } else {
                this.compraService.modificar(this.compra);
                FacesUtil.addMessageInfo("Se modific\u00f3 la compra: " + this.compra.getCodigo());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.compra = new Compra();
        this.compras = this.compraService.obtenerTodos();
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Compra getCompraSel() {
        return compraSel;
    }

    public void setCompraSel(Compra compraSel) {
        this.compraSel = compraSel;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
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

    public Integer getProveedorBusqueda() {
        return proveedorBusqueda;
    }

    public void setProveedorBusqueda(Integer proveedorBusqueda) {
        this.proveedorBusqueda = proveedorBusqueda;
    }

    
    



}
