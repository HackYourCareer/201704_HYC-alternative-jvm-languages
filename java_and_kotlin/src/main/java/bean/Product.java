package bean;

import java.math.BigDecimal;

public class Product
{
	private String name;
	private String description;
	private BigDecimal price;
	private boolean available;

	public Product(final String name, final String description, final BigDecimal price, final boolean available)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.available = available;
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public boolean isAvailable()
	{
		return available;
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

		final Product product = (Product) o;

		if (isAvailable() != product.isAvailable())
		{
			return false;
		}
		if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null)
		{
			return false;
		}
		if (getDescription() != null ? !getDescription().equals(product.getDescription()) : product.getDescription() != null)
		{
			return false;
		}
		return getPrice() != null ? getPrice().equals(product.getPrice()) : product.getPrice() == null;
	}

	@Override
	public int hashCode()
	{
		int result = getName() != null ? getName().hashCode() : 0;
		result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
		result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
		result = 31 * result + (isAvailable() ? 1 : 0);
		return result;
	}

	@Override
	public String toString()
	{
		return "Product{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", price=" + price + ", " +
				"available=" + available + '}';
	}
}

