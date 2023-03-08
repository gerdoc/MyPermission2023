package gutierrez.galan.german.mypermission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;




import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.INTERNET;
import static android.content.DialogInterface.*;

public class MainActivity extends AppCompatActivity
{
    private final String[] permisos = { INTERNET};
    private static final int PERMISSION_REQUEST_CODE = 200;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById( R.id.etiqueta );
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        if( !validatePermission( ) )
        {
            textView.setText( "Sin permisos" );
            return;
        }
        textView.setText( "Permisos OK" );
    }

    public boolean validatePermission( )
    {
        int result = 0;
        if( permisos == null || permisos.length == 0 )
        {
            return false;
        }
        result = ContextCompat.checkSelfPermission( getApplicationContext( ) , permisos[ 0 ] );
        return result == PackageManager.PERMISSION_GRANTED;
    }

}