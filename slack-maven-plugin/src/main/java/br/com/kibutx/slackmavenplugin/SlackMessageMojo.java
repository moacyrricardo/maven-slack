package br.com.kibutx.slackmavenplugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import br.com.kibutx.slackmavenplugin.api.Field;
import br.com.kibutx.slackmavenplugin.api.Attachment;
import br.com.kibutx.slackmavenplugin.api.SlackApiFactory;
import br.com.kibutx.slackmavenplugin.api.SlackMessage;

/**
 * Sends a message to a slack channel
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 * @param <Attachement>
 *
 */
@Mojo(name = "slackmessage")
public class SlackMessageMojo extends AbstractMojo {

	/**
	 * The api hash.<br/>
	 * Your hook will show you an url like:<br/><br/>
	 * https://hooks.slack.com/services/XXXXXXXXXX/YYYYYYYYY/ZZZZZZ<br/><br/>
	 * It might have <b>/</b> on the key, so this api key must be:<br/><br/>
	 * <i>XXXXXXXXXX/YYYYYYYYY/ZZZZZZ</i>
	 */
	@Parameter(required = true)
	private String apiHash;

	/**
	 * An optional channel that overrides default channel for this web hook integration
	 * <br/> can also user '@username' to send to a specific user
	 */
	@Parameter(required = false)
	private String channel;
	/**
	 * The username of message
	 */
	@Parameter(required = false)
	private String username;
	/**
	 * The message
	 */
	@Parameter(required = true)
	private String message;
	/**
	 * The color
	 */
	@Parameter(required = false, defaultValue="#00ADEF")
	private String color;
	/**
	 * An optional list of fields to be sent that overrides default channel for this web hook integration
	 */
	@Parameter(required = false)
	private List<Field> fields = new ArrayList<Field>();

	/**
	 * An optional list of attachments to be sent, such as a link
	 * to the artifact you've just built.
	 */
	@Parameter(required = false)
	private List<Attachment> attachments = new ArrayList<Attachment>();	
	
	public void execute() throws MojoExecutionException {
		getLog().info("Starting SlackMessage to '"+apiHash+"'");
		getLog().debug("\t with message '"+message+"'");
		SlackMessage msg = new SlackMessage();
		msg.setUsername(username);
		msg.setFallback(message);
		msg.setPretext(message);
		msg.setColor(color);
		msg.setChannel(channel);
		if(fields != null && !fields.isEmpty()){
			msg.setFields(fields);
		}
		if(attachments != null && !attachments.isEmpty()){
			msg.setAttachments(attachments);
		}
		
		try {
	       
	        ObjectMapper mapper = new ObjectMapper();
	        String msgString = mapper.writeValueAsString(msg);

	        getLog().info("Message Payload: \n" + msgString);
	        
	    } catch (JsonGenerationException e) {
	       e.printStackTrace();
	    } catch (JsonMappingException e) {
	       e.printStackTrace();
	    } catch (IOException e) {
	       e.printStackTrace();
	    }
		
		String ret = SlackApiFactory.getClient().sendMessage(apiHash, msg);
		getLog().debug("Return: "+ret);
		if(!ret.trim().equalsIgnoreCase("ok")){
			throw new MojoExecutionException("Error sending msg to slack.com. Returned: "+ret);
		}
		getLog().info("Message sent :)");
	}
	
}