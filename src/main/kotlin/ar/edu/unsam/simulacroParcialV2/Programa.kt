package ar.edu.unsam.simulacroParcialV2

class Programa {
    var presupuesto = 200
    var titulo = "Hablemos Sin Saber"
    val conductores = mutableListOf<Conductor>()

    fun mailsConductores(): List<String> = conductores.map{ it.email }
    fun ratingPromedio(): Int =

    fun cantidadConductores(): Int = conductores.size

    fun loConduce(nombreConductor: String): Boolean = nombresConductores().any { nombreConductor == it }

    fun nombresConductores(): List<String> = conductores.map { it.nombre }
}

data class Conductor(val nombre: String, val email: String)