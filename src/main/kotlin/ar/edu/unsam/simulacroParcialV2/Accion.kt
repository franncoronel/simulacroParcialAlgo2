package ar.edu.unsam.simulacroParcialV2

abstract class AccionDeRevision {
    abstract fun tomarAccion(programa: Programa, grilla: Grilla)
}

class PartirPrograma() : AccionDeRevision() {
    override fun tomarAccion(programa: Programa, grilla: Grilla) {
        val mitadDeConductores = programa.mitadConductores()
        val otraMitadDeConductores = programa.otraMitadConductores()
        val programa1 = Programa().apply {
            conductores = mitadDeConductores
            presupuesto = this.mitadPresupuesto()
            sponsors = programa.sponsors
            duracion = this.mitadDuracion()
            titulo = "${programa.dividirTitulo().get(0)} en el aire!"
            dias = programa.dias
        }
        val programa2 = Programa().apply {
            conductores = otraMitadDeConductores
            presupuesto = programa.mitadPresupuesto()
            sponsors = programa.sponsors
            duracion = programa.mitadDuracion()
            titulo = programa.dividirTitulo().getOrNull(1) ?: "Programa sin nombre"
            dias = programa.dias
        }
        grilla.quitarPrograma(programa)
        grilla.agregarPrograma(programa1)
        grilla.agregarPrograma(programa2)
    }
}

class ReemplazarPorSimpsons() : AccionDeRevision() {
    override fun tomarAccion(programa: Programa, grilla: Grilla) {
        TODO("Not yet implemented")
    }

}

class FusionarPrograma() : AccionDeRevision() {

    fun elegirSponsor(programa: Programa, otroPrograma: Programa) =
        mutableListOf<MutableList<String>>(programa.sponsors, otroPrograma.sponsors).random()

    fun elegirTitulo(): String = mutableListOf<String>("Impacto total", "Un buen día").random()

    fun sumarDuracion(programa: Programa, otroPrograma: Programa) = programa.duracion + otroPrograma.duracion
    override fun tomarAccion(programa: Programa, grilla: Grilla) {
        val siguientePrograma = grilla.proximoPrograma(programa)
        val fusionProgramas = Programa().apply {
            conductores = mutableListOf(programa.primerConductor(), siguientePrograma.primerConductor())
            presupuesto = minOf(programa.presupuesto, siguientePrograma.presupuesto)
            duracion = sumarDuracion(programa, siguientePrograma)
            sponsors = elegirSponsor(programa, siguientePrograma)
            dias = programa.dias
            titulo = elegirTitulo()
        }
    }


}

class MoverDeDia() : AccionDeRevision() {
    override fun tomarAccion(programa: Programa, grilla: Grilla) {
        TODO("Not yet implemented")
    }

}