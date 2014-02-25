package blacklist

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.POST
import javax.ws.rs.core.Response

@Path('/api/ibanBlacklistEntry')
@Consumes(['application/xml', 'application/json'])
@Produces(['application/xml', 'application/json'])
class IbanBlacklistEntryCollectionResource {

    def ibanBlacklistEntryResourceService

    @POST
    Response create(IbanBlacklistEntry dto) {
        created ibanBlacklistEntryResourceService.create(dto)
    }

    @GET
    Response readAll() {
        ok ibanBlacklistEntryResourceService.readAll()
    }

    @Path('/{id}')
    IbanBlacklistEntryResource getResource(@PathParam('id') Long id) {
        new IbanBlacklistEntryResource(ibanBlacklistEntryResourceService: ibanBlacklistEntryResourceService, id: id)
    }
}
