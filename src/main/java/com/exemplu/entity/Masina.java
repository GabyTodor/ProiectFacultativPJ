package com.exemplu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "masini")
public class Masina {
    @Id
    private String nrInmatriculare;

    @ManyToOne
    @JoinColumn(name = "id_utilizator")
    private User utilizator;

    private String marca;
    private String model;
    private String culoare;
    private Integer anFabricatie;
    private Integer capacitateCilindrica;
    private String combustibil;
    private Integer putere;
    private Integer cuplu;
    private Integer volumPortbagaj;
    private Double pret;

    public Masina(String nr_inmatriculare, User utilizator, String marca, String model, String culoare,
                  int anFabricatie, int capacitateCilindrica, String combustibil, int putere, int cuplu, int volumPortbagaj, double pret) {
        this.nrInmatriculare = nr_inmatriculare;
        this.utilizator = utilizator;
        this.marca = marca;
        this.model = model;
        this.culoare = culoare;
        this.anFabricatie = anFabricatie;
        this.capacitateCilindrica = capacitateCilindrica;
        this.combustibil = combustibil;
        this.putere = putere;
        this.cuplu = cuplu;
        this.volumPortbagaj = volumPortbagaj;
        this.pret = pret;
    }

    public Masina() {}

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    public User getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(User utilizator) {
        this.utilizator = utilizator;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public Integer getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(Integer anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public Integer getCapacitateCilindrica() {
        return capacitateCilindrica;
    }

    public void setCapacitateCilindrica(Integer capacitateCilindrica) {
        this.capacitateCilindrica = capacitateCilindrica;
    }

    public String getCombustibil() {
        return combustibil;
    }

    public void setCombustibil(String combustibil) {
        this.combustibil = combustibil;
    }

    public Integer getPutere() {
        return putere;
    }

    public void setPutere(Integer putere) {
        this.putere = putere;
    }

    public Integer getCuplu() {
        return cuplu;
    }

    public void setCuplu(Integer cuplu) {
        this.cuplu = cuplu;
    }

    public Integer getVolumPortbagaj() {
        return volumPortbagaj;
    }

    public void setVolumPortbagaj(Integer volumPortbagaj) {
        this.volumPortbagaj = volumPortbagaj;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "nr_inmatriculare='" + nrInmatriculare + '\'' +
                ", utilizator=" + utilizator +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", culoare='" + culoare + '\'' +
                ", anFabricatie=" + anFabricatie +
                ", capacitateCilindrica=" + capacitateCilindrica +
                ", combustibil='" + combustibil + '\'' +
                ", putere=" + putere +
                ", cuplu=" + cuplu +
                ", volumPortbagaj=" + volumPortbagaj +
                ", pret=" + pret +
                '}';
    }
}
