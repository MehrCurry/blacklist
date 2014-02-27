import blacklist.Blacklist
import blacklist.Email
import blacklist.Iban

class BootStrap {

    def init = { servletContext ->
        def bl=new Blacklist(memo: "Zocki",mid:24).save(failOnError: true)
        new Iban(blacklist: bl,iban:"HR1210010051863000160").save(failOnError: true)
        new Email(blacklist: bl,address:"duck@disney.com").save(failOnError: true)
    }

    def destroy = {
    }
}
