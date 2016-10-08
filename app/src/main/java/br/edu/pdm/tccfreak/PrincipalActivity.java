package br.edu.pdm.tccfreak;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.pdm.tccfreak.model.Usuario;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabFrequencia);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // recuperamos o usuario passado por parâmetro
        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        // Snackbar.make(navigationView, "Seja bem-vindo " + usuario, Snackbar.LENGTH_LONG).show();
        TextView txtUsuario = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txtUsuario);
        TextView txtEmail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txtEmail);
        txtUsuario.setText(usuario.getNome());
        txtEmail.setText(usuario.getEmail());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.mnConfiguracoes) {
            Toast.makeText(PrincipalActivity.this, "Clicado em configurações", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.mnAluno) {
            Toast.makeText(PrincipalActivity.this, "Clicado em aluno", Toast.LENGTH_LONG).show();
        } else if (id == R.id.mnTrabalho) {
            Toast.makeText(PrincipalActivity.this, "Clicado em trabalho", Toast.LENGTH_LONG).show();
        } else if (id == R.id.mnSobre) {
            Toast.makeText(PrincipalActivity.this, "Clicado em sobre", Toast.LENGTH_LONG).show();
        } else if (id == R.id.mnSair) {
            sair();
        } else if (id == R.id.mnSincronizar) {
            Toast.makeText(PrincipalActivity.this, "Clicado em sincronizar", Toast.LENGTH_LONG).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void sair() {
        // finalizar a atividade
        AlertDialog.Builder dialogoSair = new AlertDialog.Builder(this);
        dialogoSair.setTitle(R.string.dlgSair);
        dialogoSair.setMessage(R.string.msgSair);
        dialogoSair.setNegativeButton(R.string.opNao, null);
        dialogoSair.setPositiveButton(R.string.opSim, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                System.exit(0);
            }
        });
        dialogoSair.show();
    }
}
