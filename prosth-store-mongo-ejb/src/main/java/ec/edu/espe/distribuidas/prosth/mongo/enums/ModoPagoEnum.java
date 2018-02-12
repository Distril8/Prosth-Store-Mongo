/*
 * Hades Cruise
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Hades Cruise Corp.
 */
package ec.edu.espe.distribuidas.prosth.mongo.enums;

/**
 *
 * @author Hades Cruise Corp.
 */
public enum ModoPagoEnum {

    EFE("EFECTIVO"),
    CRE("CREDITO");

    private String texto;

    private ModoPagoEnum(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
