
package br.com.kibutx.slackmavenplugin.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "fallback",
    "color",
    "pretext",
    "author_name",
    "author_link",
    "author_icon",
    "title",
    "title_link",
    "text",
    "fields",
    "image_url",
    "thumb_url"
})
public class Attachment {

    @JsonProperty("fallback")
    private String fallback;
    @JsonProperty("color")
    private String color;
    @JsonProperty("pretext")
    private String pretext;
    @JsonProperty("author_name")
    private String author_name;
    @JsonProperty("author_link")
    private String author_link;
    @JsonProperty("author_icon")
    private String author_icon;
    @JsonProperty("title")
    private String title;
    @JsonProperty("title_link")
    private String title_link;
    @JsonProperty("text")
    private String text;
    @JsonProperty("fields")
    private List<Field> fields = new ArrayList<Field>();
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("thumb_url")
    private String thumb_url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The fallback
     */
    @JsonProperty("fallback")
    public String getFallback() {
        return fallback;
    }

    /**
     * 
     * @param fallback
     *     The fallback
     */
    @JsonProperty("fallback")
    public void setFallback(String fallback) {
        this.fallback = fallback;
    }

    /**
     * 
     * @return
     *     The color
     */
    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    /**
     * 
     * @param color
     *     The color
     */
    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 
     * @return
     *     The pretext
     */
    @JsonProperty("pretext")
    public String getPretext() {
        return pretext;
    }

    /**
     * 
     * @param pretext
     *     The pretext
     */
    @JsonProperty("pretext")
    public void setPretext(String pretext) {
        this.pretext = pretext;
    }

    /**
     * 
     * @return
     *     The authorName
     */
    @JsonProperty("author_name")
    public String getAuthor_name() {
        return author_name;
    }

    /**
     * 
     * @param authorName
     *     The author_name
     */
    @JsonProperty("author_name")
    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    /**
     * 
     * @return
     *     The authorLink
     */
    @JsonProperty("author_link")
    public String getAuthor_link() {
        return author_link;
    }

    /**
     * 
     * @param authorLink
     *     The author_link
     */
    @JsonProperty("author_link")
    public void setAuthor_link(String author_link) {
        this.author_link = author_link;
    }

    /**
     * 
     * @return
     *     The authorIcon
     */
    @JsonProperty("author_icon")
    public String getAuthor_icon() {
        return author_icon;
    }

    /**
     * 
     * @param authorIcon
     *     The author_icon
     */
    @JsonProperty("author_icon")
    public void setAuthor_icon(String authorIcon) {
        this.author_icon = authorIcon;
    }

    /**
     * 
     * @return
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The titleLink
     */
    @JsonProperty("title_link")
    public String getTitle_link() {
        return title_link;
    }

    /**
     * 
     * @param titleLink
     *     The title_link
     */
    @JsonProperty("title_link")
    public void setTitle_link(String title_link) {
        this.title_link = title_link;
    }

    /**
     * 
     * @return
     *     The text
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The fields
     */
    @JsonProperty("fields")
    public List<Field> getFields() {
        return fields;
    }

    /**
     * 
     * @param fields
     *     The fields
     */
    @JsonProperty("fields")
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    /**
     * 
     * @return
     *     The imageUrl
     */
    @JsonProperty("image_url")
    public String getImage_url() {
        return image_url;
    }

    /**
     * 
     * @param imageUrl
     *     The image_url
     */
    @JsonProperty("image_url")
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    /**
     * 
     * @return
     *     The thumbUrl
     */
    @JsonProperty("thumb_url")
    public String getThumb_url() {
        return thumb_url;
    }

    /**
     * 
     * @param thumbUrl
     *     The thumb_url
     */
    @JsonProperty("thumb_url")
    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
