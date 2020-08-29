package com.udacity.graphql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;

public class DogNotFound extends Exception implements GraphQLError {
    private HashMap<String, Long> excepMeta = new HashMap();
    public DogNotFound(String message, Long id)
    {
        super(message);
        this.putExcepMeta("invaliddogid", id);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    public void putExcepMeta(String msg, Long id)
    {
        this.excepMeta.put(msg, id);
    }

    public HashMap<String, Long> getExceptMeta()
    {
        return this.excepMeta;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }
}


/*
*public class StudentStoreException extends Exception {

    public StudentStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
* */