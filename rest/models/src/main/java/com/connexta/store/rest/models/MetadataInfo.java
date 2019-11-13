package com.connexta.store.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.net.URL;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** Information representing Metadata. */
public class MetadataInfo {

  @JsonProperty("metadataType")
  private String metadataType;

  @JsonProperty("location")
  private URL location;

  public MetadataInfo metadataType(String metadataType) {
    this.metadataType = metadataType;
    return this;
  }

  @ApiModelProperty(example = "irm", required = true, value = "The type of metadata.")
  @NotNull
  @Size(min = 1, max = 80)
  public String getMetadataType() {
    return metadataType;
  }

  public void setMetadataType(String metadataType) {
    this.metadataType = metadataType;
  }

  public MetadataInfo location(URL location) {
    this.location = location;
    return this;
  }

  /**
   * The URL for where the metadata is located.
   *
   * @return location
   */
  @ApiModelProperty(
      example = "https://www.example.com/mis/30f14c6c1fc85cba12bfd093aa8f90e3",
      value = "The URL for where the metadata is located.")
  public URL getLocation() {
    return location;
  }

  public void setLocation(URL location) {
    this.location = location;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetadataInfo metadataInformation = (MetadataInfo) o;
    return Objects.equals(this.metadataType, metadataInformation.metadataType)
        && Objects.equals(this.location, metadataInformation.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        metadataType,
        location);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetadataInformation {\n");
    sb.append("    metadataType: ").append(toIndentedString(metadataType)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
