package ar.edu.unsam.simulacroParcialV2

import java.time.DayOfWeek

class Programa {
    var presupuesto = 200
    var titulo = "Hablemos Sin Saber"
    var conductores = mutableListOf<Conductor>()
    var rating = mutableListOf<Int>()
    var sponsors = mutableListOf<String>()
    var dias = mutableListOf<DayOfWeek>()
    val restricciones = mutableListOf<Restriccion>()
    var duracion = 30

    fun mailsConductores(): List<String> = conductores.map{ it.email }
    fun ratingPromedio(): Double = rating.average()

    fun mitadDuracion() = duracion / 2

    fun primerConductor() = conductores.first()

    fun revisar(grilla: Grilla) {
        val primeraRestriccion = restricciones.find { !it.cumpleCondicion(this) }
        primeraRestriccion?.ejecutarAcciones(this, grilla)
    }

    fun cantidadConductores(): Int = conductores.size

    fun loConduce(nombreConductor: String): Boolean = nombresConductores().any { nombreConductor == it }

    fun nombresConductores(): List<String> = conductores.map { it.nombre }
    fun mitadPresupuesto(): Int = presupuesto / 2
    fun mitadConductores(): MutableList<Conductor> = conductores.take(conductores.size / 2).toMutableList()
    fun otraMitadConductores(): MutableList<Conductor> = conductores.minus(mitadConductores().toSet()).toMutableList()
    fun dividirTitulo(): List<String> = titulo.split(" ")
}

data class Conductor(val nombre: String, val email: String)