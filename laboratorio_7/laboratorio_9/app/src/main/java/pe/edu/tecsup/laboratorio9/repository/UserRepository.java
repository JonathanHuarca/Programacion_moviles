package pe.edu.tecsup.laboratorio9.repository;

import com.orm.SugarRecord;

import java.util.List;

import pe.edu.tecsup.laboratorio9.model.User;

public class UserRepository {

    public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static User read(Long id){
        User user = SugarRecord.findById(User.class, id);
        return user;
    }

    public static void create(String fullname, String email, String password, byte[] image){

        User user = new User(fullname, email, password, image);
        SugarRecord.save(user);
    }

    public static void update(String fullname, String email, String password ,byte[] image, Long id){
        User user = SugarRecord.findById(User.class, id);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        user.setImage(image);
        SugarRecord.save(user);
    }

    public static void delete(Long id){
        User user = SugarRecord.findById(User.class, id);
        SugarRecord.delete(user);
    }

}

