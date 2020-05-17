package pe.edu.tecsup.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final EditText usernamet=(EditText)findViewById(R.id.usuarioRegistro);
        final EditText passwordt=(EditText)findViewById(R.id.passwordRegistro);
        final EditText nombrest=(EditText)findViewById(R.id.nombreRegistro);
        final EditText correot=(EditText)findViewById(R.id.correoRegistro);
        final EditText imagent=(EditText)findViewById(R.id.imagenRegistro);
        final EditText estadot=(EditText)findViewById(R.id.estadoRegistro);
        Button btnRegistro = (Button)findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                final String username = usernamet.getText().toString();
                final String password = passwordt.getText().toString();
                final String nombres= nombrest.getText().toString();
                final String correo= correot.getText().toString();
                final String imagen= imagent.getText().toString();
                final double estado= Double.parseDouble(estadot.getText().toString());

                Response.Listener<String> respuesta =new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok=jsonRespuesta.getBoolean("success");
                            if(ok==true){

                                Intent i=new Intent(Registro.this, login.class);
                                Registro.this.startActivity(i);
                                Registro.this.fileList();
                            }else{

                                AlertDialog.Builder alerta=new AlertDialog.Builder(Registro.this);
                                alerta.setMessage("Fallo en el registro")
                                        .setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();
                            }

                        }catch (JSONException e){
                            e.getMessage();
                        }

                    }
                };
                RegistroRequest r= new RegistroRequest(username,password,nombres,correo,imagen,estado, respuesta);
                RequestQueue cola= Volley.newRequestQueue(Registro.this);
                cola.add(r);
            }
        });


    }
}
