package helpers.js2p.goodsCard;

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
    "id",
    "title",
    "price",
    "old_price",
    "price_pcs",
    "href",
    "comments_amount",
    "sell_status",
    "comments_mark",
    "category_id",
    "seller_id",
    "merchant_id",
    "brand",
    "brand_id",
    "group_id",
    "pl_bonus_charge_pcs",
    "pl_use_instant_bonus",
    "state",
    "docket",
    "promo_price",
    "discount",
    "stars",
    "parent_category_id",
    "tag",
    "tags_technical",
    "gift",
    "is_docket",
    "image_main",
    "images",
    "root_id",
    "groups"
})
public class Datum {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("price")
    private String price;
    @JsonProperty("old_price")
    private String oldPrice;
    @JsonProperty("price_pcs")
    private String pricePcs;
    @JsonProperty("href")
    private String href;
    @JsonProperty("comments_amount")
    private Integer commentsAmount;
    @JsonProperty("sell_status")
    private String sellStatus;
    @JsonProperty("comments_mark")
    private String commentsMark;
    @JsonProperty("category_id")
    private Integer categoryId;
    @JsonProperty("seller_id")
    private Integer sellerId;
    @JsonProperty("merchant_id")
    private Integer merchantId;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("brand_id")
    private Integer brandId;
    @JsonProperty("group_id")
    private Integer groupId;
    @JsonProperty("pl_bonus_charge_pcs")
    private Integer plBonusChargePcs;
    @JsonProperty("pl_use_instant_bonus")
    private Integer plUseInstantBonus;
    @JsonProperty("state")
    private String state;
    @JsonProperty("docket")
    private String docket;
    @JsonProperty("promo_price")
    private PromoPrice promoPrice;
    @JsonProperty("discount")
    private Integer discount;
    @JsonProperty("stars")
    private String stars;
    @JsonProperty("parent_category_id")
    private Integer parentCategoryId;
    @JsonProperty("tag")
    private Tag tag;
    @JsonProperty("tags_technical")
    private List<TagsTechnical> tagsTechnical = new ArrayList<TagsTechnical>();
    @JsonProperty("gift")
    private Gift gift;
    @JsonProperty("is_docket")
    private Boolean isDocket;
    @JsonProperty("image_main")
    private String imageMain;
    @JsonProperty("images")
    private Images images;
    @JsonProperty("root_id")
    private Integer rootId;
    @JsonProperty("groups")
//    private Groups groups;
//    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("old_price")
    public String getOldPrice() {
        return oldPrice;
    }

    @JsonProperty("old_price")
    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    @JsonProperty("price_pcs")
    public String getPricePcs() {
        return pricePcs;
    }

