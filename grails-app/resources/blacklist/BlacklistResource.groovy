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
class BlacklistResource {

    def blacklistResourceService
    def id

    @GET
    Response read() {
        ok blacklistResourceService.read(id)
    }

    @PUT
    Response update(Blacklist dto) {
        dto.id = id
        ok blacklistResourceService.update(dto)
    }

    @DELETE
    void delete() {
        blacklistResourceService.delete(id)
    }
}
