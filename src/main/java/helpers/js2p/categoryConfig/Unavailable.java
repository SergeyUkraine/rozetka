package helpers.js2p.categoryConfig;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "image",
    "title",
    "brand",
    "description",
    "status",
    "wishlist_button",
    "compare_button",
    "buy_button",
    "price",
    "old_price",
    "promo_price",
    "visa_price",
    "rating",
    "tags",
    "tags_technical",
    "bonus",
    "gift",
    "size"
})
public class Unavailable {

    @JsonProperty("image")
    private Boolean image;
    @JsonProperty("title")
    private Boolean title;
    @JsonProperty("brand")
    private Boolean brand;
    @JsonProperty("description")
    private Boolean description;
    @JsonProperty("status")
    private Boolean status;
    @JsonProperty("wishlist_button")
    private Boolean wishlistButton;
    @JsonProperty("compare_button")
    private Boolean compareButton;
    @JsonProperty("buy_button")
    private Boolean buyButton;
    @JsonProperty("price")
    private Boolean price;
    @JsonProperty("old_price")
    private Boolean oldPrice;
    @JsonProperty("promo_price")
    private Boolean promoPrice;
    @JsonProperty("visa_price")
    private Boolean visaPrice;
    @JsonProperty("rating")
    private Boolean rating;
    @JsonProperty("tags")
    private Boolean tags;
    @JsonProperty("tags_technical")
    private Boolean tagsTechnical;
    @JsonProperty("bonus")
    private Boolean bonus;
    @JsonProperty("gift")
    private Boolean gift;
    @JsonProperty("size")
    private Boolean size;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("image")
    public Boolean getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Boolean image) {
        this.image = image;
    }

    @JsonProperty("title")
    public Boolean getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(Boolean title) {
        this.title = title;
    }

    @JsonProperty("brand")
    public Boolean getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(Boolean brand) {
        this.brand = brand;
    }

    @JsonProperty("description")
    public Boolean getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Boolean description) {
        this.description = description;
    }

    @JsonProperty("status")
    public Boolean getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @JsonProperty("wishlist_button")
    public Boolean getWishlistButton() {
        return wishlistButton;
    }

    @JsonProperty("wishlist_button")
    public void setWishlistButton(Boolean wishlistButton) {
        this.wishlistButton = wishlistButton;
    }

    @JsonProperty("compare_button")
    public Boolean getCompareButton() {
        return compareButton;
    }

    @JsonProperty("compare_button")
    public void setCompareButton(Boolean compareButton) {
        this.compareButton = compareButton;
    }

    @JsonProperty("buy_button")
    public Boolean getBuyButton() {
        return buyButton;
    }

    @JsonProperty("buy_button")
    public void setBuyButton(Boolean buyButton) {
        this.buyButton = buyButton;
    }

    @JsonProperty("price")
    public Boolean getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Boolean price) {
        this.price = price;
    }

    @JsonProperty("old_price")
    public Boolean getOldPrice() {
        return oldPrice;
    }

    @JsonProperty("old_price")
    public void setOldPrice(Boolean oldPrice) {
        this.oldPrice = oldPrice;
    }

    @JsonProperty("promo_price")
    public Boolean getPromoPrice() {
        return promoPrice;
    }

    @JsonProperty("promo_price")
    public void setPromoPrice(Boolean promoPrice) {
        this.promoPrice = promoPrice;
    }

    @JsonProperty("visa_price")
    public Boolean getVisaPrice() {
        return visaPrice;
    }

    @JsonProperty("visa_price")
    public void setVisaPrice(Boolean visaPrice) {
        this.visaPrice = visaPrice;
    }

    @JsonProperty("rating")
    public Boolean getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Boolean rating) {
        this.rating = rating;
    }

    @JsonProperty("tags")
    public Boolean getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Boolean tags) {
        this.tags = tags;
    }

    @JsonProperty("tags_technical")
    public Boolean getTagsTechnical() {
        return tagsTechnical;
    }

    @JsonProperty("tags_technical")
    public void setTagsTechnical(Boolean tagsTechnical) {
        this.tagsTechnical = tagsTechnical;
    }

    @JsonProperty("bonus")
    public Boolean getBonus() {
        return bonus;
    }

    @JsonProperty("bonus")
    public void setBonus(Boolean bonus) {
        this.bonus = bonus;
    }

    @JsonProperty("gift")
    public Boolean getGift() {
        return gift;
    }

    @JsonProperty("gift")
    public void setGift(Boolean gift) {
        this.gift = gift;
    }

    @JsonProperty("size")
    public Boolean getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Boolean size) {
        this.size = size;
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
        return new ToStringBuilder(this).append("image", image).append("title", title).append("brand", brand).append("description", description).append("status", status).append("wishlistButton", wishlistButton).append("compareButton", compareButton).append("buyButton", buyButton).append("price", price).append("oldPrice", oldPrice).append("promoPrice", promoPrice).append("visaPrice", visaPrice).append("rating", rating).append("tags", tags).append("tagsTechnical", tagsTechnical).append("bonus", bonus).append("gift", gift).append("size", size).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(gift).append(image).append(oldPrice).append(bonus).append(rating).append(description).append(title).append(wishlistButton).append(buyButton).append(tags).append(promoPrice).append(compareButton).append(size).append(price).append(additionalProperties).append(brand).append(visaPrice).append(status).append(tagsTechnical).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Unavailable) == false) {
            return false;
        }
        Unavailable rhs = ((Unavailable) other);
        return new EqualsBuilder().append(gift, rhs.gift).append(image, rhs.image).append(oldPrice, rhs.oldPrice).append(bonus, rhs.bonus).append(rating, rhs.rating).append(description, rhs.description).append(title, rhs.title).append(wishlistButton, rhs.wishlistButton).append(buyButton, rhs.buyButton).append(tags, rhs.tags).append(promoPrice, rhs.promoPrice).append(compareButton, rhs.compareButton).append(size, rhs.size).append(price, rhs.price).append(additionalProperties, rhs.additionalProperties).append(brand, rhs.brand).append(visaPrice, rhs.visaPrice).append(status, rhs.status).append(tagsTechnical, rhs.tagsTechnical).isEquals();
    }

}
