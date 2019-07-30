package helpers.js2p.goodsCard;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "is_auction",
    "title",
    "description",
    "url",
    "url_title",
    "order",
    "image_url",
    "width",
    "height"
})
public class TagsTechnical {

    @JsonProperty("is_auction")
    private Boolean isAuction;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("url")
    private Object url;
    @JsonProperty("url_title")
    private Object urlTitle;
    @JsonProperty("order")
    private Integer order;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("is_auction")
    public Boolean getIsAuction() {
        return isAuction;
    }

    @JsonProperty("is_auction")
    public void setIsAuction(Boolean isAuction) {
        this.isAuction = isAuction;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("url")
    public Object getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(Object url) {
        this.url = url;
    }

    @JsonProperty("url_title")
    public Object getUrlTitle() {
        return urlTitle;
    }

    @JsonProperty("url_title")
    public void setUrlTitle(Object urlTitle) {
        this.urlTitle = urlTitle;
    }

    @JsonProperty("order")
    public Integer getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(Integer order) {
        this.order = order;
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("isAuction", isAuction).append("title", title).append("description", description).append("url", url).append("urlTitle", urlTitle).append("order", order).append("imageUrl", imageUrl).append("width", width).append("height", height).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(urlTitle).append(isAuction).append(imageUrl).append(width).append(description).append(additionalProperties).append(title).append(url).append(order).append(height).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TagsTechnical) == false) {
            return false;
        }
        TagsTechnical rhs = ((TagsTechnical) other);
        return new EqualsBuilder().append(urlTitle, rhs.urlTitle).append(isAuction, rhs.isAuction).append(imageUrl, rhs.imageUrl).append(width, rhs.width).append(description, rhs.description).append(additionalProperties, rhs.additionalProperties).append(title, rhs.title).append(url, rhs.url).append(order, rhs.order).append(height, rhs.height).isEquals();
    }

}
