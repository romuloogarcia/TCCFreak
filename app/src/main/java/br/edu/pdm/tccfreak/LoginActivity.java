package br.edu.pdm.tccfreak;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import br.edu.pdm.tccfreak.helper.DatabaseHelper;
import br.edu.pdm.tccfreak.model.Usuario;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtLogin;
    private EditText edtSenha;
    private ImageButton btnLogin;
    private ImageButton btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // recuperando instâncias do XML(findViewById)
        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        btnLogin = (ImageButton) findViewById(R.id.btnLogin);
        btnSair = (ImageButton) findViewById(R.id.btnSair);

        btnLogin.setOnClickListener(this);
        btnSair.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        DatabaseHelper dh = new DatabaseHelper(this);
        switch (view.getId()) {
            case R.id.btnLogin:
                // recuperar valores da tela
                String strLogin = edtLogin.getText().toString();
                String strSenha = edtSenha.getText().toString();
                Usuario u = dh.getUsuarioByLoginSenha(strLogin, strSenha);
                if (u != null) {
                    Intent it = new Intent(this, PrincipalActivity.class);
                    it.putExtra("usuario", u);
                    startActivity(it);
                    finish();
                } else {
                    edtLogin.setText("");
                    edtSenha.setText("");
                    Toast.makeText(this, R.string.msgLoginSenha, Toast.LENGTH_LONG).show();
                    edtLogin.requestFocus();
                }
                break;
            case R.id.btnSair:
                sair();
                break;
        }
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
