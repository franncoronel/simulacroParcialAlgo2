package ar.edu.unsam.simulacroParcial.FC

import java.time.DayOfWeek

open class Programa(
    val restricciones: MutableList<Restriccion>,
    var titulo: String = "",
    var presupuesto: Double = 50.0,
    var conductores: MutableList<Conductor>,
    var sponsors: MutableList<String>,
    var rating: MutableList<Double>,
    var dias: MutableList<DayOfWeek>,
    var duracion: Int = 30
) {


    fun promedioDeRating(): Double = rating.average()

    fun cantidadDeConductores(): Int = conductores.size

    fun conductorParticipa(nombreConductor: String): Boolean = conductores.any { it.nombre == nombreConductor }

    fun agregarRestriccion(restriccion: Restriccion) {
        restricciones.add(restriccion)
    }

    fun quitarRestriccion(restriccionAQuitar: Restriccion) {
        restricciones.remove(restriccionAQuitar)
    }

    fun extraerMailsConductores(): List<String> = conductores.map { it.mail }
}

object LosSimpsons : Programa(
    restricciones = mutableListOf<Restriccion>(),
    titulo = "Los Simpsons",
    presupuesto = 10000.0,
    conductores = mutableListOf<Conductor>(),
    sponsors = mutableListOf<String>(),
    rating = mutableListOf<Double>(),
    dias = mutableListOf<DayOfWeek>(),
    duracion = 30
)


data class Conductor(val nombre: String, var mail: String)
