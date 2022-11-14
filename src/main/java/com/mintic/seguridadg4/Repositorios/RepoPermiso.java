package com.mintic.seguridadg4.Repositorios;

import com.mintic.seguridadg4.modelos.Permiso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoPermiso extends MongoRepository<Permiso, String> {
}
