package dam.moviles.proyecto2_bil

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var spiCurso: Spinner
    private lateinit var btnSeleccionarCurso: Button
    private lateinit var btnEnviar: Button
    private lateinit var txtObservaciones: EditText
    private lateinit var txtAsignaturas: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.inicializarAtributos()
        this.inicializarBotones()
    }

    fun inicializarAtributos(){
        spiCurso=findViewById(R.id.spiCurso)
        btnSeleccionarCurso=findViewById(R.id.btnSeleccionarCurso)
        btnEnviar=findViewById(R.id.btnEnviar)
        txtObservaciones=findViewById(R.id.txtObservaciones)
        txtAsignaturas=findViewById(R.id.txtAsignaturas)
    }

    private fun inicializarBotones(){
        btnSeleccionarCurso.setOnClickListener{
            txtAsignaturas.text = getListaAsignaturaBonica(this.getAsignaturas(spiCurso.selectedItem.toString()));
        }

        btnEnviar.setOnClickListener{
            Toast.makeText(
                this, //Se verá en la Activity que estamos programando
                getString(R.string.mensajeToast,txtObservaciones.text.toString()), //Texto que se verá
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