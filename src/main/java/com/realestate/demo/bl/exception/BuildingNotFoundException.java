package com.realestate.demo.bl.exception;


public class BuildingNotFoundException extends RuntimeException {

    public BuildingNotFoundException(Long id) {
        super("Could not find building " + id);
    }
}
