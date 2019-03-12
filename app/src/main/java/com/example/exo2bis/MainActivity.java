package com.example.exo2bis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button but1;
    private  Button but10;
    private Button but100;
    private TextView affiche;
    private int resultat= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                // declaration des boutons et leur attribution a leurs ID
        but1 =(Button) findViewById(R.id.button1);
        but10 =(Button) findViewById(R.id.button10);
        but100 =(Button) findViewById(R.id.button100);
        affiche =(TextView) findViewById(R.id.affichage);




            // code consernant le longclick   qui affiche le contextMenu
        registerForContextMenu(but1);
        registerForContextMenu(but10);
        registerForContextMenu(but100);



                        // les evenements lors du clique sur les differents bouttons
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultat++;

                affiche.setText(""+resultat);
            }
        });

        but10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultat+=10;
                affiche.setText(""+resultat);
            }
        });
        but100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultat+=100;
                affiche.setText(""+resultat);
            }
        });



    }

            //methode de creation du Contexte Menu ainsi que les items qui s'affichent lors du LONGCLICK

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Reset");
        menu.add(0, v.getId(), 0, "Quit");
    }


    //methode qui definis les instructions a faire lors du click sur un item du Context Menu

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Reset") {
            affiche.setText("0");
            resultat=0;
        }
        else {
                finish();
                System.exit(0);
            return  false;
        }
        return true;
    }


}