    @JsonProperty("price_pcs")
    public void setPricePcs(String pricePcs) {
        this.pricePcs = pricePcs;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("comments_amount")
    public Integer getCommentsAmount() {
        return commentsAmount;
    }

    @JsonProperty("comments_amount")
    public void setCommentsAmount(Integer commentsAmount) {
        this.commentsAmount = commentsAmount;
    }

    @JsonProperty("sell_status")
    public String getSellStatus() {
        return sellStatus;
    }

    @JsonProperty("sell_status")
    public void setSellStatus(String sellStatus) {
        this.sellStatus = sellStatus;
    }

    @JsonProperty("comments_mark")
    public String getCommentsMark() {
        return commentsMark;
    }

    @JsonProperty("comments_mark")
    public void setCommentsMark(String commentsMark) {
        this.commentsMark = commentsMark;
    }

    @JsonProperty("category_id")
    public Integer getCategoryId() {
        return categoryId;
    }

    @JsonProperty("category_id")
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("seller_id")
    public Integer getSellerId() {
        return sellerId;
    }

    @JsonProperty("seller_id")
    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @JsonProperty("merchant_id")
    public Integer getMerchantId() {
        return merchantId;
    }

    @JsonProperty("merchant_id")
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonProperty("brand_id")
    public Integer getBrandId() {
        return brandId;
    }

    @JsonProperty("brand_id")
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @JsonProperty("group_id")
    public Integer getGroupId() {
        return groupId;
    }

    @JsonProperty("group_id")
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @JsonProperty("pl_bonus_charge_pcs")
    public Integer getPlBonusChargePcs() {
        return plBonusChargePcs;
    }

    @JsonProperty("pl_bonus_charge_pcs")
    public void setPlBonusChargePcs(Integer plBonusChargePcs) {
        this.plBonusChargePcs = plBonusChargePcs;
    }

    @JsonProperty("pl_use_instant_bonus")
    public Integer getPlUseInstantBonus() {
        return plUseInstantBonus;
    }

    @JsonProperty("pl_use_instant_bonus")
    public void setPlUseInstantBonus(Integer plUseInstantBonus) {
        this.plUseInstantBonus = plUseInstantBonus;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("docket")
    public String getDocket() {
        return docket;
    }

    @JsonProperty("docket")
    public void setDocket(String docket) {
        this.docket = docket;
    }

    @JsonProperty("promo_price")
    public PromoPrice getPromoPrice() {
        return promoPrice;
    }

    @JsonProperty("promo_price")
    public void setPromoPrice(PromoPrice promoPrice) {
        this.promoPrice = promoPrice;
    }

    @JsonProperty("discount")
    public Integer getDiscount() {
        return discount;
    }

    @JsonProperty("discount")
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @JsonProperty("stars")
    public String getStars() {
        return stars;
    }

    @JsonProperty("stars")
    public void setStars(String stars) {
        this.stars = stars;
    }

    @JsonProperty("parent_category_id")
    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    @JsonProperty("parent_category_id")
    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    @JsonProperty("tag")
    public Tag getTag() {
        return tag;
    }

    @JsonProperty("tag")
    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @JsonProperty("tags_technical")
    public List<TagsTechnical> getTagsTechnical() {
        return tagsTechnical;
    }

    @JsonProperty("tags_technical")
    public void setTagsTechnical(List<TagsTechnical> tagsTechnical) {
        this.tagsTechnical = tagsTechnical;
    }

    @JsonProperty("gift")
    public Gift getGift() {
        return gift;
    }

    @JsonProperty("gift")
    public void setGift(Gift gift) {
        this.gift = gift;
    }

    @JsonProperty("is_docket")
    public Boolean getIsDocket() {
        return isDocket;
    }

    @JsonProperty("is_docket")
    public void setIsDocket(Boolean isDocket) {
        this.isDocket = isDocket;
    }

    @JsonProperty("image_main")
    public String getImageMain() {
        return imageMain;
    }

    @JsonProperty("image_main")
    public void setImageMain(String imageMain) {
        this.imageMain = imageMain;
    }

    @JsonProperty("images")
    public Images getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(Images images) {
        this.images = images;
    }

    @JsonProperty("root_id")
    public Integer getRootId() {
        return rootId;
    }

    @JsonProperty("root_id")
    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

//    @JsonProperty("groups")
//    public Groups getGroups() {
//        return groups;
//    }
//
//    @JsonProperty("groups")
//    public void setGroups(Groups groups) {
//        this.groups = groups;
//    }

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
        return new ToStringBuilder(this).append("id", id).append("title", title).append("price", price).append("oldPrice", oldPrice).append("pricePcs", pricePcs).append("href", href).append("commentsAmount", commentsAmount).append("sellStatus", sellStatus).append("commentsMark", commentsMark).append("categoryId", categoryId).append("sellerId", sellerId).append("merchantId", merchantId).append("brand", brand).append("brandId", brandId).append("groupId", groupId).append("plBonusChargePcs", plBonusChargePcs).append("plUseInstantBonus", plUseInstantBonus).append("state", state).append("docket", docket).append("promoPrice", promoPrice).append("discount", discount).append("stars", stars).append("parentCategoryId", parentCategoryId).append("tag", tag).append("tagsTechnical", tagsTechnical).append("gift", gift).append("isDocket", isDocket).append("imageMain", imageMain).append("images", images).append("rootId", rootId).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(gift).append(rootId).append(groupId).append(discount).append(title).append(docket).append(pricePcs).append(imageMain).append(sellerId).append(commentsMark).append(merchantId).append(price).append(id).append(href).append(state).append(tag).append(brand).append(commentsAmount).append(images).append(oldPrice).append(stars).append(isDocket).append(promoPrice).append(plBonusChargePcs).append(sellStatus).append(plUseInstantBonus).append(brandId).append(parentCategoryId).append(additionalProperties).append(categoryId).append(tagsTechnical).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Datum) == false) {
            return false;
        }
        Datum rhs = ((Datum) other);
        return new EqualsBuilder().append(gift, rhs.gift).append(rootId, rhs.rootId).append(groupId, rhs.groupId).append(discount, rhs.discount).append(title, rhs.title).append(docket, rhs.docket).append(pricePcs, rhs.pricePcs).append(imageMain, rhs.imageMain).append(sellerId, rhs.sellerId).append(commentsMark, rhs.commentsMark).append(merchantId, rhs.merchantId).append(price, rhs.price).append(id, rhs.id).append(href, rhs.href).append(state, rhs.state).append(tag, rhs.tag).append(brand, rhs.brand).append(commentsAmount, rhs.commentsAmount).append(images, rhs.images).append(oldPrice, rhs.oldPrice).append(stars, rhs.stars).append(isDocket, rhs.isDocket).append(promoPrice, rhs.promoPrice).append(plBonusChargePcs, rhs.plBonusChargePcs).append(sellStatus, rhs.sellStatus).append(plUseInstantBonus, rhs.plUseInstantBonus).append(brandId, rhs.brandId).append(parentCategoryId, rhs.parentCategoryId).append(additionalProperties, rhs.additionalProperties).append(categoryId, rhs.categoryId).append(tagsTechnical, rhs.tagsTechnical).isEquals();
    }

}
