/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.prosth.mongo.web;

import ec.edu.espe.distribuidas.prosth.mongo.model.Usuario;
import ec.edu.espe.distribuidas.prosth.mongo.service.AutenticacionService;
import ec.edu.espe.distribuidas.prosth.mongo.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hendrix
 */
@Named
@ViewScoped
public class IndexBean implements Serializable{
    
    private String codigoUsuario;
    private String clave;
    
    @Inject
    private AutenticacionService autenticacionService;
    @Inject 
    private UsuarioSesionBean usuarioSessionBean;
    
    public String login() {
        List<Usuario> usuarios = this.autenticacionService.buscarPorMail(this.codigoUsuario);
        Usuario usuario = usuarios.get(0);
        if (usuario!=null) {
            this.usuarioSessionBean.setUsuario(usuario);
            if(usuario.getCodigo() == 1){
                return "menuPrincipal";
            }else{
                return "indexU";
            }
            
        } else {
            FacesUtil.addMessageError(null, "Los datos ingresados son incorrectos");
            return "index";
        }
    }
    
    public String logout() {
        this.usuarioSessionBean.setUsuario(null);
        return "index";
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }    
}
