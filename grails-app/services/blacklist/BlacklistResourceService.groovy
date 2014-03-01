package blacklist

import org.grails.jaxrs.provider.DomainObjectNotFoundException

class BlacklistResourceService {

    def create(Blacklist dto) {
        dto.save()
    }

    def read(id) {
        def obj = Blacklist.findByMid(id)
        if (!obj) {
            throw new DomainObjectNotFoundException(Blacklist.class, id)
        }
        obj
    }

    def readAll() {
        Blacklist.findAll()
    }

    def update(Blacklist dto) {
        def obj = Blacklist.get(dto.id)
        if (!obj) {
            throw new DomainObjectNotFoundException(Blacklist.class, dto.id)
        }
        obj.properties = dto.properties
        obj
    }

    void delete(id) {
        def obj = Blacklist.get(id)
        if (obj) {
            obj.delete()
        }
    }

    def checkIban(mid,value) {
        Iban.withCriteria {
            blacklist {
                eq("mid",mid)
            }
        }.findAll {it.matches(value)}.isEmpty() ? "BLOCKED" : "OK"
    }

    def checkEmail(mid,value) {
        Email.withCriteria {
            blacklist {
                eq("mid",mid)
            }
        }.findAll {it.matches(value)}.isEmpty() ? "BLOCKED" : "OK"
    }
}
