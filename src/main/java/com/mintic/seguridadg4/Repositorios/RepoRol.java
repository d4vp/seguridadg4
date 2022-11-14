package com.mintic.seguridadg4.Repositorios;

import com.mintic.seguridadg4.modelos.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoRol extends MongoRepository<Rol, String> {
}
