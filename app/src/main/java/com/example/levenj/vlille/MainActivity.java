package com.example.levenj.vlille;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * @author Julia
 * L'activité principale
 */
public class MainActivity extends Activity implements View.OnClickListener {

    // La liste des stations pour lesquelles on souhaite avoir des informations
    private ArrayList<StationsVLille> stations;

    // Le fragment sur lequel on affiche les informations souhaitées des différentes stations
    private StationListeFragment stationsFragment;

    private ActionBar actionBar;

    /**
     * Méthode appelée lors de la création de l'activité
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_fragment);

        //Initialisation du fragment et association du fragment à la vue
        stations = new ArrayList<StationsVLille>();
        stationsFragment = StationListeFragment.newInstance();
        getFragmentManager().beginTransaction().add(R.id.map,stationsFragment).commit();

        // Ajout des stations dans la liste des stations
        stations.add(new StationsVLille(119,"Lomme Lambersart ",5,50.641,3.0188));
        stations.add(new StationsVLille(93,"Stade Ballet",10,50.6289,3.08815));
        stations.add(new StationsVLille(25,"Gare Lille Flandres",2,50.636,3.06968));

        /*actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.newTab().setText("My Friends").setTabListener(tabListener);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("Android Version").setTabListener(tabListener);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("Android Phones").setTabListener(tabListener);
        actionBar.addTab(tab);*/
    }


    /**
     * Cette méthode permet de récupérer la liste des stations pour lesquelles on souhaite obtenir des informations
     * @return la liste des stations pour lesquelles on souhaite obtenir des informations
     */
    public ArrayList<StationsVLille> getListeStations(){
        return stations;
    }


    /**
     * Cette méhode permet d'ajouter le fragment courant à la vue
     * @param i le numéro de la position
     */
    public void positionSelected(int i){
        MyMapFragment mapfrag = MyMapFragment.newInstance(i);
        getFragmentManager().beginTransaction().replace(R.id.map,mapfrag).commit();
    }


    /**
     * Cette méthode permet de récupérer le fragment de la station courante afin
     * de l'afficher par la suite
     */
    public void showList(){
        getFragmentManager().beginTransaction().replace(R.id.map,stationsFragment).commit();
    }


    /**
     * Méthode exécuté à chaque click
     * @param v
     */
    public void onClick(View v) {
        showList();
    }

}
