package dam.moviles.proyecto04_bil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import dam.moviles.proyecto04_bil.databinding.FragmentFormularioBinding

class FormularioFragment : Fragment() {

    private lateinit var binding:FragmentFormularioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater,container)
        inicializarMaterialToolbar()
        desactivarBotones()
        inicializarEventos()
        inicializarBotonFlotante()
        return binding.root
    }

    //Al pulsar cada botón se le ponga el canal alpha a 1
    private fun inicializarEventos(){
        getListaBotones().forEach{ boton ->
            boton.setOnClickListener{
                desactivarBotones()
                boton.alpha = 1F
            }
        }
    }

    private fun getBebidaSeleccionada():Int?{
        val lista = getListaBotones()
            .filter{ boton -> boton.alpha == 1F}

        return if(lista.isEmpty())
            null
        else
            when(lista[0]){
                binding.btnBebida1 -> 1
                binding.btnBebida2 -> 2
                binding.btnBebida3 -> 3
                binding.btnBebida4 -> 4
                binding.btnBebida5 -> 5
                binding.btnBebida6 -> 6
                else -> throw Exception("Bebida no válida")
            }
    }

    private fun inicializarBotonFlotante(){
        binding.btnEnviar.setOnClickListener{
            if(binding.chkAceptar.isChecked){
                // mostramos la bebida seleccionada
                Toast.makeText(
                    context,
                    "Has elegido la bebida ${getBebidaSeleccionada()}",
                    Toast.LENGTH_SHORT
                    ).show()
            }else{
                Snackbar.make(
                    binding.btnEnviar,
                    "Debe aceptar los términos para continuar",
                    Snackbar.LENGTH_SHORT
                ).setAction("Aceptar"){
                    binding.chkAceptar.isChecked = true
                }.show()
            }
        }
    }

    private fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragmentFormularioBinding.inflate(inflater,container,false)
    }

    private fun inicializarMaterialToolbar(){
        //La barra materialToolbar sustituye a la barra fea (default app bar)
        (activity as MainActivity).setSupportActionBar(binding.materialToolbar)
    }

        // devuelve una lista con todos los botones
    private fun getListaBotones():List<ImageView> =
        listOf(
            binding.btnBebida1,
            binding.btnBebida2,
            binding.btnBebida3,
            binding.btnBebida4,
            binding.btnBebida5,
            binding.btnBebida6
        )


        // pone el canal alpha a 0.6 a todos los botones
    private fun desactivarBotones(){
        getListaBotones().forEach{ boton ->
            boton.alpha = 0.6F
        }
    }
}