package blacklist

import grails.transaction.Transactional

class IbanController {

   static scaffold = true

    @Transactional
    def save(Iban ibanInstance) {
        if (ibanInstance == null) {
            notFound()
            return
        }

        ibanInstance.iban=Iban.normalize(ibanInstance.iban)
        if (ibanInstance.hasErrors()) {
            respond ibanInstance.errors, view:'create'
            return
        }

        ibanInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [
                        message(code: 'eventInstance.label', default: 'Iban'),
                        ibanInstance.id
                ]
                )
                redirect ibanInstance
            }
            '*' { respond ibanInstance, [status: CREATED] }
        }
    }
}