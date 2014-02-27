package blacklist

import org.apache.commons.validator.routines.EmailValidator

class Email {
    String address
    static belongsTo = [blacklist:Blacklist]

    static constraints = {
        address validator: { val -> EmailValidator.instance.isValid(val)}
    }

    def matches(other) {
        address.equalsIgnoreCase(other)
    }
}
