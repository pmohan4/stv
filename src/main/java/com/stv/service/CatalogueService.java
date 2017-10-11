package com.stv.service;

import com.stv.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatalogueService {

    private static Map<String, List<Product>> catalogue = new HashMap<>();

    public List<Product> getProductsByLocationId(String locationId) {
        List<Product> products = catalogue.get(locationId);
        products.addAll(catalogue.get(null));
        return products;
    }
}
