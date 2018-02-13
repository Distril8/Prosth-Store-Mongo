/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.mongo.model;

import ec.edu.espe.distribuidas.nosql.mongo.BaseEntity;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;


/**
 *
 * @author Protesis Store Corp.
 */
@Entity(noClassnameStored = true, value = "categoria")
public class Categoria extends BaseEntity{

    @Indexed(options = @IndexOptions(name = "categoria_codigoUIdx", unique = true))
    private Integer codigo;
    private String nombre;
    private String descripcion;
    
    public Categoria(Integer cod) {
        this.codigo = cod;
    }

    public Categoria() {
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.prosth.mongo.model.Categoria[ cod=" + codigo + " ]";
    }
}
