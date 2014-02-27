package blacklist

import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit

class Iban {
    String iban
    static belongsTo = [blacklist:Blacklist]

    static constraints = {
        iban validator: { val -> IBANCheckDigit.IBAN_CHECK_DIGIT.isValid(normalize(val))}
    }

    static normalize(val) {
        val.replaceAll("\\s+","")
    }

    def matches(other) {
        iban == normalize(other)
    }

    String toString() {
        iban
    }
}
