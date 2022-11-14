package com.mintic.seguridadg4.Controladores;

import com.mintic.seguridadg4.Repositorios.RepoPermiso;
import com.mintic.seguridadg4.modelos.Permiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/permisos")
public class ControladorPermiso {

    @Autowired
    private RepoPermiso miRepoPermiso;

    @GetMapping("")
    public List<Permiso> index(){
        return  this.miRepoPermiso.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Permiso created(@RequestBody Permiso infoPermiso){
        return this.miRepoPermiso.save(infoPermiso);
    }

    @PutMapping("{id}")
    public Permiso update(@PathVariable String id, @RequestBody Permiso infoPermiso){
        Permiso permiso = this.miRepoPermiso.findById(id).orElse(null);
        if(permiso != null){
            permiso.set_url((infoPermiso.get_url()));
            permiso.set_metodo(infoPermiso.get_metodo());
            return this.miRepoPermiso.save(permiso);
        }else {
            return null;
            }
        }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Permiso permiso =this.miRepoPermiso.findById(id).orElse(null);
        if (permiso!= null){
            this.miRepoPermiso.delete(permiso);
        }
    }
    @GetMapping("{id}")
    public Permiso show(@PathVariable String id){
        Permiso permiso = this.miRepoPermiso.findById(id).orElse(null);
        return permiso;
    }

}
