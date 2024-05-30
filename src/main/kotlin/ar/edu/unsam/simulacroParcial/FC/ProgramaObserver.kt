package ar.edu.unsam.simulacroParcial.FC

interface ProgramaObserver {
    fun programaAgregado(programa: Programa, grilla: Grilla) {}
}

class conductoresObserver(val mailSender: MailSender) : ProgramaObserver {
    override fun programaAgregado(programa: Programa, grilla: Grilla) {
        programa.extraerMailsConductores().forEach {
            mailSender.sendMail(
                Mail(
                    from = "programacion@canal12.tv",
                    to = it,
                    subject = "Oportunidad!",
                    body = "Fuiste seleccionado para conducir ${programa.titulo}! Ponete en contacto con la gerencia."
                )
            )
        }
    }
}


class sponsorObserver(val messageSender: MessageSender) : ProgramaObserver {
    override fun programaAgregado(programa: Programa, grilla: Grilla) {
        if (programa.presupuesto > 100000.0) {
            messageSender.sendMessage(
                SMS(
                    to = "Cliowin",
                    texto = "${programa.presupuesto} - ${programa.titulo} - CONSEGUIR SPONSOR URGENTE!"
                )
            )
        }
    }
}

class revisionObserver : ProgramaObserver {
    override fun programaAgregado(programa: Programa, grilla: Grilla) {

    }
}