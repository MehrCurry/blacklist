package blacklist

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.PUT
import javax.ws.rs.core.Response

import org.grails.jaxrs.provider.DomainObjectNotFoundException

@Consumes(['application/xml', 'application/json'])
@Produces(['application/xml', 'application/json'])
class IbanBlacklistEntryResource {

    def ibanBlacklistEntryResourceService
    def id

    @GET
    Response read() {
        ok ibanBlacklistEntryResourceService.read(id)
    }

    @PUT
    Response update(IbanBlacklistEntry dto) {
        dto.id = id
        ok ibanBlacklistEntryResourceService.update(dto)
    }

    @DELETE
    void delete() {
        ibanBlacklistEntryResourceService.delete(id)
    }
}
