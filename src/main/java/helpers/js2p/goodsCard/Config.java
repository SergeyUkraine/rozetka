package helpers.js2p.goodsCard;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bonus",
    "brand",
    "buy_button",
    "compare_button",
    "description",
    "gift",
    "image",
    "old_price",
    "price",
    "promo_price",
    "rating",
    "size",
    "status",
    "tags",
    "pictograms",
    "title",
    "visa_price",
    "wishlist_button"
})
public class Config {

    @JsonProperty("bonus")
    private Boolean bonus;
    @JsonProperty("brand")
    private Boolean brand;
    @JsonProperty("buy_button")
    private Boolean buyButton;
    @JsonProperty("compare_button")
    private Boolean compareButton;
    @JsonProperty("description")
    private Boolean description;
    @JsonProperty("gift")
    private Boolean gift;
    @JsonProperty("image")
    private Boolean image;
    @JsonProperty("old_price")
    private Boolean oldPrice;
    @JsonProperty("price")
    private Boolean price;
    @JsonProperty("promo_price")
    private Boolean promoPrice;
    @JsonProperty("rating")
    private Boolean rating;
    @JsonProperty("size")
    private Boolean size;
    @JsonProperty("status")
    private Boolean status;
    @JsonProperty("tags")
    private Boolean tags;
    @JsonProperty("pictograms")
    private Boolean pictograms;
    @JsonProperty("title")
    private Boolean title;
    @JsonProperty("visa_price")
    private Boolean visaPrice;
    @JsonProperty("wishlist_button")
    private Boolean wishlistButton;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bonus")
    public Boolean getBonus() {
        return bonus;
    }

    @JsonProperty("bonus")
    public void setBonus(Boolean bonus) {
        this.bonus = bonus;
    }

    @JsonProperty("brand")
    public Boolean getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(Boolean brand) {
        this.brand = brand;
    }

    @JsonProperty("buy_button")
    public Boolean getBuyButton() {
        return buyButton;
    }

    @JsonProperty("buy_button")
    public void setBuyButton(Boolean buyButton) {
        this.buyButton = buyButton;
    }

    @JsonProperty("compare_button")
    public Boolean getCompareButton() {
        return compareButton;
    }

    @JsonProperty("compare_button")
    public void setCompareButton(Boolean compareButton) {
        this.compareButton = compareButton;
    }

    @JsonProperty("description")
    public Boolean getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Boolean description) {
        this.description = description;
    }

    @JsonProperty("gift")
    public Boolean getGift() {
        return gift;
    }

    @JsonProperty("gift")
    public void setGift(Boolean gift) {
        this.gift = gift;
    }

    @JsonProperty("image")
    public Boolean getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Boolean image) {
        this.image = image;
    }

    @JsonProperty("old_price")
    public Boolean getOldPrice() {
        return oldPrice;
    }

    @JsonProperty("old_price")
    public void setOldPrice(Boolean oldPrice) {
        this.oldPrice = oldPrice;
    }

    @JsonProperty("price")
    public Boolean getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Boolean price) {
        this.price = price;
    }

    @JsonProperty("promo_price")
    public Boolean getPromoPrice() {
        return promoPrice;
    }

    @JsonProperty("promo_price")
    public void setPromoPrice(Boolean promoPrice) {
        this.promoPrice = promoPrice;
    }

    @JsonProperty("rating")
    public Boolean getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Boolean rating) {
        this.rating = rating;
    }

    @JsonProperty("size")
    public Boolean getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Boolean size) {
        this.size = size;
    }

    @JsonProperty("status")
    public Boolean getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @JsonProperty("tags")
    public Boolean getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Boolean tags) {
        this.tags = tags;
    }

    @JsonProperty("pictograms")
    public Boolean getPictograms() {
        return pictograms;
    }

    @JsonProperty("pictograms")
    public void setPictograms(Boolean pictograms) {
        this.pictograms = pictograms;
    }

    @JsonProperty("title")
    public Boolean getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(Boolean title) {
        this.title = title;
    }

    @JsonProperty("visa_price")
    public Boolean getVisaPrice() {
        return visaPrice;
    }

    @JsonProperty("visa_price")
    public void setVisaPrice(Boolean visaPrice) {
        this.visaPrice = visaPrice;
    }

    @JsonProperty("wishlist_button")
    public Boolean getWishlistButton() {
        return wishlistButton;
    }

    @JsonProperty("wishlist_button")
    public void setWishlistButton(Boolean wishlistButton) {
        this.wishlistButton = wishlistButton;
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
        return new ToStringBuilder(this).append("bonus", bonus).append("brand", brand).append("buyButton", buyButton).append("compareButton", compareButton).append("description", description).append("gift", gift).append("image", image).append("oldPrice", oldPrice).append("price", price).append("promoPrice", promoPrice).append("rating", rating).append("size", size).append("status", status).append("tags", tags).append("pictograms", pictograms).append("title", title).append("visaPrice", visaPrice).append("wishlistButton", wishlistButton).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(gift).append(image).append(bonus).append(oldPrice).append(rating).append(description).append(title).append(buyButton).append(wishlistButton).append(tags).append(promoPrice).append(compareButton).append(pictograms).append(size).append(price).append(additionalProperties).append(brand).append(visaPrice).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Config) == false) {
            return false;
        }
        Config rhs = ((Config) other);
        return new EqualsBuilder().append(gift, rhs.gift).append(image, rhs.image).append(bonus, rhs.bonus).append(oldPrice, rhs.oldPrice).append(rating, rhs.rating).append(description, rhs.description).append(title, rhs.title).append(buyButton, rhs.buyButton).append(wishlistButton, rhs.wishlistButton).append(tags, rhs.tags).append(promoPrice, rhs.promoPrice).append(compareButton, rhs.compareButton).append(pictograms, rhs.pictograms).append(size, rhs.size).append(price, rhs.price).append(additionalProperties, rhs.additionalProperties).append(brand, rhs.brand).append(visaPrice, rhs.visaPrice).append(status, rhs.status).isEquals();
    }

}
