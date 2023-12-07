package com.lhta.foodapp.utils;

import org.springframework.stereotype.Component;

@Component
public class Constants {
	public static enum Role {
		USER, ADMIN
	}
	public static final String STATUS_NEW = "New";
    public static final String STATUS_IN_PROGRESS = "In progress";
    public static final String STATUS_CLOSE = "Close";
    public static final String STATUS_CANCELED = "Canceled";
    
    public static final String CONFIRMED = "Confirmed";
    public static final String BEING_PREPARED = "Being prepared";
    public static final String DELIVERING = "Delivering";
    public static final String COMPLETED = "Completed";
    public static final String CANCEL = "Cancel";
}
