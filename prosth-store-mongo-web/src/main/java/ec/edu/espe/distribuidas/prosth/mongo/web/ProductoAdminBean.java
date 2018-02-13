/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Hendrix
 */
@Named
@ViewScoped
public class ProductoAdminBean extends BaseBean implements Serializable {

    private String filtro;
    private Integer categoriaBusqueda;
    private boolean enBusquedaPorTipo;
    private List<Categoria> categorias;

    private List<Producto> productos;
    private Producto producto;
    private Producto productoSel;

    @Inject
    private CategoriaService categoriaService;
    @Inject
    private ProductoService productoService;

    @PostConstruct
    public void init() {
        this.categorias = this.categoriaService.obtenerTodos();
        this.productos = this.productoService.obtenerTodos();
        this.producto = new Producto();
    }

    public void cambiarFiltro() {
        this.enBusquedaPorTipo = !this.enBusquedaPorTipo;
        System.out.println("Valor para enbusqueda: " + this.enBusquedaPorTipo);
    }

    public void buscar() {
        this.productos = this.productoService.buscarPorTipo(this.categoriaBusqueda);
    }

    @Override
    public void modificar() {
        super.modificar();
        this.producto = new Producto();
        this.producto.setCodigo(this.productoSel.getCodigo());
        this.producto.setNombre(this.productoSel.getNombre());
        this.producto.setMarca(this.productoSel.getMarca());
        this.producto.setDescripcion(this.productoSel.getDescripcion());
        this.producto.setPrecio(this.productoSel.getPrecio());
        this.producto.setStock(this.productoSel.getStock());
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
            if (this.enModificar) {
                this.productoService.crear(this.producto);
                FacesUtil.addMessageInfo("Se Modifico el Producto: " + this.producto.getNombre());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.producto = new Producto();
        this.productos = this.productoService.obtenerTodos();
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public Integer getCategoriaBusqueda() {
        return categoriaBusqueda;
    }

    public void setCategoriaBusqueda(Integer categoriaBusqueda) {
        this.categoriaBusqueda = categoriaBusqueda;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
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

    public boolean isEnBusquedaPorTipo() {
        return enBusquedaPorTipo;
    }

}
