package br.com.kibutx.slackmavenplugin.api;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 
 * @author <a href="http://github.com/diegoqueiroz5a">dqueiroz</a>
 * 
 */
public interface SlackApi {
	@POST
	@Path("/services/{apiCode:.*}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	String sendMessage(@PathParam("apiCode") String apiCode, SlackMessage message);
}