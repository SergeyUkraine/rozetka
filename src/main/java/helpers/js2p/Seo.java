package helpers.js2p;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "footer",
    "h1",
    "is_first_page_only",
    "keywords",
    "link_next",
    "link_prev",
    "paginator_suffix",
    "robots",
    "title"
})
public class Seo {

    @JsonProperty("description")
    private String description;
    @JsonProperty("footer")
    private String footer;
    @JsonProperty("h1")
    private String h1;
    @JsonProperty("is_first_page_only")
    private Boolean isFirstPageOnly;
    @JsonProperty("keywords")
    private String keywords;
    @JsonProperty("link_next")
    private Boolean linkNext;
    @JsonProperty("link_prev")
    private Boolean linkPrev;
    @JsonProperty("paginator_suffix")
    private String paginatorSuffix;
    @JsonProperty("robots")
    private String robots;
    @JsonProperty("title")
    private String title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("footer")
    public String getFooter() {
        return footer;
    }

    @JsonProperty("footer")
    public void setFooter(String footer) {
        this.footer = footer;
    }

    @JsonProperty("h1")
    public String getH1() {
        return h1;
    }

    @JsonProperty("h1")
    public void setH1(String h1) {
        this.h1 = h1;
    }

    @JsonProperty("is_first_page_only")
    public Boolean getIsFirstPageOnly() {
        return isFirstPageOnly;
    }

    @JsonProperty("is_first_page_only")
    public void setIsFirstPageOnly(Boolean isFirstPageOnly) {
        this.isFirstPageOnly = isFirstPageOnly;
    }

    @JsonProperty("keywords")
    public String getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("link_next")
    public Boolean getLinkNext() {
        return linkNext;
    }

    @JsonProperty("link_next")
    public void setLinkNext(Boolean linkNext) {
        this.linkNext = linkNext;
    }

    @JsonProperty("link_prev")
    public Boolean getLinkPrev() {
        return linkPrev;
    }

    @JsonProperty("link_prev")
    public void setLinkPrev(Boolean linkPrev) {
        this.linkPrev = linkPrev;
    }

    @JsonProperty("paginator_suffix")
    public String getPaginatorSuffix() {
        return paginatorSuffix;
    }

    @JsonProperty("paginator_suffix")
    public void setPaginatorSuffix(String paginatorSuffix) {
        this.paginatorSuffix = paginatorSuffix;
    }

    @JsonProperty("robots")
    public String getRobots() {
        return robots;
    }

    @JsonProperty("robots")
    public void setRobots(String robots) {
        this.robots = robots;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
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
        return new ToStringBuilder(this).append("description", description).append("footer", footer).append("h1", h1).append("isFirstPageOnly", isFirstPageOnly).append("keywords", keywords).append("linkNext", linkNext).append("linkPrev", linkPrev).append("paginatorSuffix", paginatorSuffix).append("robots", robots).append("title", title).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(linkPrev).append(paginatorSuffix).append(keywords).append(footer).append(linkNext).append(description).append(h1).append(isFirstPageOnly).append(robots).append(additionalProperties).append(title).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Seo) == false) {
            return false;
        }
        Seo rhs = ((Seo) other);
        return new EqualsBuilder().append(linkPrev, rhs.linkPrev).append(paginatorSuffix, rhs.paginatorSuffix).append(keywords, rhs.keywords).append(footer, rhs.footer).append(linkNext, rhs.linkNext).append(description, rhs.description).append(h1, rhs.h1).append(isFirstPageOnly, rhs.isFirstPageOnly).append(robots, rhs.robots).append(additionalProperties, rhs.additionalProperties).append(title, rhs.title).isEquals();
    }

}
