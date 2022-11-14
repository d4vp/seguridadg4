package com.mintic.seguridadg4.modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Usuario {
    @Id
    private String _id;
    private String seudonimo;
    private String correo;
    private String contrasena;

    @DBRef
    private Rol rol;

    public Usuario(String seudonimo, String correo, String contrasena) {
        this.seudonimo = seudonimo;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String get_id() {
        return _id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getseudonimo() {
        return seudonimo;
    }

    public void setseudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    public String getcorreo() {
        return correo;
    }

    public void setcorreo(String correo) {
        this.correo = correo;
    }

    public String getcontrasena() {
        return contrasena;
    }

    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
