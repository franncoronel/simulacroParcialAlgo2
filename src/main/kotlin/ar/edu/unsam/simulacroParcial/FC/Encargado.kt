package ar.edu.unsam.simulacroParcial.FC

class PersonaEncargada(var correo: String) {
    val programaObservers = mutableListOf<ProgramaObserver>()
    val programasARevisar = mutableListOf<Programa>()

    fun agregarPrograma(grilla: Grilla, programa: Programa) {
        grilla.programacion.add(programa)
        programaObservers.forEach { it.programaAgregado(programa,this) }
    }
}