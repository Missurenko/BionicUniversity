package edu.bionic.service.impl;

import edu.bionic.dao.ResponceDao;
import edu.bionic.domain.Order;
import edu.bionic.domain.Product;
import edu.bionic.domain.Response;
import edu.bionic.service.ResponceService;
import edu.bionic.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by bm on 10.07.17.
 */
@Service
public class ResponceServiceImpl implements ResponceService {


    ResponceDao responceDao;

    @Autowired
    public ResponceServiceImpl(ResponceDao responceDao) {
        this.responceDao = responceDao;
    }

    @Override
    public void createNewResponce(Integer idProduct, String nameBuyer, String text, Integer rating) {
        Response response = new Response(idProduct, LocalDateTime.now(), nameBuyer, text, rating);
        responceDao.save(response);
    }

    @Override
    public Optional<Response> getByNameBuyer(String nameBuyer) {
        return null;

    }

    @Override
    public Response getByIdProduct(Integer productId) {
        return responceDao.getByIdProduct(productId).
                orElseThrow(() -> new NotFoundException(String.format("Product with id=%d was not found", productId)));
    }

    @Override
    public List<Response> getAll() {
        return responceDao.getAll()
                .stream()
                .sorted(Comparator.comparing(Response::getIdProduct))
                .collect(Collectors.toList());
    }


}
