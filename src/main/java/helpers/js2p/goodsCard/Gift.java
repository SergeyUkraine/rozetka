package helpers.js2p.goodsCard;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "promotion_title",
    "promotion_url",
    "image_url",
    "image_width",
    "image_height",
    "gift_id"
})
public class Gift {

    @JsonProperty("promotion_title")
    private String promotionTitle;
    @JsonProperty("promotion_url")
    private String promotionUrl;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("image_width")
    private Integer imageWidth;
    @JsonProperty("image_height")
    private Integer imageHeight;
    @JsonProperty("gift_id")
    private Integer giftId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("promotion_title")
    public String getPromotionTitle() {
        return promotionTitle;
    }

    @JsonProperty("promotion_title")
    public void setPromotionTitle(String promotionTitle) {
        this.promotionTitle = promotionTitle;
    }

    @JsonProperty("promotion_url")
    public String getPromotionUrl() {
        return promotionUrl;
    }

    @JsonProperty("promotion_url")
    public void setPromotionUrl(String promotionUrl) {
        this.promotionUrl = promotionUrl;
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("image_width")
    public Integer getImageWidth() {
        return imageWidth;
    }

    @JsonProperty("image_width")
    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    @JsonProperty("image_height")
    public Integer getImageHeight() {
        return imageHeight;
    }

    @JsonProperty("image_height")
    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    @JsonProperty("gift_id")
    public Integer getGiftId() {
        return giftId;
    }

    @JsonProperty("gift_id")
    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
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
        return new ToStringBuilder(this).append("promotionTitle", promotionTitle).append("promotionUrl", promotionUrl).append("imageUrl", imageUrl).append("imageWidth", imageWidth).append("imageHeight", imageHeight).append("giftId", giftId).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(promotionUrl).append(imageWidth).append(giftId).append(promotionTitle).append(imageUrl).append(additionalProperties).append(imageHeight).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Gift) == false) {
            return false;
        }
        Gift rhs = ((Gift) other);
        return new EqualsBuilder().append(promotionUrl, rhs.promotionUrl).append(imageWidth, rhs.imageWidth).append(giftId, rhs.giftId).append(promotionTitle, rhs.promotionTitle).append(imageUrl, rhs.imageUrl).append(additionalProperties, rhs.additionalProperties).append(imageHeight, rhs.imageHeight).isEquals();
    }

}
