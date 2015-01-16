package br.com.kibutx.slackmavenplugin;

import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import br.com.kibutx.slackmavenplugin.api.Field;
import br.com.kibutx.slackmavenplugin.api.SlackApiFactory;
import br.com.kibutx.slackmavenplugin.api.SlackMessage;

/**
 * Sends a message to a slack channel
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
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

	public void execute() throws MojoExecutionException {
		getLog().info("Starting SlackMessage to '"+apiHash+"'");
		getLog().debug("\t with message '"+message+"'");
		SlackMessage msg = new SlackMessage();
		msg.setFallback(message);
		msg.setPretext(message);
		msg.setColor(color);
		msg.setChannel(channel);
		if(fields != null && !fields.isEmpty()){
			msg.setFields(fields);
		}
		String ret = SlackApiFactory.getClient().sendMessage(apiHash, msg);
		getLog().debug("Return: "+ret);
		if(!ret.trim().equalsIgnoreCase("ok")){
			throw new MojoExecutionException("Error sending msg to slack.com. Returned: "+ret);
		}
		getLog().info("Message sent :)");
	}
	
}