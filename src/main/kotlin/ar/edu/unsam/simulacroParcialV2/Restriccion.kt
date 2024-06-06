package ar.edu.unsam.simulacroParcialV2

abstract class Restriccion {
    val accionesAsociadas = mutableListOf<AccionDeRevision>()

    abstract fun cumpleCondicion(programa: Programa): Boolean

    fun ejecutarAcciones(programa: Programa, grilla: Grilla){
        accionesAsociadas.forEach{ it.tomarAccion(programa, grilla) }
    }
}

class MinimoRating(val limiteInferior: Int) : Restriccion() {
    override fun cumpleCondicion(programa: Programa): Boolean = programa.ratingPromedio() > limiteInferior
}

class MaximoConductores(val maximoConductores: Int) : Restriccion() {
    override fun cumpleCondicion(programa: Programa): Boolean = programa.cantidadConductores() <= maximoConductores
}

class ConductorEspecifico(val nombreConductor: String) : Restriccion() {
    override fun cumpleCondicion(programa: Programa): Boolean = programa.loConduce(nombreConductor)
}

class LimitePresupuesto(val limite: Int) : Restriccion() {
    override fun cumpleCondicion(programa: Programa): Boolean = programa.presupuesto <= limite
}

class CondicionCompuestaOR(val restricciones: List<Restriccion>) : Restriccion() {
    override fun cumpleCondicion(programa: Programa): Boolean = restricciones.any { it.cumpleCondicion(programa) }
}

class CondicionCompuestaAND(val restricciones: List<Restriccion>) : Restriccion() {
    override fun cumpleCondicion(programa: Programa): Boolean = restricciones.all { it.cumpleCondicion(programa) }
}

