package pe.edu.tecsup.login;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegistroRequest extends StringRequest {

    private static final String ruta="http://localhost:8080/master-php/registro.php";
    private Map<String, String> parametros;
    public RegistroRequest(String username, String password, String nombres, String correo, String imagen, double estado, Response.Listener<String> listener){

        super(Request.Method.POST, ruta, listener, null);
        parametros=new HashMap<>();
        parametros.put("username",username+"");
        parametros.put("password",password+"");
        parametros.put("nombres",nombres+"");
        parametros.put("correo",correo+"");
        parametros.put("imagen",imagen+"");
        parametros.put("estado",estado+"");
    }

    @Override
    protected Map<String, String> getParams(){
       return parametros;

    }

}
