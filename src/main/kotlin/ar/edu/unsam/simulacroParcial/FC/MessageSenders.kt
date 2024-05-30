package ar.edu.unsam.simulacroParcial.FC

interface MailSender {
    fun sendMail(mail: Mail)
}

data class Mail(val from:String, val to:String, val subject: String, val body: String)

interface MessageSender {
    fun sendMessage(sms:SMS)
}

data class SMS(val to: String, val texto: String)