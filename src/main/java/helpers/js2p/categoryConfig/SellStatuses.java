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
    "unavailable",
    "waiting_for_supply",
    "limited",
    "available",
    "archive",
    "out_of_stock",
    "hidden",
    "default"
})
public class SellStatuses {

    @JsonProperty("unavailable")
    private Unavailable unavailable;
    @JsonProperty("waiting_for_supply")
    private WaitingForSupply waitingForSupply;
    @JsonProperty("limited")
    private Limited limited;
    @JsonProperty("available")
    private Available available;
    @JsonProperty("archive")
    private List<Object> archive = new ArrayList<Object>();
    @JsonProperty("out_of_stock")
    private OutOfStock outOfStock;
    @JsonProperty("hidden")
    private List<Object> hidden = new ArrayList<Object>();
    @JsonProperty("default")
    private Default _default;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("unavailable")
    public Unavailable getUnavailable() {
        return unavailable;
    }

    @JsonProperty("unavailable")
    public void setUnavailable(Unavailable unavailable) {
        this.unavailable = unavailable;
    }

    @JsonProperty("waiting_for_supply")
    public WaitingForSupply getWaitingForSupply() {
        return waitingForSupply;
    }

    @JsonProperty("waiting_for_supply")
    public void setWaitingForSupply(WaitingForSupply waitingForSupply) {
        this.waitingForSupply = waitingForSupply;
    }

    @JsonProperty("limited")
    public Limited getLimited() {
        return limited;
    }

    @JsonProperty("limited")
    public void setLimited(Limited limited) {
        this.limited = limited;
    }

    @JsonProperty("available")
    public Available getAvailable() {
        return available;
    }

    @JsonProperty("available")
    public void setAvailable(Available available) {
        this.available = available;
    }

    @JsonProperty("archive")
    public List<Object> getArchive() {
        return archive;
    }

    @JsonProperty("archive")
    public void setArchive(List<Object> archive) {
        this.archive = archive;
    }

    @JsonProperty("out_of_stock")
    public OutOfStock getOutOfStock() {
        return outOfStock;
    }

    @JsonProperty("out_of_stock")
    public void setOutOfStock(OutOfStock outOfStock) {
        this.outOfStock = outOfStock;
    }

    @JsonProperty("hidden")
    public List<Object> getHidden() {
        return hidden;
    }

    @JsonProperty("hidden")
    public void setHidden(List<Object> hidden) {
        this.hidden = hidden;
    }

    @JsonProperty("default")
    public Default getDefault() {
        return _default;
    }

    @JsonProperty("default")
    public void setDefault(Default _default) {
        this._default = _default;
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
        return new ToStringBuilder(this).append("unavailable", unavailable).append("waitingForSupply", waitingForSupply).append("limited", limited).append("available", available).append("archive", archive).append("outOfStock", outOfStock).append("hidden", hidden).append("_default", _default).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(_default).append(hidden).append(unavailable).append(limited).append(waitingForSupply).append(available).append(outOfStock).append(archive).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SellStatuses) == false) {
            return false;
        }
        SellStatuses rhs = ((SellStatuses) other);
        return new EqualsBuilder().append(_default, rhs._default).append(hidden, rhs.hidden).append(unavailable, rhs.unavailable).append(limited, rhs.limited).append(waitingForSupply, rhs.waitingForSupply).append(available, rhs.available).append(outOfStock, rhs.outOfStock).append(archive, rhs.archive).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
