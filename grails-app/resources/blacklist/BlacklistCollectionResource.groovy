package blacklist
import org.grails.jaxrs.response.Responses

import javax.ws.rs.*
import javax.ws.rs.core.Response

import static org.grails.jaxrs.response.Responses.created
import static org.grails.jaxrs.response.Responses.ok

@Path('/api/blacklist')
@Consumes(['application/xml', 'application/json'])
@Produces(['application/xml', 'application/json'])
class BlacklistCollectionResource {

    def blacklistResourceService
    def ibanResourceService

    @POST
    Response create(Blacklist dto) {
        created blacklistResourceService.create(dto)
    }

    @GET
    Response readAll() {
        ok blacklistResourceService.readAll()
    }

    @Path('/{id}')
    BlacklistResource getResource(@PathParam('id') Long id) {
        new BlacklistResource(blacklistResourceService: blacklistResourceService, id: id)
    }

    @GET
    @Path('/{id}/iban/{value}')
    Response checkIban(@PathParam('id') Long id,@PathParam('value') String value) {
        ok blacklistResourceService.checkIban(id,value)
    }

    @GET
    @Path('/{id}/email/{value}')
    Responses checkEmail(@PathParam('id') Long id,@PathParam('value') String value) {
        ok blacklistResourceService.checkEmail(id,value)
    }

}
