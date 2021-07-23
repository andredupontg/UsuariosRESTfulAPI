package com.andredupont.apiRest.services;

import com.andredupont.apiRest.models.Usuario;
import com.andredupont.apiRest.repositories.UsuarioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioSrv {
    @Autowired
    UsuarioRep usuarioRep;

    public ArrayList<Usuario> obtenerUsuarios(){
        return (ArrayList<Usuario>) usuarioRep.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRep.save(usuario);
    }

    public Optional<Usuario> obtenerPorId(Long id){
        return usuarioRep.findById(id);
    }

    public ArrayList<Usuario> obtenerPorPrioridad(int prioridad){
        return usuarioRep.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id){
        try {
            usuarioRep.deleteById(id);
            return true;
        } catch (Exception err){
            return false;
        }
    }
}
