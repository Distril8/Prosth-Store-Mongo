/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.mongo.web;

import ec.edu.espe.distribuidas.prosth.mongo.model.Compra;
import ec.edu.espe.distribuidas.prosth.mongo.model.Detalle;
import ec.edu.espe.distribuidas.prosth.mongo.model.Producto;
import ec.edu.espe.distribuidas.prosth.mongo.service.CompraService;
import ec.edu.espe.distribuidas.prosth.mongo.service.DetalleService;
import ec.edu.espe.distribuidas.prosth.mongo.service.ProductoService;
import ec.edu.espe.distribuidas.prosth.mongo.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
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
public class DetalleBean extends BaseBean implements Serializable {

    private List<Detalle> detalles;
    private List<Producto> productos;
    private List<Producto> productoSels;
    long totalSub;
    private Detalle detalle;
    private Detalle detalleSel;

    private Producto producto;
    private Producto productoSel;

    @Inject
    private DetalleService detalleService;

    @Inject
    private ProductoService productoService;

    @PostConstruct
    public void init() {
        this.detalles = this.detalleService.obtenerTodos();
        this.productos = this.productoService.obtenerTodos();
        this.producto = new Producto();
        this.detalle = new Detalle();
    }

    @Override
    public void agregar() {
        this.detalle = new Detalle();
        super.agregar();

    }

//    @Override
//    public void modificar() {
//        super.modificar();
//        this.detalle = new Detalle();
//        this.detalle.setCodigo(this.compraSel.getCodigo());
//        this.detalle.setNombre(this.compraSel.getNombre());
//        this.detalle.setApellido(this.compraSel.getApellido());
//        this.detalle.setCi(this.compraSel.getCi());
//        this.detalle.setFechaNace(this.compraSel.getFechaNace());
//        this.detalle.setLicencia(this.compraSel.getLicencia());
//    }
    public void eliminar() {
        try {
            this.detalleService.eliminar(this.detalleSel.getCodigo());
            this.detalles = this.detalleService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.detalleSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    public void updateVal() {
    }

    public void cancelar() {
        super.reset();
        this.detalle = new Detalle();
    }

    public void nuevo() {
        //super.reset();
        //this.compra = new Compra();
    }

    public long getSub(long canProductos, long preProducto) {
        long sub = canProductos * preProducto;

        totalSub += sub;
        System.out.printf("Sub %d \nTotalSub: %d", sub, totalSub);
        return sub;
    }

    public void guardar(Integer cantidad) {
        Random random = new Random();
        try {
            this.detalle.setCodigo(random.nextInt(40));
            this.detalle.setCantidad(cantidad);
            this.detalleService.crear(this.detalle);
            FacesUtil.addMessageInfo("Se Realizo la compra: " + this.detalle.getCodigo());

        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.detalle = new Detalle();
        this.detalles = this.detalleService.obtenerTodos();
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProductoSel() {
        return productoSel;
    }

    public void setProductoSel(Producto productoSel) {
        this.productoSel = productoSel;
    }

    public Detalle getDetalleSel() {
        return detalleSel;
    }

    public void setDetalleSel(Detalle detalleSel) {
        this.detalleSel = detalleSel;
    }

    public long getTotalSub() {
        return totalSub;
    }

    public void setTotalSub(long totalSub) {
        this.totalSub = totalSub;
    }

}
