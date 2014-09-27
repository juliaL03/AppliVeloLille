package com.example.levenj.vlille;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author Julia
 * Cette classe correspond à l'Adapter qui va gérer la liste des stations
 * affichées sur une vue
 */
public class StationsAdapter extends ArrayAdapter<StationsVLille> {

    private Context contexte;

    // La liste des stations pour lesquelles on affichera les informations sur la vue
    private ArrayList<StationsVLille> arrList;


    public StationsAdapter(Context ctx, ArrayList<StationsVLille> arrList) {
          super(ctx,R.layout.infos_stations,arrList);
          this.contexte = ctx;
          this.arrList = arrList;
    }


    /**
     * Cette méthode permet de récupérer la vue qui affichera les stations
     * @param position le numéro de la position d'une station dans la liste affichée sur la vue
     * @param convertView
     * @param parent
     * @return
     */
    public View getView(int position,View convertView,ViewGroup parent) {
        // Récupération de la vue dans laquelle sera affichée la liste des stations avec les informations souhaitées
        LayoutInflater inflater = (LayoutInflater) contexte.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.infos_stations, parent, false);

        // A chaque TextView dans la vue, on associe l'information que l'on souhaite afficher pour la station numéro "position"
        ((TextView) rowView.findViewById(R.id.idStation)).setText(arrList.get(position).getId() + "-");
        ((TextView) rowView.findViewById(R.id.nomStation)).setText(arrList.get(position).getNom() + "");
        ((TextView) rowView.findViewById(R.id.nbVelos)).setText(arrList.get(position).getNbVelo() + "");
        ((TextView) rowView.findViewById(R.id.coord)).setText(arrList.get(position).getPosition() + "");

        //On retourne la vue avec toutes les informations
        return rowView;
    }

}
