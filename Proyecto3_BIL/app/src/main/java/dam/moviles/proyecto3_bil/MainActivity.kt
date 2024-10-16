package dam.moviles.proyecto3_bil

import android.os.Bundle
import android.os.SystemClock
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dam.moviles.proyecto3_bil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel:MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        //Se ejecuta al crearse la app por primera vez
        super.onCreate(savedInstanceState)
        inicializarViewModel()
        inicializarMochila()
        inicializarBotones()
    }

    override fun onStart() {
        //Se ejecuta al tener un cambio estructural
        super.onStart()
        when(viewModel.situacion){
            Situacion.PARADO -> habilitarBotonStart(true)
            Situacion.FUNCIONANDO -> {
                binding.chrReloj.base = viewModel.base
                binding.chrReloj.start()
                habilitarBotonStart(false)
            }
            Situacion.PAUSA -> {
                habilitarBotonStart(true)
                viewModel.reiniciarManteniendoTiempo(binding.chrReloj)
            }
        }
    }

    override fun onPause() {
        //Se ejecuta al quitar de primer plano la app
        super.onPause()
        if(viewModel.situacion == Situacion.FUNCIONANDO) {
                viewModel.actualizarTiempotranscurrido()
                binding.chrReloj.stop()
        }
    }

    override fun onResume() {
        //Se ejecuta antes de volver a poner en primer plano la app
        super.onResume()
        if(viewModel.situacion == Situacion.FUNCIONANDO) {
            viewModel.reiniciarManteniendoTiempo(binding.chrReloj)
            binding.chrReloj.start()
        }
    }

    private fun inicializarViewModel() {
        //Esta línea obtiene un MainActivityViewModel para this (MainActivity)
        //La primera vez que se llama al método, devuelve un MainActivityViewModel nuevo
        //si se gira la pantalla, la siguiente vez que se llama devuelve el que ya había
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }


    private fun inicializarBotones(){
        binding.apply{
            btnInicio.setOnClickListener{ iniciar() }
            btnStop.setOnClickListener{ detener() }
            btnPausa.setOnClickListener{ pausa() }
            btnReiniciar.setOnClickListener{ viewModel.reiniciar(binding.chrReloj) }
        }
    }

    private fun iniciar(){
        habilitarBotonStart(false)
        when (viewModel.situacion){
            Situacion.PAUSA -> viewModel.reiniciarManteniendoTiempo(binding.chrReloj)
            Situacion.PARADO -> viewModel.reiniciar(binding.chrReloj)
            Situacion.FUNCIONANDO -> {}
        }
        binding.chrReloj.start()
        viewModel.situacion = Situacion.FUNCIONANDO
    }

    private fun detener(){
        habilitarBotonStart(true)
        binding.chrReloj.stop()
        viewModel.reiniciar(binding.chrReloj)
        viewModel.situacion = Situacion.PARADO
    }

    private fun pausa(){
        habilitarBotonStart(true)
        binding.chrReloj.stop()
        viewModel.actualizarTiempotranscurrido()
        viewModel.situacion = Situacion.PAUSA
    }


    private fun inicializarMochila(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun habilitarBotonStart(habilitado:Boolean){
        binding.apply {
            btnInicio.isEnabled = habilitado
            btnStop.isEnabled = !habilitado
            btnPausa.isEnabled = !habilitado
            btnReiniciar.isEnabled = !habilitado
        }
    }
}