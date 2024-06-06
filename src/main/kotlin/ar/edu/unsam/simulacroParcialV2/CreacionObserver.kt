package ar.edu.unsam.simulacroParcialV2

interface CreacionObserver {
    fun programaAgregado(programa: Programa, grilla: Grilla)
}

class ConductorObserver(val mailSender: MailSender): CreacionObserver {
    override fun programaAgregado(programa: Programa, grilla: Grilla) {
        programa.mailsConductores().forEach {
            mailSender.sendMail(
                Mail(
                    from = "programacion@tvpublica.gob.ar",
                    to = it,
                    subject = "Oportunidad!",
                    body = "Fuiste seleccionado para conducir ${programa.titulo}!" +
                            "Ponete en contacto con la gerencia."
                )
            )
        }
    }
}

class PresupuestoObserver(val messageSender: ShortMessageSender): CreacionObserver {
    override fun programaAgregado(programa: Programa, grilla: Grilla) {
        messageSender.sendMessage(ShortMessage(
            from = "0303456",
            to = "Cliowin",
            content = "programa.presupuesto - ${programa.titulo} - CONSEGUIR SPONSOR URGENTE!"
        ))
    }
}

class ProgramasEnRevisionObserver(): CreacionObserver {
    override fun programaAgregado(programa: Programa, grilla: Grilla) {
        grilla.sincronizarProgramacion()
    }

}