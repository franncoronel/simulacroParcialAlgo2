package ar.edu.unsam.simulacroParcial.FC

abstract class Restriccion {
    val accionesAsociadas = mutableListOf<Accion>()

    abstract fun cumpleCondicion(programa: Programa): Boolean

    fun ejecutarAcciones() {
        accionesAsociadas.forEach { it.tomarAccion() }
    }
}

class ratingMinimo(var limiteInferior: Double) : Restriccion() {
    override fun cumpleCondicion(programa: Programa) = programa.promedioDeRating() > limiteInferior
}

class maximoConductores(var maximo: Int) : Restriccion() {
    override fun cumpleCondicion(programa: Programa): Boolean = programa.cantidadDeConductores() < maximo
}

class presupuestoLimitado(var topeDePresupuesto: Double) : Restriccion() {
    override fun cumpleCondicion(programa: Programa): Boolean = programa.presupuesto <= topeDePresupuesto
}

class conductorPrincipal(var personaConductora: String) : Restriccion() {
    override fun cumpleCondicion(programa: Programa): Boolean = programa.conductorParticipa(personaConductora)
}

object restriccionCompuestaOr : Restriccion() {
    val condiciones = mutableSetOf<Restriccion>()

    override fun cumpleCondicion(programa: Programa): Boolean = condiciones.any { it.cumpleCondicion(programa) }
}

object restriccionCompuestaAnd : Restriccion() {
    val condiciones = mutableSetOf<Restriccion>()

    override fun cumpleCondicion(programa: Programa): Boolean = condiciones.all { it.cumpleCondicion(programa) }
}