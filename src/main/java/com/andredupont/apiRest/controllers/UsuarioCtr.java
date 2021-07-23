package com.andredupont.apiRest.controllers;

import com.andredupont.apiRest.models.Usuario;
import com.andredupont.apiRest.services.UsuarioSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioCtr {
    @Autowired
    UsuarioSrv usuarioSrv;

    @GetMapping()
    public ArrayList<Usuario> obtenerUsuarios(){
        return usuarioSrv.obtenerUsuarios();
    }

    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        return this.usuarioSrv.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioSrv.obtenerPorId(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<Usuario> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") int prioridad){
        return this.usuarioSrv.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioSrv.eliminarUsuario(id);
        if(ok){
            return "Se eliminó el usuario con id " + id;
        } else{
            return "No pudo eliminar el usuario con id " + id;
        }
    }
}
