package com.mintic.seguridadg4.Repositorios;

import com.mintic.seguridadg4.modelos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepoUsuario extends MongoRepository<Usuario, String> {
}
