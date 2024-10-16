package dam.moviles.proyecto3_bil

import android.os.SystemClock
import android.widget.Chronometer
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() { // class hija : padre
    var base:Long = 0
    var situacion:Situacion = Situacion.PARADO
    var tiempoTranscurrido:Long = 0

    fun reiniciarManteniendoTiempo(reloj:Chronometer){
        base = SystemClock.elapsedRealtime() - tiempoTranscurrido
        reloj.base = base
    }

    fun actualizarTiempotranscurrido(){
        tiempoTranscurrido = SystemClock.elapsedRealtime() - base;
    }

    fun reiniciar(reloj:Chronometer){
        base = SystemClock.elapsedRealtime()
        reloj.base = base
        situacion = Situacion.FUNCIONANDO
    }

}