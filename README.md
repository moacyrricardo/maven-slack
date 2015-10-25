# maven-slack
Maven Plugin for Slack Integration

Sends message through a webhook set on slack.

Adding repository:
----------------------
First, add s3 wagon extension:
```xml
  <build>  
     <extensions>  
       <extension>  
         <groupId>org.springframework.build.aws</groupId>  
         <artifactId>org.springframework.build.aws.maven</artifactId>  
         <version>3.0.0.RELEASE</version>  
       </extension>  
     </extensions>  
  </build>
```
Then add the plugin repository
```xml
<pluginRepository>
  <id>s3-moarepo</id>
  <url>s3://moarepo/release</url>
  <releases>  
     <enabled>true</enabled>  
   </releases>  
   <snapshots>  
     <enabled>false</enabled>  
   </snapshots> 
</pluginRepository>
<pluginRepository>
  <id>s3-moarepo-snapshot</id>
  <url>s3://moarepo/snapshot</url>
  <releases>  
     <enabled>false</enabled>  
   </releases>  
   <snapshots>  
     <enabled>true</enabled>  
   </snapshots> 
</pluginRepository>
```
Adding dependency
----------------------
```xml
<groupId>br.com.kibutx</groupId>
<artifactId>slack-maven-plugin</artifactId>
<version>1.0.0-SNAPSHOT</version>
```
Usage
======
apiHash: web hook will give a url like: webhook.slack.com/hash1/hash2/hash3. apiHash is "hash1/hash2/hash3"
channel: maybe a direct contact or a channel override (since webhooks are bound to a channel)
```xml
<plugin>
	<groupId>br.com.kibutx</groupId>
	<artifactId>slack-maven-plugin</artifactId>
	<version>1.0.0-SNAPSHOT</version>
	<executions>
		<execution>
			<id>MSG inicio deploy</id>
			<phase>validate</phase>
			<goals>
				<goal>slackmessage</goal>
			</goals>
			<configuration>
				<apiHash>hash1/hash2/hash3</apiHash>
        <username>Maven</username>
				<channel>@devmate</channel>
				<message>Short message</message>
				<fields>
					<field>
						<value>Field 1 value</value>
					</field>
				</fields>
			</configuration>
		</execution>
	</executions>
</plugin>
```
