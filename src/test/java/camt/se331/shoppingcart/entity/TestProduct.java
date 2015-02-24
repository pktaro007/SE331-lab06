package camt.se331.shoppingcart.entity;

import camt.se331.shoppingcart.dao.NewSimpleProductDAO;
import camt.se331.shoppingcart.dao.ProductDao;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Taro on 2/24/2015.
 */
public class TestProduct {

        ProductDao productDao = new NewSimpleProductDAO();

        @Test
        public void testGetNetPriceVat(){
            VatEntity.getInstance().setVat(0.1);
            assertThat(productDao.getProduct(1l).getNetPrice(), is(900.00));
            assertThat(productDao.getProduct(1l).getTax(), is(100.00));

            VatEntity.getInstance().setVat(0.05);
            assertThat(productDao.getProduct(2l).getNetPrice(), is(1900.00));
            assertThat(productDao.getProduct(2l).getTax(), is(100.00));

            VatEntity.getInstance().setVat(0.0);
            assertThat(productDao.getProduct(3l).getNetPrice(), is(2500.00));
            assertThat(productDao.getProduct(3l).getTax(), is(0.00));

            VatEntity.getInstance().setVat(1.0);
            assertThat(productDao.getProduct(4l).getNetPrice(), is(0.00));
            assertThat(productDao.getProduct(4l).getTax(), is(20000.00));

    }
}
