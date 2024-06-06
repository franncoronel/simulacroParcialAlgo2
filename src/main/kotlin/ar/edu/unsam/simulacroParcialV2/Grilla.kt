package ar.edu.unsam.simulacroParcialV2

class Grilla {
    val programas = mutableListOf<Programa>()
    val programasARevisar = mutableListOf<Programa>()
    val CreacionObservers = mutableListOf<CreacionObserver>()

    fun agregarPrograma(programa: Programa){
        programas.add(programa)
        CreacionObservers.forEach { it.programaAgregado(programa, this) }
    }

    fun quitarPrograma(programa: Programa){
        programas.remove(programa)
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

    fun ejecutarProcesoDeRevision(){
        programas.forEach{ it.revisar(this) }
    }

    fun proximoPrograma(programa: Programa): Programa {
        val indice = programas.indexOf(programa)
        return if (indice<programas.size) programas[indice+1] else programas[0]
    }

    fun sincronizarProgramacion() {
        val programasQueSeVan = programasARevisar.filter { it !in programas }
        programasARevisar.removeAll(programasQueSeVan)
    }
}