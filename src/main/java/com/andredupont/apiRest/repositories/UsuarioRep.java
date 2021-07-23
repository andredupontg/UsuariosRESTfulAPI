package com.andredupont.apiRest.repositories;

import com.andredupont.apiRest.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRep extends CrudRepository<Usuario, Long> {
    public abstract ArrayList<Usuario> findByPrioridad(int prioridad);
}
