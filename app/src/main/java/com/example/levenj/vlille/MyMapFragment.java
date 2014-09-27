package com.example.levenj.vlille;


import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * @author Julia
 * Cette classe représente le fragment sur lequel on aura une google map
 */
public class MyMapFragment extends MapFragment{

    // L'activité dans laquelle on retrouvera le fragment
    private MainActivity activitePrincipale;


    public MyMapFragment() {
        super();
    }


    public static MyMapFragment newInstance(int i){
        MyMapFragment m = new MyMapFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", i);
        m.setArguments(bundle);
        return m;
    }


    /**
     * Cette méthode créée la vue associée au fragment
     * @param inflater utilisé pour les vues
     * @param container la vue auquel sera rattaché le fragment
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        RelativeLayout res = new RelativeLayout(activitePrincipale);
        res.addView(v);

        // Création d'un bouton permettant de revenir à la vue associée à l'activité principale + ajout du bouton à la vue
        Button b = new Button(getActivity());
        b.setText("Retour");
        b.setOnClickListener(activitePrincipale);
        res.addView(b);

        //Initialisation de la google map avec un marker représentant la station sélectionnée par un clic et un encadrement autour de la station
        StationsVLille station = activitePrincipale.getListeStations().get(this.getArguments().getInt("position"));
        getStationPlan(station);
        getEncadrementEmplacement();
        return res;
    }


    /**
     * Cette méthode permet d'initialiser une google map sur laquelle on indique l'emplacement d'une station
     * @param station la station pour laquelle on souhaite indiquer son emplacement sur une google map
     */
    public void getStationPlan(StationsVLille station){
        // Initialisation de la google map
        GoogleMap map=getMap();
        if (map == null)
            return;
        MapsInitializer.initialize(getActivity());

        // On déplace la "caméra" de la google map sur l'adresse de la station
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(station.getPosition(), 10));

        // On ajoute un marker situé à l'adresse de la station
        map.addMarker(new MarkerOptions().position(station.getPosition())
                .title(station.getNom()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
    }


    /**
     * Cette méthode permet de rajouter un encadrement autour de l'emplacement indiqué sur la google map
     */
    public void getEncadrementEmplacement(){
        // La google map
        GoogleMap map = getMap();
        if (map == null)
            return; // Google Maps not available
        MapsInitializer.initialize(getActivity());

        // On récupère l'emplacement indiqué sur la googe map
        LatLng pos=map.getCameraPosition().target;

        // Les coordonnées des quatres points qui vont servir à former l'encadrement
        ArrayList<LatLng> arhole=new ArrayList<LatLng>();
        arhole.add(new LatLng(pos.latitude-0.50, pos.longitude-0.50));
        arhole.add(new LatLng(pos.latitude+0.50, pos.longitude-0.50));
        arhole.add(new LatLng(pos.latitude+0.50, pos.longitude+0.50));
        arhole.add(new LatLng(pos.latitude-0.50, pos.longitude+0.50));

        // Formation de l'encadrement
        map.addPolygon(new PolygonOptions().add(
                new LatLng(pos.latitude-0.1, pos.longitude-0.1),
                new LatLng(pos.latitude+0.1, pos.longitude-0.1),
                new LatLng(pos.latitude+0.1, pos.longitude+0.1),
                new LatLng(pos.latitude-0.1, pos.longitude+0.1)).fillColor(Color.BLUE).addHole(arhole));
    }


    /**
     * Cette méthode est appelée lorsque le fragment est attaché à son activité
     * @param activite l'activité dans laquelle on retrouve le fragment
     */
    public void onAttach(Activity activite){
        super.onAttach(activite);
        activitePrincipale = (MainActivity) activite;
    }

}
