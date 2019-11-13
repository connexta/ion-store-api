package com.connexta.store.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddMetadataRequest {

  @JsonProperty("metadataInfos")
  @Valid
  private List<MetadataInfo> metadataInfos = new ArrayList<>();

  public AddMetadataRequest metadataInfos(List<MetadataInfo> metadataInfos) {
    this.metadataInfos = metadataInfos;
    return this;
  }

  public AddMetadataRequest addMetadataInfo(MetadataInfo metadataInfo) {
    this.metadataInfos.add(metadataInfo);
    return this;
  }

  /**
   * An array of the information for each metadata type that will be added to the Dataset.
   *
   * @return metadataInfos
   */
  @ApiModelProperty(
      required = true,
      value = "An array of the information for each metadata type that will be added to the Dataset.")
  @NotNull
  @Valid
  @Size
  public List<MetadataInfo> getMetadataInfos() {
    return List.copyOf(metadataInfos);
  }

  public void setMetadataInformations(List<MetadataInfo> metadataInfos) {
    this.metadataInfos = metadataInfos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddMetadataRequest addMetadataRequest = (AddMetadataRequest) o;
    return Objects.equals(this.metadataInfos, addMetadataRequest.metadataInfos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadataInfos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddMetadataRequest {\n");
    sb.append("    metadataInfos: ").append(toIndentedString(metadataInfos)).append("\n");
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
