package pe.edu.tecsup.flashbrowser.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

import pe.edu.tecsup.flashbrowser.R;

public class WebViewdemoActivity extends AppCompatActivity {

    private EditText et1;
    WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_viewdemo);

        et1=(EditText)findViewById(R.id.txt_web);

    }

    //metodo boton ir
    public void Navegar(View view){
        Intent i= new Intent(this, ActivityWeb.class);
        i.putExtra("sitioWeb", et1.getText().toString());
        startActivity(i);



    }
}