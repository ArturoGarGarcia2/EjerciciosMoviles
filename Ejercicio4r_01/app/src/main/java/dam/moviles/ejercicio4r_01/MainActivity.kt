package dam.moviles.ejercicio4r_01

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dam.moviles.ejercicio4r_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        inicializarBotones()
    }

    fun inicializarBotones(){
        binding.btnSuma.setOnClickListener{
            val operador1: Double = binding.txtDecimal1.text.toString().toDoubleOrNull() ?: 0.0
            val operador2: Double = binding.txtDecimal2.text.toString().toDoubleOrNull() ?: 0.0

            binding.txtResultado.setText((operador1+operador2).toString())
        }

        binding.btnResta.setOnClickListener{
            val operador1: Double = binding.txtDecimal1.text.toString().toDoubleOrNull() ?: 0.0
            val operador2: Double = binding.txtDecimal2.text.toString().toDoubleOrNull() ?: 0.0

            binding.txtResultado.setText((operador1-operador2).toString())
        }

        binding.btnMulti.setOnClickListener{
            val operador1: Double = binding.txtDecimal1.text.toString().toDoubleOrNull() ?: 0.0
            val operador2: Double = binding.txtDecimal2.text.toString().toDoubleOrNull() ?: 0.0

            binding.txtResultado.setText((operador1*operador2).toString())
        }

        binding.btnDivi.setOnClickListener{
            val operador1: Double = binding.txtDecimal1.text.toString().toDoubleOrNull() ?: 0.0
            val operador2: Double = binding.txtDecimal2.text.toString().toDoubleOrNull() ?: 0.0

            val resultado: String

            if(operador2!=0.0){
                resultado = (operador1/operador2).toString()
            }else{
                resultado = "Valor indefinido"
            }

            binding.txtResultado.setText(resultado)
        }
    }
}