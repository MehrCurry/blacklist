package blacklist

class Email {
    String address
    static belongsTo = [blacklist:Blacklist]

    static constraints = {
        address email: true
    }

    static String normalize(String anEmail) {
        anEmail.toLowerCase().replaceAll('\\+.*@','@')
    }
    def matches(other) {
        address.equalsIgnoreCase(other)
    }

    String toString() {
        address
    }
}
