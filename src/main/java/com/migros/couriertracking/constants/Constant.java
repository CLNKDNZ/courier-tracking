package com.migros.couriertracking.constants;

public interface Constant {

    String SUCCESSFULLY_DELETED = "Succesfully Deleted";
    Integer DISTANCE_LIMIT = 100;
    Integer RADIUS_OF_THE_WORLD = 6371;

    //============= EXCEPTION MESSAGES =============
    String COURIER_EXCEPTION_RULE_EXCEPTION = "Request is not suitable for tracking rule";
    String STORE_CREATE_EXCEPTION = "Store can not create";
    String NO_RELATION_COURIER_EXCEPTION = "No courier for tracking. Please create courier first";
    String TRACKING_SUCCESS_MESSAGE = "Tracking Successful. Added to Datasource";
}
