package com.mintic.seguridadg4.Controladores;

import com.mintic.seguridadg4.Repositorios.RepoRol;
import com.mintic.seguridadg4.modelos.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class ControladorRol {

    @Autowired
    private RepoRol miRepoRol;

    @GetMapping("")
    public List<Rol> index(){
        return this.miRepoRol.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Rol create(@RequestBody Rol infoRol){
        try {
        return this.miRepoRol.save(infoRol);
        }catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }

    @PutMapping("{id}")
    public Rol update(@PathVariable String id, @RequestBody Rol infoRol){
        Rol rol = this.miRepoRol.findById(id).orElse(null);
        if (rol != null){
            rol.setNombre(infoRol.getNombre());
        rol.setDescripcion(infoRol.getDescripcion());
        return this.miRepoRol.save(rol);
    }else{
        return null;
    }
}

@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping("{id}")
public void delete(@PathVariable String id){
    Rol rol = this.miRepoRol.findById(id).orElse(null);
    if (rol != null){
        this.miRepoRol.delete(rol);
    }
}

@GetMapping("{id}")
public Rol show(@PathVariable String id){
    Rol rol = this.miRepoRol.findById(id).orElse(null);
    return rol;
    }
}