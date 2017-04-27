package collections;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import bean.Order;
import bean.Product;

public class Util
{

	public static Set<String> getIds(final Set<Order> orders, String city, BigDecimal priceLimit)
	{
		Set<String> ids = new HashSet<>();

		for (Order order : orders)
		{
			if (includeOrder(order, city, priceLimit))
			{
				ids.add(order.getId());
			}
		}

		return ids;
	}

	private static boolean includeOrder(final Order order, final String city, BigDecimal priceLimit)
	{
		return order != null && order.getCustomer().getCity() == city && getSum(order).compareTo(priceLimit) > 0;
	}

	private static BigDecimal getSum(final Order order)
	{
		BigDecimal sum = new BigDecimal(0);
		for (Product product : order.getProducts())
		{
			sum = sum.add(product.getPrice());
		}

		return sum;
	}

	public static Set<String> getIdsJava8(final Set<Order> orders, final String city,
			final BigDecimal priceLimit)
	{
		return orders //
				.stream() //
				.filter(order -> includeOrder(order, city, priceLimit)) //
				.map(order -> order.getId()) //
				.collect(Collectors.toSet()); //
	}
}

