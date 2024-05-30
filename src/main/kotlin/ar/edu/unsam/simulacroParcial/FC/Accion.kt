package ar.edu.unsam.simulacroParcial.FC

import java.time.DayOfWeek

abstract class Accion() {
    abstract fun tomarAccion()
}

class PartirPrograma() : Accion(){
    override fun tomarAccion() {
        TODO("Not yet implemented")
    }
}

class ReemplazarPorSimpsons(val programa: Programa): Accion(){
    override fun tomarAccion() {
        programa.titulo = "Los Simpsons"
    }
}

class FusionarPrograma(val programa: Programa, val grilla: Grilla): Accion(){
    override fun tomarAccion() {
        TODO("Not yet implemented")
    }
}

class MoverDeDia(val programa: Programa, var nuevoDia: DayOfWeek): Accion(){
    override fun tomarAccion() {
        programa.dia = nuevoDia
    }
}