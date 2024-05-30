package ar.edu.unsam.simulacroParcial.FC

open class Programa(
    var titulo: String = "",
    var presupuesto: Double,
    val conductores: MutableList<Conductor>,
    val sponsors: MutableList<String>,
    var dia: String,
    var duracion: Int,
    val rating: MutableList<Double>
) {
    val restricciones = mutableSetOf<Restriccion>()
    fun cantidadDeConductores(): Int = conductores.size

    fun agregarRestriccion(restriccionesNuevas: Set<Restriccion>) {
        restricciones.addAll(restriccionesNuevas)
    }

    fun quitarRestriccion(restriccionesAQuitar: Set<Restriccion>){
        restricciones.removeAll(restriccionesAQuitar)
    }

    fun extraerMailsConductores(): String = this.conductores
        .map {it.mail}
        .joinToString(", ")

//    fun copiarDesde(otroPrograma: Programa){
//        this.titulo = otroPrograma.titulo
//        this.presupuesto = otroPrograma.presupuesto
//        this.conductores = otroPrograma.conductores
//    }
}

//class LosSimpsons(): Programa()

interface Restriccion{
    fun condicionRestriccion(programa: Programa): Boolean = cumpleCondicion(programa)

    fun cumpleCondicion(programa:Programa): Boolean
}

class ratingMinimo(var limiteInferior: Double): Restriccion{
    override fun cumpleCondicion(programa:Programa) = promedioDeRating(programa)>limiteInferior

    fun promedioDeRating(programa: Programa): Double = programa.rating.average()
}

class maximoConductores(var maximo: Int): Restriccion{
    override fun cumpleCondicion(programa: Programa): Boolean = !excedeConductores(programa)

    fun excedeConductores(programa: Programa): Boolean = programa.cantidadDeConductores()>maximo
}

class presupuestoLimitado(var topeDePresupuesto: Double): Restriccion {
    override fun cumpleCondicion(programa: Programa): Boolean = !excedePresupuesto(programa)

    fun excedePresupuesto(programa: Programa) = programa.presupuesto > topeDePresupuesto
}

class conductorPrincipal(var personaConductora: String): Restriccion{
    override fun cumpleCondicion(programa: Programa): Boolean = conductorParticipa(programa)

    fun conductorParticipa(programa: Programa) = programa.conductores.contains(personaConductora)
}

object restriccionRatingOConductores : Restriccion {
    val condiciones = mutableSetOf<Restriccion>(ratingMinimo(limiteInferior = 5.0),maximoConductores(maximo = 3))

    override fun cumpleCondicion(programa: Programa): Boolean = condiciones.any {it.cumpleCondicion(programa)}
}

object restriccionConductoraYPresupuesto: Restriccion {
    val condiciones = mutableSetOf<Restriccion>(conductorPrincipal(personaConductora = "Pinky"),presupuestoLimitado(topeDePresupuesto = 100000.0))

    override fun cumpleCondicion(programa: Programa): Boolean = condiciones.all {it.cumpleCondicion(programa)}
}