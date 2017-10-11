package com.stv.service;

import com.stv.exception.FailureException;
import org.springframework.stereotype.Service;

@Service
public class CustomerLocationServiceImpl implements CustomerLocationService {


    @Override
    public String customerLocationId(String customerID) {

        switch(customerID) {
            case "customer1":
                return "LONDON";
            case "customer2":
                return "LIVERPOOL";
            case "customer3":
                return "MANCHESTER";
            default:
                throw new FailureException("No customer found");
        }
    }
}
