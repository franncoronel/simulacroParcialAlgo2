package ar.edu.unsam.simulacroParcial.FC

abstract class Accion() {
    fun tomarAccion(){
        accionar()
    }
    abstract fun accionar()
}

class PartirPrograma() : Accion(){
    override fun accionar() {
        TODO("Not yet implemented")
    }
}

class ReemplazarPorSimpsons(val programa: Programa): Accion(){
    override fun accionar() {

        TODO("Not yet implemented")
    }
    fun reemplazar(programa: Programa) {
        programa.titulo = "Los Simpsons"

    }
}

class FusionarPrograma(val programa: Programa, val grilla: Grilla): Accion(){
    override fun accionar() {
        TODO("Not yet implemented")
    }
}

class MoverDeDia(val programa: Programa, var nuevoDia: String): Accion(){
    override fun accionar() {
        programa.dia = nuevoDia
    }
}