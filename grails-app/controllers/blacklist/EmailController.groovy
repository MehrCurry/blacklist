package blacklist

import grails.transaction.Transactional
import org.apache.shiro.authz.annotation.RequiresRoles

@RequiresRoles('ROLE_ADMIN')
class EmailController {
    static scaffold = true

    @Transactional
    def save(Email instance) {
        if (instance == null) {
            notFound()
            return
        }

        instance.address=Email.normalize(instance.iban)
        if (instance.hasErrors()) {
            respond instance.errors, view:'create'
            return
        }

        instance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [
                        message(code: 'eventInstance.label', default: 'Email'),
                        instance.id
                ]
                )
                redirect instance
            }
            '*' { respond instance, [status: CREATED] }
        }
    }

}
