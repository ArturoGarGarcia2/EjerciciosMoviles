package dam.moviles.proyecto1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//class [Hija] : [Padre]
class MainActivity : AppCompatActivity() {

    //Este método es llamado cuando se crea por 1ª vez la pantalla
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("proyectito","Prueba")
    }
}