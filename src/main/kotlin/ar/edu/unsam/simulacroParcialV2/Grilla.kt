package ar.edu.unsam.simulacroParcialV2

class Grilla {
    val programas = mutableListOf<Programa>()
    val programasARevisar = mutableListOf<Programa>()
    val CreacionObservers = mutableListOf<CreacionObserver>()

    fun agregarPrograma(programa: Programa){
        programas.add(programa)
        CreacionObservers.forEach { it.programaAgregado(programa, this) }
    }

    fun agregarObserver(observer: CreacionObserver) {
        CreacionObservers.add(observer)
    }

    fun quitarObserver(observer: CreacionObserver) {
        CreacionObservers.remove(observer)
    }

    fun agregarProgramaARevisar(programa: Programa){
        programasARevisar.add(programa)
    }

    fun ejecutarProcesoDeRevision(){}
}