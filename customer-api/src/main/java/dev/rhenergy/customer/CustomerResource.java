package dev.rhenergy.customer;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/api/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerResource.class);

    @Inject
    CustomerService customerService;

    @GET
    @APIResponse(responseCode = "200",
            description = "Get All Customers",
            content = @Content(mediaType = "application/json", schema = @Schema(type = SchemaType.ARRAY, implementation = Customer.class)))
    public Response get() {
        return Response.ok(customerService.findAll()).build();
    }

    @GET
    @Path("/{customerId}")
    @APIResponse(responseCode = "200",
            description = "Get Customer by customerId",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(type = SchemaType.OBJECT, implementation = Customer.class)))
    @APIResponse( responseCode = "404",
            description = "No Customer found for customerId provided",
            content = @Content(mediaType = "application/json"))
    public Response getById(@PathParam("customerId") Integer customerId) {
        Optional<Customer> optional = customerService.findById(customerId);
        return optional.isPresent() ? Response.ok(optional.get()).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @APIResponse( responseCode = "201",
            description = "Customer Created",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(type = SchemaType.OBJECT, implementation = Customer.class)))
    @APIResponse(responseCode = "400",
            description = "Customer already exists for customerId",
            content = @Content(mediaType = "application/json"))
    public Response post(@Valid Customer customer) {
        final Customer saved = customerService.save(customer);
        return Response.status(Response.Status.CREATED).entity(saved).build();
    }

    @PUT
    @APIResponse( responseCode = "200",
            description = "Customer updated",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(type = SchemaType.OBJECT, implementation = Customer.class)))
    @APIResponse(responseCode = "404",
            description = "No Customer found for customerId provided",
            content = @Content(mediaType = "application/json"))
    public Response put(@Valid Customer customer) {
        final Customer saved = customerService.update(customer);
        return Response.ok(saved).build();
    }
}