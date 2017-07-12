package edu.bionic.dao.mock;

import edu.bionic.dao.ResponceDao;
import edu.bionic.domain.Response;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by bm on 10.07.17.
 */
public class ResponceDaoImpl implements ResponceDao {

    private List<Response> responseList;

    @Override
    public void save(Response response) {
        responseList.add(response);
    }

    @Override
    public Optional<Response> getByNameBuyer(String nameBuyer) {
        return responseList.stream().filter(Response -> Response.getNameBuyer() == nameBuyer).findAny();

    }

    @Override
    public Optional<Response> getByIdProduct(Integer productId) {
        return responseList.stream().filter(Response -> Response.getIdProduct() == productId).findAny();
    }

    @Override
    public List<Response> getAll() {
        return new ArrayList<>(responseList);
    }




    public void initResponceStorage() {
        responseList = new ArrayList<>();

        responseList.add(new Response(
                1,
                LocalDateTime.now().minus(1, ChronoUnit.DAYS),
                "BOB",
                "This is good",
                4
        ));
        responseList.add(new Response(
                2,
                LocalDateTime.now().minus(2, ChronoUnit.DAYS),
                "TED",
                "Perfect",
                5
        ));
        responseList.add(new Response(
                3,
                LocalDateTime.now().minus(3, ChronoUnit.DAYS),
                "ROM",
                "This is good",
                4
        ));
        responseList.add(new Response(
                4,
                LocalDateTime.now().minus(4, ChronoUnit.DAYS),
                "TOM",
                "50/50",
                3
        ));
        responseList.add(new Response(
                5,
                LocalDateTime.now().minus(5, ChronoUnit.DAYS),
                "DG",
                "Very bad",
                2
        ));
        responseList.add(new Response(
                6,
                LocalDateTime.now().minus(6, ChronoUnit.DAYS),
                "TREVOR",
                "Terrible",
                1
        ));
    }
}
