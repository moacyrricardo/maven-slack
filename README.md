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
<version>1.1.0-SNAPSHOT</version>
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
        <!-- a channel or a @devmate -->
        <channel>@devmate</channel>
        <message>Short message</message>
        <fields>
          <field>
            <value>Field 1 value</value>
          </field>
        </fields>
        <!-- OPTIONAL -->
        <attachments>
          <attachment>
            <fallback>Required plain-text summary of the attachment.</fallback>
            <color>#36a64f</color>
            <pretext>Optional text that appears above the attachment block</pretext>
            <author_name>Bobby Tables</author_name>
            <author_link>http://flickr.com/bobby/</author_link>
            <author_icon>http://flickr.com/icons/bobby.jpg</author_icon>
            <title>Slack API Documentation</title>
            <title_link>https://api.slack.com/</title_link>
            <text>Optional text that appears within the attachment</text>
            <fields>
              <title>Priority</title>
              <value>High</value>
              <short>false</short>
            </fields>
            <image_url>http://my-website.com/path/to/image.jpg</image_url>
            <thumb_url>http://example.com/path/to/thumb.png</thumb_url>
          </attachment>
        </attachments>
      </configuration>
    </execution>
  </executions>
</plugin>
```
