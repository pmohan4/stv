package com.stv.facade;

import com.stv.model.Product;
import com.stv.service.CatalogueService;
import com.stv.service.CustomerLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("customerService")
@RequestMapping("customer")
public class CustomerServiceFacade {

    @Autowired
    private CustomerLocationService customerLocationService;

    @Autowired
    private CatalogueService catalogueService;

    @RequestMapping(value = "/locationId/{customerId}",
            method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String getLocationIdByCustomer(@Valid @PathVariable String customerId) {
        return customerLocationService.customerLocationId(customerId);
    }

    @RequestMapping(value = "/catalogue/{locationId}", produces = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Product> getCatalogueByLocation(@Valid @PathVariable String locationId) {
        return catalogueService.getProductsByLocationId(locationId);
    }
}
