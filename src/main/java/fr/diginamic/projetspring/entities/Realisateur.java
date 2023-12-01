package fr.diginamic.projetspring.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String urlProfile;


    @OneToMany(mappedBy = "realisateur")
    private List<Film> filmsRealises;

    // Constructeurs
    public Realisateur() {
    }

    public Realisateur(String nom) {
        this.nom = nom;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }
    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getUrlProfile() {
        return urlProfile;
    }
    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    public List<Film> getFilmsRealises() {
        return filmsRealises;
    }

    public void setFilmsRealises(List<Film> filmsRealises) {
        this.filmsRealises = filmsRealises;
    }
}