package com.example.levenj.vlille;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * @author Julia
 * Cette classe représente le fragment sur lequel on aura les informations d'une station
 */
public class StationListeFragment extends ListFragment {

    // L'activité dans laquelle on retrouvera le fragment
    MainActivity activitePrincipale;

    public StationListeFragment() {
        super();
    }

    public static StationListeFragment newInstance(){
        StationListeFragment stationFrag = new StationListeFragment();
        return stationFrag;
    }

    // Méthode appelée lors de la création du fragment
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }


    // Méthode appelée lors de la création de la vue à laquelle sera associé le fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.liste_layout, container, false);
    }


    // Méthode appelée lorsque l'on clique sur le fragment : on va ajouter
    public void onListItemClick(ListView list, View v, int position, long id) {
        activitePrincipale.positionSelected(position);
    }


    /**
     * Cette méthode est appelée lorsque le fragment est attaché à son activité
     * @param activite l'activité dans laquelle on retrouve le fragment
     */
    public void onAttach(Activity activity){
        super.onAttach(activity);
        activitePrincipale= (MainActivity) activity;
        StationsAdapter adapt=new StationsAdapter(getActivity(),activitePrincipale.getListeStations());
        setListAdapter(adapt);
    }

}
