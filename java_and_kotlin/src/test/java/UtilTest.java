import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.junit.Test;

import bean.Customer;
import bean.Order;
import bean.Product;
import collections.Util;
import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;

public class UtilTest
{
	private final Customer customer1 = new Customer("John", "Doe", "Gliwice", "Akademicka 1");
	private final Customer customer2 = new Customer("Jane", "Doe", "Gliwice", "Akademicka 1");

	private final Product product1 = new Product("Effective Java", "Book", new BigDecimal(100), true);
	private final Product product2 = new Product("Kotlin in action", "Book", new BigDecimal(150), true);
	private final Product product3 = new Product("Programming Scala", "Book", new BigDecimal(100), true);

	@Test
	public void shouldReturnEmptySetInCaseSummaryProductListIsEmpty()
	{
		// given
		final Order order1 = new Order("1", customer1, new ArrayList<>());
		final Set<Order> orders = Collections.singleton(order1);

		// when
		final Set<String> ids = Util.getIdsJava8(orders, "Gliwice", new BigDecimal(100));

		// then
		assertThat(ids).isEmpty();
	}

	@Test
	public void shouldReturnIdsOfOrdersWithSummaryPriceAboveThreshold()
	{
		// given
		final Customer customer1 = new Customer("John", "Doe", "Gliwice", "Akademicka 1");
		final List<Product> products1 = Lists.newArrayList(product1, product2);
		final Order order1 = new Order("1", customer1, products1);

		final List<Product> products2 = Lists.newArrayList(product3);
		final Order order2 = new Order("2", customer2, products2);
		final Set<Order> orders = Sets.newHashSet(order1, order2);

		// when
		final Set<String> ids = Util.getIdsJava8(orders, "Gliwice", new BigDecimal(150));

		// then
		assertThat(ids).containsOnly("1");
	}

	@Test
	public void shouldSkipOrdersForCustomersFromCityOtherThanSpecified()
	{  	// given
		final List<Product> products1 = Lists.newArrayList(product1);
		final Order order1 = new Order("1", customer1, products1);
		final Set<Order> orders = Sets.newHashSet(order1);

		// when
		final Set<String> ids = Util.getIdsJava8(orders, "Gliwice", new BigDecimal(150));

		// then
		assertThat(ids).isEmpty();
	}

	@Test
	public void shouldSkipNullOrders()
	{
		// given
		final List<Product> products1 = Lists.newArrayList(product1);
		final Order order1 = new Order("1", customer1, products1);
		final Set<Order> orders = Sets.newHashSet(null, order1, null);

		// when
		final Set<String> ids = Util.getIdsJava8(orders, "Gliwice", new BigDecimal(50));

		// then
		assertThat(ids).containsOnly("1");
	}
}
