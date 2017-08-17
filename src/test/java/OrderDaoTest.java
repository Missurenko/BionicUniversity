import edu.bionic.config.Profiles;
import edu.bionic.dao.BaseDaoTest;
import edu.bionic.dao.OrderDao;
import edu.bionic.domain.Order;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static testdata.OrderFactory.getAllOrders;
import static testdata.OrderFactory.getNewOrder;

public class OrderDaoTest extends BaseDaoTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void getAll() throws Exception {
        List<Order> expected = getAllOrders();
        List<Order> actual = orderDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void save() throws Exception {
        Order newOrder = getNewOrder();
        Order savedOrder = orderDao.save(newOrder);
        newOrder.setId(savedOrder.getId());

        List<Order> expected = getAllOrders();
        expected.add(newOrder);

        List<Order> actual = orderDao.getAll();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

}