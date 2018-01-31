package me.bincat.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class ScrollingActivity extends AppCompatActivity {
    Context con;

    public ScrollingActivity() {
        con = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Toast", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

             AlertDialog.Builder builder = new  AlertDialog.Builder(con);
             builder.create();
                builder.setMessage("Message");
                builder.setTitle("Alert");
                builder.show();

                NotificationManager barra = (NotificationManager) con.getSystemService(Context.NOTIFICATION_SERVICE);

                final Notification notificacion = new NotificationCompat.Builder(con)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Notificacion barra")
                        .setContentText("Contenido")
                        .build();

                notificacion.flags = Notification.DEFAULT_LIGHTS | Notification.FLAG_AUTO_CANCEL;
                barra.notify( 1,  notificacion);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
