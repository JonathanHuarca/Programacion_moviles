package pe.edu.tecsup.laboratorio9.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.edu.tecsup.laboratorio9.R;
import pe.edu.tecsup.laboratorio9.model.User;
import pe.edu.tecsup.laboratorio9.repository.UserRepository;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> users;

    public UserAdapter(List<User> users){
        this.users = users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    //Representacion de nuestra plantilla
    //Viena hacer cada elemento que vamos a pintar en la consola
    //En este caso una imagen fullname y email

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView picture;
        public TextView fullname;
        public TextView email;

        public ImageButton button;

        public ViewHolder(View itemView) {
            super(itemView);


            picture = (ImageView) itemView.findViewById(R.id.picture_image);
            fullname = (TextView) itemView.findViewById(R.id.fullname_text);
            email = (TextView) itemView.findViewById(R.id.email_text);
            button = (ImageButton) itemView.findViewById(R.id.delete_button);
        }
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(itemView);
    }

    //Recuperamos un objeto de tipo usuario de una lista

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder viewHolder,final int position) {
        final User user = this.users.get(position);

        byte[] foodImage = user.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        viewHolder.picture.setImageBitmap(bitmap);
        viewHolder.fullname.setText(user.getFullname());
        viewHolder.email.setText(user.getEmail());


        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserRepository.delete(user.getId());
                users.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount());

            }
        });

    }


    @Override
    public int getItemCount() {
        return this.users.size();
    }

}

