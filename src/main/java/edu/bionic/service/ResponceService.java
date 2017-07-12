package edu.bionic.service;

import edu.bionic.domain.Response;

import java.util.List;
import java.util.Optional;

/**
 * Created by bm on 10.07.17.
 */
public interface ResponceService {

    void createNewResponce(Integer idProduct,String nameBuyer,String text,Integer rating);


    Optional<Response> getByNameBuyer(String nameBuyer);

    Response getByIdProduct(Integer productId);

    List<Response> getAll();

}
