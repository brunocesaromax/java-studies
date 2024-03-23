package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Client
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-16T12:44:13.813Z")


public class Client {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("lastName")
    private String lastName = null;

    @JsonProperty("initials")
    private String initials = null;

    @JsonProperty("birthDate")
    private LocalDate birthDate = null;

    @JsonProperty("lastUpdate")
    private OffsetDateTime lastUpdate = null;

    @JsonProperty("status")
    private Boolean status = null;

    /**
     * Gets or Sets type
     */
    public enum TypeEnum {
        INTERN("INTERN"),

        EXTERN("EXTERN");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TypeEnum fromValue(String text) {
            for (TypeEnum b : TypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("type")
    private TypeEnum type = null;

    public Client id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Identificador do cliente.
     *
     * @return id
     **/
    @ApiModelProperty(value = "Identificador do cliente.")


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Nome do cliente.
     *
     * @return name
     **/
    @ApiModelProperty(value = "Nome do cliente.")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Sobrenome do cliente.
     *
     * @return lastName
     **/
    @ApiModelProperty(value = "Sobrenome do cliente.")


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Client initials(String initials) {
        this.initials = initials;
        return this;
    }

    /**
     * Iniciais do nome completo do cliente.
     *
     * @return initials
     **/
    @ApiModelProperty(value = "Iniciais do nome completo do cliente.")

    @Size(min = 2, max = 7)
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public Client birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Data de nascimento do cliente.
     *
     * @return birthDate
     **/
    @ApiModelProperty(value = "Data de nascimento do cliente.")

    @Valid

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Client lastUpdate(OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    /**
     * Data de atualização dos dados do cliente.
     *
     * @return lastUpdate
     **/
    @ApiModelProperty(value = "Data de atualização dos dados do cliente.")

    @Valid

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Client status(Boolean status) {
        this.status = status;
        return this;
    }

    /**
     * Status ativo ou inativo do cliente.
     *
     * @return status
     **/
    @ApiModelProperty(value = "Status ativo ou inativo do cliente.")


    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Client type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @ApiModelProperty(value = "")


    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Client client = (Client) o;
        return Objects.equals(this.id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Client {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    initials: ").append(toIndentedString(initials)).append("\n");
        sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
        sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

