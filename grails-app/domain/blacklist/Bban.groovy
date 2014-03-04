package blacklist

class Bban {
    String bban

    static belongsTo = [blacklist:Blacklist]

    static constraints = {
        bban numeric: true, matches: "[1-9][0-9]*"
    }

    static String normalize(bban) {
        bban.replaceFirst("^0*", "")
    }

    boolean matches(other) {
        bban.equalsIgnoreCase(normalize(other))
    }

    String toString() {
        bban
    }
}
