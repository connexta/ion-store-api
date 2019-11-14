/**
 * Copyright (c) Connexta
 *
 * <p>This is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or any later version.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details. A copy of the GNU Lesser General Public
 * License is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */
package com.connexta.store.rest.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** Error message information. */
public class ErrorMessage {
  @JsonProperty("timestamp")
  private OffsetDateTime timestamp;

  @JsonProperty("path")
  private String path;

  @JsonProperty("status")
  private Integer status;

  @JsonProperty("code")
  private Integer code;

  @JsonProperty("error")
  private String error;

  @JsonProperty("message")
  private String message;

  @JsonProperty("details")
  @Valid
  private List<String> details = null;

  public ErrorMessage timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * The server time when the error was generated.
   *
   * @return timestamp
   */
  @ApiModelProperty(required = true, value = "The server time when the error was generated.")
  @NotNull
  @Valid
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public ErrorMessage path(String path) {
    this.path = path;
    return this;
  }

  /**
   * The path for the REST request that generated this error.
   *
   * @return path
   */
  @ApiModelProperty(
      example = "/ingest",
      required = true,
      value = "The path for the REST request that generated this error.")
  @NotNull
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ErrorMessage status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * The corresponding HTTP status code.
   *
   * @return status
   */
  @ApiModelProperty(example = "200", required = true, value = "The corresponding HTTP status code.")
  @NotNull
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public ErrorMessage code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * An optional more specific code corresponding to the error (specific codes need to be
   * documented).
   *
   * @return code
   */
  @ApiModelProperty(
      value =
          "An optional more specific code corresponding to the error (specific codes need to be documented). ")
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public ErrorMessage error(String error) {
    this.error = error;
    return this;
  }

  /**
   * The corresponding HTTP reason phrase.
   *
   * @return error
   */
  @ApiModelProperty(
      example = "Bad Request",
      required = true,
      value = "The corresponding HTTP reason phrase.")
  @NotNull
  @Size(min = 1)
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public ErrorMessage message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Specific information about the error.
   *
   * @return message
   */
  @ApiModelProperty(
      example = "Validation failed for object='systemInfo'.",
      required = true,
      value = "Specific information about the error.")
  @NotNull
  @Size(min = 1)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorMessage details(List<String> details) {
    this.details = details;
    return this;
  }

  public ErrorMessage addDetailsItem(String detailsItem) {
    if (this.details == null) {
      this.details = new ArrayList<>();
    }
    this.details.add(detailsItem);
    return this;
  }

  /**
   * Optional detailed information about the error.
   *
   * @return details
   */
  @ApiModelProperty(value = "Optional detailed information about the error.")
  public List<String> getDetails() {
    return details;
  }

  public void setDetails(List<String> details) {
    this.details = details;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorMessage errorMessage = (ErrorMessage) o;
    return Objects.equals(this.timestamp, errorMessage.timestamp)
        && Objects.equals(this.path, errorMessage.path)
        && Objects.equals(this.status, errorMessage.status)
        && Objects.equals(this.code, errorMessage.code)
        && Objects.equals(this.error, errorMessage.error)
        && Objects.equals(this.message, errorMessage.message)
        && Objects.equals(this.details, errorMessage.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, path, status, code, error, message, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorMessage {\n");

    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
