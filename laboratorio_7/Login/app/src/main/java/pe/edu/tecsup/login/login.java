package pe.edu.tecsup.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView registro = (TextView) findViewById(R.id.registroLogin);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final EditText usernamet = (EditText) findViewById(R.id.usernameLogin);
        final EditText passwordt = (EditText) findViewById(R.id.passwordLogin);

        registro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent registro = new Intent(login.this, Registro.class);
                login.this.startActivity(registro);
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String username = usernamet.getText().toString();
                final String password = passwordt.getText().toString();
                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if (ok == true) {
                                String username = jsonRespuesta.getString("username");
                                String nombres = jsonRespuesta.getString("nomnres");
                                Intent bienvenido = new Intent(login.this, Bienvenido.class);
                                bienvenido.putExtra("username", username);
                                bienvenido.putExtra("nombres", nombres);

                                login.this.startActivity(bienvenido);
                                //   login.this.finish();

                            } else {
                                AlertDialog.Builder alerta = new AlertDialog.Builder(login.this);
                                alerta.setMessage("Fallo en el login")
                                        .setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();

                            }
                        } catch (JSONException e) {
                            e.getMessage();
                        }

                    };


                };

                LoginRequest r = new LoginRequest(username, password, respuesta);
                RequestQueue cola = Volley.newRequestQueue(login.this);
                cola.add(r);
            }
        });
    }
}

