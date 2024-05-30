package ar.edu.unsam.simulacroParcial.FC

interface ProgramaObserver {
    fun programaAgregado(programa: Programa, encargado: PersonaEncargada){}
}

class conductoresObserver(val mailSender: MailSender): ProgramaObserver {
    override fun programaAgregado(programa: Programa, encargado: PersonaEncargada) {
        mailSender.sendMail(Mail(
            from = encargado.correo,
            to = programa.extraerMailsConductores(),
            subject = "Oportunidad!",
            body = "Fuiste seleccionado para conducir ${programa.titulo}! Ponete en contacto con la gerencia."
        ))
    }
}

class sponsorObserver(val messageSender: MessageSender): ProgramaObserver {
    override fun programaAgregado(programa: Programa, encargado: PersonaEncargada) {
        if(programa.presupuesto>100000.0){
            messageSender.sendMessage(SMS(
                to = "Cliowin",
                texto = "${programa.presupuesto} - ${programa.titulo} - CONSEGUIR SPONSOR URGENTE!"
            ))
        }
    }
}

class revisionObserver: ProgramaObserver {
    override fun programaAgregado(programa: Programa, encargado: PersonaEncargada) {

    }
}