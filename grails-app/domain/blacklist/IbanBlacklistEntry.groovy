package blacklist

import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit

class IbanBlacklistEntry {
    String iban

    IbanBlacklistEntry(String iban) {
        this.iban = normalize(iban)
    }
    static constraints = {
        iban validator: { val -> IBANCheckDigit.IBAN_CHECK_DIGIT.isValid(normalize(val))}
    }

    static normalize(val) {
        val.replaceAll("\\s+","")
    }
}
