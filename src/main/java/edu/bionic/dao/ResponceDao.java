package edu.bionic.dao;

import edu.bionic.domain.Response;

import java.util.List;
import java.util.Optional;

/**
 * Created by bm on 10.07.17.
 */
public interface ResponceDao {

    void save(Response response);

    Optional<Response> getByNameBuyer(String nameBuyer);

    Optional<Response> getByIdProduct(Integer productId);

    List<Response> getAll();
}
