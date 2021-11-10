
package org.rest.recursos;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.rest.modelo.usuario;
import org.rest.servicio.UsuarioServicio;



@Path("/usuarios")
public class UsuarioRecurso {
    UsuarioServicio servicio = new UsuarioServicio();
   @GET
  @Produces(MediaType.APPLICATION_JSON)
   public List<usuario> getUsuario(){
   return servicio.getUsuarios();
   }
   
   
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public usuario addUsuario(usuario usu){
   return servicio.addUsuario(usu);
   }
    
   @DELETE
    @Path("/{usuarioId}")
    public void deleteUsuario(@PathParam("usuarioId") int id) {
      servicio.deleteUsuario(id);
    }
    
   @PUT
   @Path("/{usuarioId}")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public usuario updateUsurio(@PathParam("usuarioId")int id, usuario usu){
   usu.setId(id);
   return servicio.updateUsuario(usu);
   }
}
