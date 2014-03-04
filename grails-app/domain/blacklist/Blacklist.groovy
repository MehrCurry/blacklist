package blacklist

class Blacklist {
    Long mid
    String memo

    static hasMany = [ibans:Iban,emails:Email,bbans:Bban]

    static constraints = {
    }

    String toString() {
        memo + ":" + mid
    }
}
