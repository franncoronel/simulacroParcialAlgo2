package ar.edu.unsam.simulacroParcial.FC

class Grilla {
    val programacion = mutableListOf<Programa>()
    val programaObservers = mutableListOf<ProgramaObserver>()
    val programasARevisar = mutableListOf<Programa>()

    fun agregarPrograma(programa: Programa) {
        programacion.add(programa)
        programaObservers.forEach { it.programaAgregado(programa,this) }
    }

    fun quitarPrograma(programa: Programa){
        programacion.remove(programa)
    }

    fun agregarARevision(programa: Programa){
        programasARevisar.add(programa)
    }

    fun revisarProgramas(){}
}