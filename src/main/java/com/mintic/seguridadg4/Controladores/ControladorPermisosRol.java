package com.mintic.seguridadg4.Controladores;

import com.mintic.seguridadg4.Repositorios.RepoPermiso;
import com.mintic.seguridadg4.Repositorios.RepoPermisosRol;
import com.mintic.seguridadg4.Repositorios.RepoRol;
import com.mintic.seguridadg4.modelos.Permiso;
import com.mintic.seguridadg4.modelos.PermisosRol;
import com.mintic.seguridadg4.modelos.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/permisos-rol")

public class ControladorPermisosRol {


    @Autowired
    private RepoPermisosRol miRepoPermisosRol;

    @Autowired
    private RepoPermiso miRepoPermiso;

    @Autowired
    private RepoRol miRepoRol;

    @GetMapping("")
    public List<PermisosRol> index(){
        return miRepoPermisosRol.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("rol/{id_rol}/permiso/{id_permiso}")
    public PermisosRol create(@PathVariable String id_rol, @PathVariable String id_permiso) {
        PermisosRol permisosrol = new PermisosRol();
        Rol rol = this.miRepoRol.findById(id_rol).orElse(null);
        Permiso permiso = this.miRepoPermiso.findById(id_permiso).orElse(null);
        if (rol != null && permiso != null){
            permisosrol.setRol(rol);
            permisosrol.setPermiso(permiso);
            return this.miRepoPermisosRol.save(permisosrol);
        }else {
            return null;
        }

    }

    @PutMapping("/{id_permiso_rol}/rol/{id_rol}/permiso/{id_permiso}")
    public PermisosRol update(@PathVariable String id_permiso_rol, @PathVariable String id_rol, @PathVariable String id_permiso){
        PermisosRol permisosRol = this.miRepoPermisosRol.findById(id_permiso_rol).orElse(null);
        Rol rol = this.miRepoRol.findById(id_rol).orElse(null);
        Permiso permiso = this.miRepoPermiso.findById(id_permiso).orElse(null);

        if (permisosRol != null && rol != null && permiso != null){
            permisosRol.setRol(rol);
            permisosRol.setPermiso(permiso);
            return  this.miRepoPermisosRol.save(permisosRol);
        }else {
            return null;
        }

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public  void delete(@PathVariable String id){
        PermisosRol permisosRol = this.miRepoPermisosRol.findById(id).orElse(null);
        if (permisosRol != null){
            this.miRepoPermisosRol.delete(permisosRol);
        }
    }

    @GetMapping("{id}")
    public PermisosRol show(@PathVariable String id){
        PermisosRol permisosRol = this.miRepoPermisosRol.findById(id).orElse(null);
        return permisosRol;
    }

}


