package com.edu.ue.blacklist;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "datacredito")
public class Datacredito {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_datacredito;

    @Column
    private String estado;
    // constructores
    // vacio

    public Datacredito() {
    }
    //datos
    public Datacredito(int id_datacredito, String estado) {
        this.id_datacredito = id_datacredito;
        this.estado = estado;
    }
// geters y seters
    public int getId_datacredito() {
        return id_datacredito;
    }

    public void setId_datacredito(int id_datacredito) {
        this.id_datacredito = id_datacredito;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    // tostring

    @Override
    public String toString() {
        return "Datacredito [id_datacredito=" + id_datacredito + ", estado=" + estado + "]";
    }

}

