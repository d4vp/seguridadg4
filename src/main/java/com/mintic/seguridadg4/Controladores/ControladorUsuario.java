package com.mintic.seguridadg4.Controladores;

import com.mintic.seguridadg4.Repositorios.RepoRol;
import com.mintic.seguridadg4.Repositorios.RepoUsuario;
import com.mintic.seguridadg4.modelos.Rol;
import com.mintic.seguridadg4.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {

    @Autowired
    private RepoUsuario miRepoUsuario;

    @Autowired
    private RepoRol mirepoRol;
    @GetMapping("")
    public List<Usuario> index(){
        return this.miRepoUsuario.findAll();

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario create(@RequestBody Usuario infoUsuario){
        infoUsuario.setcontrasena(convertirSHA256(infoUsuario.getcontrasena()));
        return this.miRepoUsuario.save(infoUsuario);
    }

    @PutMapping("{id}")
    public Usuario update(@PathVariable String id, @RequestBody Usuario infoUsuario){
        Usuario usuario = this.miRepoUsuario.findById(id).orElse(null);
        if (usuario != null){
            usuario.setseudonimo(infoUsuario.getseudonimo());
            usuario.setcorreo(infoUsuario.getcorreo());
            usuario.setcontrasena(convertirSHA256(infoUsuario.getcontrasena()));
            return this.miRepoUsuario.save(usuario);
        }else {
            return null;
        }

    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Usuario usuario = miRepoUsuario.findById(id).orElse(null);
        if (usuario != null){
            this.miRepoUsuario.delete(usuario);
        }
    }

    @GetMapping("{id}")
    public Usuario show(@PathVariable String id){
        Usuario usuario = this.miRepoUsuario.findById(id).orElse(null);
        return usuario;
    }

    @PutMapping("{id_usuario}/rol/{id_rol}")
    public Usuario setRol(@PathVariable String id_usuario, @PathVariable String id_rol) {
        Usuario usuario = this.miRepoUsuario.findById(id_usuario).orElse(null);
        Rol rol = this.mirepoRol.findById(id_rol).orElse(null);

        if (usuario!= null && rol != null){
            usuario.setRol(rol);
            return this.miRepoUsuario.save(usuario);
        }else {
            return null;
        }
    }

   public String convertirSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();

        for(byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
}
