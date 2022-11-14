package com.mintic.seguridadg4.modelos;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Permiso {
    private String _id;
    private String _url;
    private String _metodo;

    public Permiso(String _url, String _metodo) {
        this._url = _url;
        this._metodo = _metodo;
    }

    public String get_id() {
        return _id;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }

    public String get_metodo() {
        return _metodo;
    }

    public void set_metodo(String _metodo) {
        this._metodo = _metodo;
    }
}
