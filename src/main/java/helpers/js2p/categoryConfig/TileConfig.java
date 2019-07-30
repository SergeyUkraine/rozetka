package helpers.js2p.categoryConfig;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "template",
    "possible_templates",
    "title",
    "brand",
    "price",
    "old_price",
    "promo_price",
    "visa_price",
    "availability",
    "bonus",
    "wishlist_button",
    "compare_button",
    "buy_button",
    "rating",
    "gift",
    "tags",
    "tags_technical",
    "sell_statuses",
    "template_view"
})
public class TileConfig {

    @JsonProperty("template")
    private String template;
    @JsonProperty("possible_templates")
    private List<String> possibleTemplates = new ArrayList<String>();
    @JsonProperty("title")
    private Boolean title;
    @JsonProperty("brand")
    private Boolean brand;
    @JsonProperty("price")
    private Boolean price;
    @JsonProperty("old_price")
    private Boolean oldPrice;
    @JsonProperty("promo_price")
    private Boolean promoPrice;
    @JsonProperty("visa_price")
    private Boolean visaPrice;
    @JsonProperty("availability")
    private Boolean availability;
    @JsonProperty("bonus")
    private Boolean bonus;
    @JsonProperty("wishlist_button")
    private Boolean wishlistButton;
    @JsonProperty("compare_button")
    private Boolean compareButton;
    @JsonProperty("buy_button")
    private Boolean buyButton;
    @JsonProperty("rating")
    private Boolean rating;
    @JsonProperty("gift")
    private Boolean gift;
    @JsonProperty("tags")
    private Boolean tags;
    @JsonProperty("tags_technical")
    private Boolean tagsTechnical;
    @JsonProperty("sell_statuses")
    private SellStatuses sellStatuses;
    @JsonProperty("template_view")
    private String templateView;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty("possible_templates")
    public List<String> getPossibleTemplates() {
        return possibleTemplates;
    }

    @JsonProperty("possible_templates")
    public void setPossibleTemplates(List<String> possibleTemplates) {
        this.possibleTemplates = possibleTemplates;
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

    @JsonProperty("availability")
    public Boolean getAvailability() {
        return availability;
    }

    @JsonProperty("availability")
    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @JsonProperty("bonus")
    public Boolean getBonus() {
        return bonus;
    }

    @JsonProperty("bonus")
    public void setBonus(Boolean bonus) {
        this.bonus = bonus;
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

    @JsonProperty("rating")
    public Boolean getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Boolean rating) {
        this.rating = rating;
    }

    @JsonProperty("gift")
    public Boolean getGift() {
        return gift;
    }

    @JsonProperty("gift")
    public void setGift(Boolean gift) {
        this.gift = gift;
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

    @JsonProperty("sell_statuses")
    public SellStatuses getSellStatuses() {
        return sellStatuses;
    }

    @JsonProperty("sell_statuses")
    public void setSellStatuses(SellStatuses sellStatuses) {
        this.sellStatuses = sellStatuses;
    }

    @JsonProperty("template_view")
    public String getTemplateView() {
        return templateView;
    }

    @JsonProperty("template_view")
    public void setTemplateView(String templateView) {
        this.templateView = templateView;
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
        return new ToStringBuilder(this).append("template", template).append("possibleTemplates", possibleTemplates).append("title", title).append("brand", brand).append("price", price).append("oldPrice", oldPrice).append("promoPrice", promoPrice).append("visaPrice", visaPrice).append("availability", availability).append("bonus", bonus).append("wishlistButton", wishlistButton).append("compareButton", compareButton).append("buyButton", buyButton).append("rating", rating).append("gift", gift).append("tags", tags).append("tagsTechnical", tagsTechnical).append("sellStatuses", sellStatuses).append("templateView", templateView).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(template).append(gift).append(sellStatuses).append(oldPrice).append(bonus).append(rating).append(availability).append(templateView).append(title).append(wishlistButton).append(buyButton).append(possibleTemplates).append(tags).append(promoPrice).append(compareButton).append(price).append(additionalProperties).append(brand).append(visaPrice).append(tagsTechnical).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TileConfig) == false) {
            return false;
        }
        TileConfig rhs = ((TileConfig) other);
        return new EqualsBuilder().append(template, rhs.template).append(gift, rhs.gift).append(sellStatuses, rhs.sellStatuses).append(oldPrice, rhs.oldPrice).append(bonus, rhs.bonus).append(rating, rhs.rating).append(availability, rhs.availability).append(templateView, rhs.templateView).append(title, rhs.title).append(wishlistButton, rhs.wishlistButton).append(buyButton, rhs.buyButton).append(possibleTemplates, rhs.possibleTemplates).append(tags, rhs.tags).append(promoPrice, rhs.promoPrice).append(compareButton, rhs.compareButton).append(price, rhs.price).append(additionalProperties, rhs.additionalProperties).append(brand, rhs.brand).append(visaPrice, rhs.visaPrice).append(tagsTechnical, rhs.tagsTechnical).isEquals();
    }

}
