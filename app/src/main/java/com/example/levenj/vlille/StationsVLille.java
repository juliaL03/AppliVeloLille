package com.example.levenj.vlille;

import com.google.android.gms.maps.model.LatLng;

/**
 * @author Julia
 * Cette classe représente une station
 */
public class StationsVLille {

    // L'identifiant de la station
    private int id;

    // Le nombre de la station
    private String nom;

    // Le nombre de vélos disponible à la station
    private int nbVelo;

    // La position de la station : sa latitude
    private double latitude;

    // La position de la station : sa longitude
    private double longitude;

    // Le constructeur
    public StationsVLille(int id, String nom, int nbVelo, double latitude, double longitude) {
        this.id = id;
        this.nom = nom;
        this.nbVelo = nbVelo;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Cette méthode permet de récupérer l'identifiant de la station
     * @return l'identifiant de la station
     */
    public int getId() {
        return this.id;
    }


    /**
     * Cette méthode permet de modifier l'identifiant de la station
     * @param id le nouvel identifiant de la station
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Cette méthode permet de récupérer le nom de la station
     * @return le nom de la station
     */
    public String getNom() {
        return this.nom;
    }


    /**
     * Cette méthode permet de modifier le nom de la station
     * @param nom le nouveau nom de la station
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    /**
     * Cete méthode permet de récupérer le nombre de vélos disponibles dans la station
     * @return le nombre de vélos disponibles dans la station
     */
    public int getNbVelo() {
        return this.nbVelo;
    }


    /**
     * Cette méthode permet de modifier le nombre de vélos disponibles dans la station
     * @param nbVelo le nouveau nombre de vélos disponibles dans la station
     */
    public void setNbVelo(int nbVelo) {
        this.nbVelo = nbVelo;
    }


    /**
     * Cette méthode permet de récupérer la latitude de la station
     * @return la latitude de la station
     */
    public double getLatitude() {
        return this.latitude;
    }


    /**
     * Cette méthode permet de modifier la latitude de la station
     * @param latitude la nuvelle latitude la station
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    /**
     * Cette méthode permet de récupérer la longitude de la station
     * @return la longitude de la station
     */
    public double getLongitude() {
        return this.longitude;
    }


    /**
     * Cette méthode permet de modifier la longitude de la station
     * @param longitude la nouvelle longitude de la station
     */
    public void setLongitude(double longitude) {
            this.longitude = longitude;
    }

    /**
     * Cette méthode permet de récupérer la position (emplacement) de la station
     * @return la position (emplacement) de la station
     */
    public LatLng getPosition() {
        return new LatLng(this.latitude,this.longitude);
    }



}
