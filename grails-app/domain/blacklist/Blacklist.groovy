package blacklist

class Blacklist {
    Long mid
    String memo

    static hasMany = [ibanBlacklist:Iban,emailBlacklist:Email]

    static constraints = {
    }

    String toString() {
        memo + ":" + mid
    }
}
