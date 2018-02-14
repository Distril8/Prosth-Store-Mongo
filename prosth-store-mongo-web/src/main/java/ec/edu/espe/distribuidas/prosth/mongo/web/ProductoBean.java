/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.mongo.web;





import ec.edu.espe.distribuidas.prosth.mongo.model.Categoria;
import ec.edu.espe.distribuidas.prosth.mongo.model.Producto;
import ec.edu.espe.distribuidas.prosth.mongo.service.CategoriaService;
import ec.edu.espe.distribuidas.prosth.mongo.service.ProductoService;
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
public class ProductoBean extends BaseBean implements Serializable {

    private List<Producto> productos;
    private List<Categoria> categorias;
     private Integer categoriaBusqueda;
    private Producto producto;
     private List<Producto> productosSel;
    private Producto productoSel;
    
    @Inject
    private ProductoService productoService;

    @Inject
    private CategoriaService categoriaService;
    
    @PostConstruct
    public void init() {
        this.productos = this.productoService.obtenerTodos();
        this.categorias = this.categoriaService.obtenerTodos();
        this.producto = new Producto();
    }

    @Override
    public void agregar() {
        this.producto = new Producto();
        super.agregar();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.producto = new Producto();
        this.producto.setCodigo(this.productoSel.getCodigo());
        this.producto.setNombre(this.productoSel.getNombre());
        this.producto.setMarca(this.productoSel.getMarca());
        this.producto.setPrecio(this.productoSel.getPrecio());
        this.producto.setPrecioVenta(this.productoSel.getPrecioVenta());
        this.producto.setStock(this.productoSel.getStock());
        this.producto.setDescripcion(this.productoSel.getDescripcion());
        this.producto.setCantidad(this.productoSel.getCantidad());
        this.producto.setImagen(this.productoSel.getImagen());
        this.producto.setNombreCategoria(this.productoSel.getNombreCategoria());
    }
    
    public void buscar() {
        Categoria categoriaNueva = this.categoriaService.obtenerPorCodigo(this.categoriaBusqueda);
        this.productos = this.productoService.buscarPorTipo(categoriaNueva.getNombre());
        System.out.println("Valor para categoriaBusqueda: " + categoriaNueva.getNombre());
    }

    
    public void eliminar() {
        try {
            this.productoService.eliminar(this.productoSel.getCodigo());
            this.productos = this.productoService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.productoSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }



    public void cancelar() {
        super.reset();
        this.producto = new Producto();
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.productoService.crear(this.producto);
                FacesUtil.addMessageInfo("Se agregó el Producto: " + this.producto.getNombre());
            } else {
                this.productoService.modificar(this.producto);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Producto: " + this.producto.getNombre());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.producto = new Producto();
        this.productos = this.productoService.obtenerTodos();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
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

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Producto> getProductosSel() {
        return productosSel;
    }

    public void setProductosSel(List<Producto> productosSel) {
        this.productosSel = productosSel;
    }

    public Integer getCategoriaBusqueda() {
        return categoriaBusqueda;
    }

    public void setCategoriaBusqueda(Integer categoriaBusqueda) {
        this.categoriaBusqueda = categoriaBusqueda;
    }

   
}
