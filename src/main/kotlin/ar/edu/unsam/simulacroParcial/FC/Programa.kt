package ar.edu.unsam.simulacroParcial.FC

import java.time.DayOfWeek

open class Programa(
    var titulo: String = "",
    var presupuesto: Double,
    val conductores: MutableList<Conductor>,
    val sponsors: MutableList<String>,
    var dia: DayOfWeek,
    var duracion: Int,
    val rating: MutableList<Double>
) {
    val restricciones = mutableListOf<Restriccion>()

    fun promedioDeRating(): Double = rating.average()

    fun cantidadDeConductores(): Int = conductores.size

    fun conductorParticipa(nombreConductor: String): Boolean = conductores.any {it.nombre == nombreConductor}

    fun agregarRestriccion(restriccion: Restriccion) {
        restricciones.add(restriccion)
    }

    fun quitarRestriccion(restriccionAQuitar: Restriccion){
        restricciones.remove(restriccionAQuitar)
    }

    fun extraerMailsConductores(): List<String> = conductores.map {it.mail}
}

//class LosSimpsons(): Programa()

