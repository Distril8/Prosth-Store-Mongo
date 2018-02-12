/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.model;

import ec.edu.espe.distribuidas.nosql.mongo.BaseEntity;
import ec.edu.espe.distribuidas.prosth.mongo.enums.ModoPagoEnum;
import java.util.Objects;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;

/**
 *
 * @author hendrix
 */
@Entity(noClassnameStored = true, value = "modo_pago")
public class ModoPago extends BaseEntity{
    
    @Indexed(options = @IndexOptions(name = "modoPago_codigoUIdx", unique = true))
    private Integer codigo;
    private String descripcion;
    private ModoPagoEnum tipo;


    public ModoPago() {
    }

    public ModoPago(Integer codigo) {
        this.codigo = codigo;
    }

    public ModoPagoEnum getTipo() {
        return tipo;
    }

    public void setTipo(ModoPagoEnum tipo) {
        this.tipo = tipo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "codigo=" + codigo + ", descripcion=" + descripcion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ModoPago other = (ModoPago) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    
    
}
