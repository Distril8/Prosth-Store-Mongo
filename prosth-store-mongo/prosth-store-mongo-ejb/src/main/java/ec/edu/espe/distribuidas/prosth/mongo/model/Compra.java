/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.mongo.model;

import ec.edu.espe.distribuidas.nosql.mongo.BaseEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;


/**
 *
 * @author Protesis Store Corp.
 */
@Entity(noClassnameStored = true, value = "compra")
public class Compra extends BaseEntity {

    @Reference
    private Proveedor proveedor;
    private Date fecha;
    private BigDecimal valorTotal;


    public Compra() {
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

  @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.id != null ? super.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((super.id == null && other.id != null) || (super.id != null && !super.id.equals(super.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compra{" + "proveedor=" + proveedor + ", fecha=" + fecha + ", valorTotal=" + valorTotal + '}';
    }

    
}
