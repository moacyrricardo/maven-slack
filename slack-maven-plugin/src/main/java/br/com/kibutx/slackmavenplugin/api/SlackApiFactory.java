package br.com.kibutx.slackmavenplugin.api;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

/**
 * 
 * @author <a href="http://github.com/diegoqueiroz5a">dqueiroz</a>
 * 
 */
public class SlackApiFactory {

	public static SlackApi getClient() {
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		HttpClient httpClient = HttpClientBuilder.create().setConnectionManager(cm).build();
		//
		ClientExecutor executor = new ApacheHttpClient4Executor(httpClient);
		// new ApacheHttpClient4Engine(httpClient);
		//
		SlackApi slackApi = ProxyFactory.create(SlackApi.class, "https://hooks.slack.com", executor);
		// ResteasyClient client = new ResteasyClientBuilder().httpEngine(new
		// ApacheHttpClient4Engine(httpClient)).build();
		// Client client = ResteasyClientBuilder.newClient();
		// ResteasyWebTarget target =
		// (ResteasyWebTarget)client.target("https://hooks.slack.com");
		// ResteasyWebTarget rtarget = (ResteasyWebTarget) target;

		// SlackApi slackApi = target.proxy(SlackApi.class);
		return slackApi;
	}
}
