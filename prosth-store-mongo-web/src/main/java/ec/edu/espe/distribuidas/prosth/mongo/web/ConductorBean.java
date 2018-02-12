/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.mongo.web;



import ec.edu.espe.distribuidas.prosth.mongo.model.Conductor;
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
public class ConductorBean extends BaseBean implements Serializable {

    private List<Conductor> conductores;

    private Conductor conductor;

    private Conductor conductorSel;

    @Inject
    private ConductorService conductorService;

    @PostConstruct
    public void init() {
        this.conductores = this.conductorService.obtenerTodos();
        this.conductor = new Conductor();
    }

    public List<Conductor> getConductores() {
        return conductores;
    }



    @Override
    public void agregar() {
        this.conductor = new Conductor();
        super.agregar();
        
    }

    @Override
    public void modificar() {
        super.modificar();
        this.conductor = new Conductor();
        this.conductor.setCodigo(this.conductorSel.getCodigo());
        this.conductor.setNombre(this.conductorSel.getNombre());
        this.conductor.setApellido(this.conductorSel.getApellido());
        this.conductor.setCi(this.conductorSel.getCi());
        this.conductor.setFechaNace(this.conductorSel.getFechaNace());
        this.conductor.setLicencia(this.conductorSel.getLicencia());
    }
    
    public void eliminar() {
        try {
            this.conductorService.eliminar(this.conductorSel.getCodigo());
            this.conductor = (Conductor) this.conductorService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.conductorSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.conductor = this.conductorSel;
    }

    public void cancelar() {
        super.reset();
        this.conductor = new Conductor();
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.conductorService.crear(this.conductor);
                FacesUtil.addMessageInfo("Se agregó el Conductor: " + this.conductor.getNombre() + this.conductor.getApellido());
            } else {
                this.conductorService.modificar(this.conductor);
                FacesUtil.addMessageInfo("Se modific\u00f3 el Conductor: " + this.conductor.getNombre());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.conductor = new Conductor();
        this.conductores = this.conductorService.obtenerTodos();
    }
    
    public ConductorService getConductorService() {
        return conductorService;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public Conductor getConductorSel() {
        return conductorSel;
    }

    public void setConductorSel(Conductor conductorSel) {
        this.conductorSel = conductorSel;
    }



}
