package com.evaluation.bankProperty.response;

public enum ResponseStatus {
    SUCCESS("200", "OK"),                                   //$NON-NLS-1$
    ACCEPTED("202", "Accepted"),
    PARTIAL_CONTENT("206", "partial content"),                                           //$NON-NLS-1$
    NO_CONTENT("204", "No content"),                        //$NON-NLS-1$
    BAD_REQUEST("400", "Bad request"),                      //$NON-NLS-1$
    UNAUTHORIZED("401", "Unauthorized"),                    //$NON-NLS-1$
    FORBIDDEN("403", "Forbidden"),                          //$NON-NLS-1$
    NOT_FOUND("404",  "Not found"),                         //$NON-NLS-1$
    METHOD_NOT_ALLOWED("405",  "Method not allowed"),       //$NON-NLS-1$
    INTERNAL_SERVER_ERROR("500", "Internal server error"),  //$NON-NLS-1$
    TEMPORARY_UNAVAILABLE("503", "Temporary unavailable"),
    Internal_Server_Error("500", "Error data null in database"), //$NON-NLS-1$
    FILE_NOT_FOUND("417", "File not found"),  //$NON-NLS-1$
    NO_FIRST_INVENTORY("530", "Inventaire inexistant");  //$NON-NLS-1$

    private String code;
    private String message;

    ResponseStatus(String code, String description)
    {
        this.code = code;
        this.message = description;
    }

    public String getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }
}

