package com.mintic.seguridadg4.Repositorios;

import com.mintic.seguridadg4.modelos.PermisosRol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoPermisosRol extends MongoRepository<PermisosRol, String> {
}
