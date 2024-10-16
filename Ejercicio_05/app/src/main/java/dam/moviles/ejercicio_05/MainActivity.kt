package dam.moviles.ejercicio_05

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dam.moviles.ejercicio_05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inicializarBoton()
    }

    @SuppressLint("StringFormatInvalid")
    fun inicializarBoton(){
        binding.btnEnviar.setOnClickListener{
            Toast.makeText(
                this,
                getString(R.string.mensajeToast1,binding.txtTitulo.text.toString()),
                Toast.LENGTH_LONG
            ).show()
            Toast.makeText(
                this,
                getString(R.string.mensajeToast2,binding.txtMensaje.text.toString()),
                Toast.LENGTH_LONG
            ).show()
            Log.d("Título",binding.txtTitulo.text.toString())
            Log.d("Mensaje",binding.txtMensaje.text.toString())
        }
    }
}