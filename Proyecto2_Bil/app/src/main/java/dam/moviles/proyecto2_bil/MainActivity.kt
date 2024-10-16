package dam.moviles.proyecto2_bil

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dam.moviles.proyecto2_bil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Este objeto contiene todos los controles del archivo activity_main.xml
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Esta línea crea el objeto "controles" con los objetos
        // que hay en el archivo activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        //La interfaz de MainActivity es el FrameLayout
        //que es el padre del archivo activity_main.xml
        setContentView(binding.root)
        this.inicializarBotones()
    }

    private fun inicializarBotones(){
        binding.btnSeleccionarCurso.setOnClickListener{
            binding.txtAsignaturas.text = getListaAsignaturaBonica(this.getAsignaturas(binding.spiCurso.selectedItem.toString()));
        }

        binding.btnEnviar.setOnClickListener{
            Toast.makeText(
                this, //Se verá en la Activity que estamos programando
                getString(R.string.mensajeToast,binding.txtObservaciones.text.toString()), //Texto que se verá
                Toast.LENGTH_LONG //Duración del texto
            ).show()
        }
    }

    /*private fun getListaAsignaturaBonica(lista:List<String>):String{
        var texto:String = ""
        for(asignatura in lista){
            texto += "- $asignatura\n";
        }
        return texto;
    }*/

    private fun getListaAsignaturaBonica(lista:List<String>):String =
        lista.map{ ele -> "- ${ele} \n"}.joinToString("")

    fun getAsignaturas(curso:String):List<String> = //Esto es igual a {return (...)}
        when(curso){
            "1º DAM" -> listOf(
                getString(R.string.programacion),
                "Entornos",
                "Marcas",
                "Bases de Datos",
                "Sistemas"
            )
            "2º DAM" -> listOf(
                "Móviles",
                "Interfaces",
                "Acceso a Datos",
                "Servicios y Procesos",
                "Sistemas de Gestión Empresarial"
            )
            else -> throw Exception("Curso no admitido")
        }


}