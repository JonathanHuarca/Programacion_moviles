package pe.edu.tecsup.login;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    private static final String ruta="http://localhost:8080/master-php/login.php";
    private Map<String, String> parametros;
    public LoginRequest(String username, String password, Response.Listener<String> listener){

        super(Request.Method.POST, ruta, listener, null);
        parametros=new HashMap<>();
        parametros.put("username",username+"");
        parametros.put("password",password+"");
    }

    @Override
    protected Map<String, String> getParams(){
        return parametros;

    }

}
