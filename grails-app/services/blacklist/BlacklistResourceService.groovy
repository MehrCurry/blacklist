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
        def ibans=Iban.withCriteria {
            blacklist {
                eq("mid",mid)
            }
        }
        ibans.findAll {it.matches(value)}
    }

    def checkEmail(mid,value) {
        def emails=Email.withCriteria {
            blacklist {
                eq("mid",mid)
            }
        }
        emails.findAll {it.matches(value)}
    }
}
