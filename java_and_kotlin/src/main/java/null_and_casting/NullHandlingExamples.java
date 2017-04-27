package null_and_casting;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import bean.Order;
import bean.Product;

public class NullHandlingExamples
{
	// Oh no, NullPointerException!
	public static int getProductCount(final Order order)
	{
		return order.getProducts().size();
	}

	public int getProductCountSafe(final Order order)
	{
		if (order != null)
		{
			final List<Product> products = order.getProducts();

			if (products != null)
			{
				return products.size();
			}
		}

		return -1;
	}

	// Java 8
	final public int getProductCountWithOptionalV1(final Optional<List<Product>> products){
		return products.isPresent() ? products.get().size() : -1;
	}

	final public int getProductCountWithOptionalV2(final Optional<List<Product>> products){
		return products.orElse(Collections.EMPTY_LIST).size();
	}
}
