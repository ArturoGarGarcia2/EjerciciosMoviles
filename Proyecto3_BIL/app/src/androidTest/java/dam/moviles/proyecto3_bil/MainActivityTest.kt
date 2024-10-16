package dam.moviles.proyecto3_bil

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.isNotEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {
    private lateinit var escenario:ActivityScenario<MainActivity>

    //Este método se llama antes de cada test
    @Before
    fun setUp() {
        escenario = launch(MainActivity::class.java)
    }

    //Este método se llama después de cada test
    @After
    fun tearDown() {
    }

    @Test
    fun test1(){
        //Vamos a comprobar que al iniciar MainActivity el reloj pone 00:00
        onView(withId(R.id.chrReloj))
            .check(matches(withText("00:00")))
    }

    @Test
    fun test2(){
        //Comprobamos que start está habilitado y los otros deshabilitados
        onView(withId(R.id.btnInicio))
            .check(matches(isEnabled()))
        onView(withId(R.id.btnStop))
            .check(matches(isNotEnabled()))
        onView(withId(R.id.btnPausa))
            .check(matches(isNotEnabled()))
        onView(withId(R.id.btnReiniciar))
            .check(matches(isNotEnabled()))
    }

    @Test
    fun test3(){
        //Pulsamos start y a los 5'' comprobamos que el reloj pone 00:05
        onView(withId(R.id.btnInicio))
            .perform(click())
        Thread.sleep(5000)
        onView(withId(R.id.chrReloj))
            .check(matches(withText("00:05")))
    }

    @Test
    fun test4(){
        //Pulsamos start, deja pasar 5'', gira el móvil
        //y comprueba que al volver la app, el reloj pone 00:05
        onView(withId(R.id.btnInicio))
            .perform(click())
        Thread.sleep(5000)
        escenario.recreate() //Simula un cambio estructural
        onView(withId(R.id.chrReloj))
            .check(matches(withText("00:05")))
    }
}