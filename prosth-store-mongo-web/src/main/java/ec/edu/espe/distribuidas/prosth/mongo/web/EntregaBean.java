/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.mongo.web;





import ec.edu.espe.distribuidas.prosth.mongo.model.Categoria;
import ec.edu.espe.distribuidas.prosth.mongo.model.Entrega;
import ec.edu.espe.distribuidas.prosth.mongo.model.Producto;
import ec.edu.espe.distribuidas.prosth.mongo.service.EntregaService;
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
public class EntregaBean extends BaseBean implements Serializable {

    private List<Entrega> entregas;
    //private List<Venta> ventas;
    private Integer ciudadBusqueda;
    private Entrega entrega;
    private Entrega entregaSel;
    
    @Inject
    private EntregaService entregaService;

    //@Inject
    //private VentaService ventaService;
    
    @PostConstruct
    public void init() {
        this.entregas = this.entregaService.obtenerTodos();
        //this.ventas = this.ventaService.obtenerTodos();
        this.entrega = new Entrega();
    }

    @Override
    public void agregar() {
        this.entrega = new Entrega();
        super.agregar();
    }
    
    @Override
    public void contacto() {
this.entrega = this.entregaSel;        
//this.entrega = new Entrega();
        super.contacto();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.entrega = new Entrega();
        this.entrega.setCodigo(this.entregaSel.getCodigo());
        this.entrega.setDescripcion(this.entregaSel.getDescripcion());
        this.entrega.setNombreConductor(this.entregaSel.getNombreConductor());
        this.entrega.setNombreUsuario(this.entregaSel.getNombreUsuario());
        this.entrega.setFechaSalida(this.entregaSel.getFechaSalida());
        this.entrega.setFechaLlegada(this.entregaSel.getFechaLlegada());
    }
    
    public void buscar() {
       // this.entregas = this.entregaService.buscarPorTipo(this.ciudadBusqueda);
    }

    
    public void eliminar() {
        try {
            this.entregaService.eliminar(this.entregaSel.getCodigo());
            this.entregas = this.entregaService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.entregaSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

@Override
    public void detalles() {
        super.detalles();
        this.entrega = this.entregaSel;
    }

    public void cancelar() {
        super.reset();
        this.entrega = new Entrega();
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.entregaService.crear(this.entrega);
                FacesUtil.addMessageInfo("Se agregó la entrega: " + this.entrega.getNombreUsuario());
            } else {
                this.entregaService.modificar(this.entrega);
                FacesUtil.addMessageInfo("Se modific\u00f3 la entrega: " + this.entrega.getNombreUsuario());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.entrega = new Entrega();
        this.entregas = this.entregaService.obtenerTodos();
    }

    public List<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<Entrega> entregas) {
        this.entregas = entregas;
    }

    public Integer getCiudadBusqueda() {
        return ciudadBusqueda;
    }

    public void setCiudadBusqueda(Integer ciudadBusqueda) {
        this.ciudadBusqueda = ciudadBusqueda;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Entrega getEntregaSel() {
        return entregaSel;
    }

    public void setEntregaSel(Entrega entregaSel) {
        this.entregaSel = entregaSel;
    }

   
}
