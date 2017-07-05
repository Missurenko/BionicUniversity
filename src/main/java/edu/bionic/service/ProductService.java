package edu.bionic.service;

import edu.bionic.Product;
import jdk.nashorn.internal.runtime.options.Options;

import java.util.List;

/**
 * Created by bm on 05.07.17.
 */
public interface ProductService {

    List<Product> getAll();

    Product getById(int productId);
}
