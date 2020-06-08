package pe.edu.tecsup.laboratorio9.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.util.List;

import pe.edu.tecsup.laboratorio9.R;
import pe.edu.tecsup.laboratorio9.adapter.UserAdapter;
import pe.edu.tecsup.laboratorio9.model.User;
import pe.edu.tecsup.laboratorio9.repository.UserRepository;

public class MainActivity extends AppCompatActivity {

    //Tag para los log
    private static final String TAG = MainActivity.class.getSimpleName();

    ImageView imageView;
    private static final int REGISTER_FORM_REQUEST = 100;

    //
    private RecyclerView usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configure ReciclerView
        //Instanciamos las varibles con nuestras vistas
        usersList = (RecyclerView) findViewById(R.id.user_list);
        usersList.setLayoutManager(new LinearLayoutManager(this));

        // Set Data Adapter to ReciclerView
        List<User> users = UserRepository.list();
        //UserAdapter es nuestr constructor
        usersList.setAdapter(new UserAdapter(users));

    }

    //Inicia un activity para esperar un resultado
    //Para esto devemos pasarle una constante REGISTER_FORM_REQUEST
    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }

    // return from RegisterActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        //Creamos un nuevo adpter a partir del recicle view
        UserAdapter adapter = (UserAdapter)usersList.getAdapter();

        //Este hace un select de mis usuarios
        List<User> users = UserRepository.list();
        adapter.setUsers(users);
        //Le abisamos al dapter que actualize el recicle view
        adapter.notifyDataSetChanged();

    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }



}

