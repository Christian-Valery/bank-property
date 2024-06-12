package com.evaluation.bankProperty.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
public class GenericJsonResponse {
    public String message;
    public Boolean show;
    public String code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected Object data;

    /**
     * Constructeur
     *
     * @param message
     * @param show
     * @param code
     * @param data
     */
    public GenericJsonResponse(String code, String message, Boolean show, Object data)
    {
        this.message = message;
        this.show = show;
        this.code = code;
        this.data = data;
    }

    /**
     * Constructor
     *
     * @param code
     * @param message
     * @param show
     */
    public GenericJsonResponse(String code, String message, Boolean show){
        this.message = message;
        this.show = show;
        this.code = code;
    }

    public GenericJsonResponse(ResponseStatus responseStatus, String message, Boolean show){
        this(responseStatus.getCode(), message, show);
    }

    /**
     * Constructeur
     *
     * @param responseStatus
     * @param show
     * @param data
     */
    public GenericJsonResponse(ResponseStatus responseStatus, Boolean show, Object data)
    {
        this(responseStatus.getCode(), responseStatus.getMessage(), show, data);
    }

    /**
     * Constructeur
     *
     * @param responseStatus
     * @param show
     */
    public GenericJsonResponse(ResponseStatus responseStatus, Boolean show) {
        this(responseStatus.getCode(), responseStatus.getMessage(), show, null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}
