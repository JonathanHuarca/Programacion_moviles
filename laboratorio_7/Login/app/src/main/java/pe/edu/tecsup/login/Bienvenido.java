package pe.edu.tecsup.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Bienvenido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
        final TextView mensaje = (TextView)findViewById(R.id.mensaje);
        Intent i= this.getIntent();
        String username=i.getStringExtra("username");
        int nombres=i.getIntExtra("nombres", -1);
        mensaje.setText(mensaje.getText()+""+username+" Su edad :"+nombres+"");

    }
}
