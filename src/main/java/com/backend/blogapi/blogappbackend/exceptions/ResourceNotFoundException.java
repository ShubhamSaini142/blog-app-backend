package com.backend.blogapi.blogappbackend.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String FieldName;
   private long FieldValue;


    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %s" , resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        FieldName = fieldName;
        FieldValue = fieldValue;
    }
}
