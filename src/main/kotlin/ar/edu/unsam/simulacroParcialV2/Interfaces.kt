package ar.edu.unsam.simulacroParcialV2

interface MailSender {
    fun sendMail(mail: Mail)
}

data class Mail(val from: String, val to: String, val subject: String, val body: String)

interface ShortMessageSender {
    fun sendMessage(message: ShortMessage)
}

data class ShortMessage(val from: String, val to: String, val content: String)