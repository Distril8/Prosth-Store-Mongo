/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.mongo.web;




import ec.edu.espe.distribuidas.prosth.mongo.model.Camion;
import ec.edu.espe.distribuidas.prosth.mongo.model.Conductor;
import ec.edu.espe.distribuidas.prosth.mongo.service.CamionService;
import ec.edu.espe.distribuidas.prosth.mongo.service.ConductorService;
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
public class CamionBean extends BaseBean implements Serializable {

    private List<Conductor> conductores;
    private List<Camion> camiones;
    private Camion camion;

    private Camion camionSel;

    @Inject
    private ConductorService conductorService;
    @Inject
    private CamionService camionService;
    @PostConstruct
    public void init() {
        this.camiones = this.camionService.obtenerTodos();
        this.camion = new Camion();
        this.conductores = this.conductorService.obtenerTodos();
    }
    @Override
    public void agregar() {
        this.camion = new Camion();
        super.agregar();
        
    }

    @Override
    public void modificar() {
        super.modificar();
        this.camion = new Camion();
       
        this.camion.setCodigo(this.camionSel.getCodigo());
        this.camion.setConductor(this.camionSel.getConductor());
        this.camion.setPlaca(this.camionSel.getPlaca());
        this.camion.setModelo(this.camionSel.getModelo());
        this.camion.setColor(this.camionSel.getColor());
        this.camion.setMarca(this.camionSel.getMarca());
        this.camion.setNombreConductor(this.camionSel.getNombreConductor());
    }
    
    public void eliminar() {
        try {
            this.camionService.eliminar(this.camionSel.getCodigo());
            this.camiones =  this.camionService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.camionSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.camion = this.camionSel;
    }

    public void cancelar() {
        super.reset();
        this.camion = new Camion();
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.camionService.crear(this.camion);
                FacesUtil.addMessageInfo("Se agregó el Camion: " + this.camion.getPlaca());
            } else {
                this.camionService.modificar(this.camion);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Camion: " + this.camion.getPlaca());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.camion = new Camion();
        this.camiones = this.camionService.obtenerTodos();
    }
    
    public void guardarConductor(){
        
        this.camion.setNombreConductor(this.camion.getNombreConductor());
    }

    public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }

    public List<Camion> getCamiones() {
        return camiones;
    }

    public void setCamiones(List<Camion> camiones) {
        this.camiones = camiones;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public Camion getCamionSel() {
        return camionSel;
    }

    public void setCamionSel(Camion camionSel) {
        this.camionSel = camionSel;
    }



    


}
