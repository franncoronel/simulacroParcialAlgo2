package ar.edu.unsam.simulacroParcial.FC

import java.time.DayOfWeek

abstract class Accion() {
    abstract fun tomarAccion(programa: Programa, grilla: Grilla)
}

class PartirPrograma() : Accion() {
    override fun tomarAccion(programa: Programa, grilla: Grilla) {
        TODO("Not yet implemented")
    }
}

class ReemplazarPorSimpsons : Accion() {
    //Me parece que una mejor idea sería que haya una instancia de los simpsons con la que trabaje este método
    //Básicamente para que el programa Los Simpsons vaya ocupando los espacios de la grilla que va reemplazando
    override fun tomarAccion(programa: Programa, grilla:Grilla) {
        LosSimpsons.dias.addAll(programa.dias)

        grilla.quitarPrograma(programa)
        grilla.agregarPrograma(LosSimpsons)
    }
}

class FusionarPrograma() : Accion() {
    override fun tomarAccion(programa: Programa, grilla: Grilla) {
        TODO("Not yet implemented")
    }
}

class MoverDeDia(var nuevoDia: MutableList<DayOfWeek>) : Accion() {
    override fun tomarAccion(programa: Programa, grilla: Grilla) {
        programa.dias = nuevoDia
    }
}