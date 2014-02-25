package blacklist

import org.grails.jaxrs.provider.DomainObjectNotFoundException

class IbanBlacklistEntryResourceService {

    def create(IbanBlacklistEntry dto) {
        dto.save()
    }

    def read(id) {
        def obj = IbanBlacklistEntry.get(id)
        if (!obj) {
            throw new DomainObjectNotFoundException(IbanBlacklistEntry.class, id)
        }
        obj
    }

    def readAll() {
        IbanBlacklistEntry.findAll()
    }

    def update(IbanBlacklistEntry dto) {
        def obj = IbanBlacklistEntry.get(dto.id)
        if (!obj) {
            throw new DomainObjectNotFoundException(IbanBlacklistEntry.class, dto.id)
        }
        obj.properties = dto.properties
        obj
    }

    void delete(id) {
        def obj = IbanBlacklistEntry.get(id)
        if (obj) {
            obj.delete()
        }
    }
}
