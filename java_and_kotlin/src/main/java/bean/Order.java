package bean;

import java.util.List;

public class Order
{
	private String id;
	private Customer customer;
	List<Product> products;

	public Order(final String id, final Customer customer, final List<Product> products)
	{
		this.id = id;
		this.customer = customer;
		this.products = products;
	}

	public String getId()
	{
		return id;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public List<Product> getProducts()
	{
		return products;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		final Order order = (Order) o;

		if (getId() != null ? !getId().equals(order.getId()) : order.getId() != null)
		{
			return false;
		}
		if (getCustomer() != null ? !getCustomer().equals(order.getCustomer()) : order.getCustomer() != null)
		{
			return false;
		}
		return getProducts() != null ? getProducts().equals(order.getProducts()) : order.getProducts() == null;
	}

	@Override
	public int hashCode()
	{
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
		result = 31 * result + (getProducts() != null ? getProducts().hashCode() : 0);
		return result;
	}

	@Override
	public String toString()
	{
		return "Order{" + "id='" + id + '\'' + ", customer=" + customer + ", products=" + products + '}';
	}
}

