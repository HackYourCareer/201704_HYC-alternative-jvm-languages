package bean;

public class Customer
{
	private String name;
	private String surname;
	private String city;
	private String address;

	public Customer(final String name, final String surname, final String city, final String address)
	{
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.address = address;
	}

	public String getName()
	{
		return name;
	}

	public String getSurname()
	{
		return surname;
	}

	public String getCity()
	{
		return city;
	}

	public String getAddress()
	{
		return address;
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

		final Customer customer = (Customer) o;

		if (getName() != null ? !getName().equals(customer.getName()) : customer.getName() != null)
		{
			return false;
		}
		if (getSurname() != null ? !getSurname().equals(customer.getSurname()) : customer.getSurname() != null)
		{
			return false;
		}
		if (getCity() != null ? !getCity().equals(customer.getCity()) : customer.getCity() != null)
		{
			return false;
		}
		return getAddress() != null ? getAddress().equals(customer.getAddress()) : customer.getAddress() == null;
	}

	@Override
	public int hashCode()
	{
		int result = getName() != null ? getName().hashCode() : 0;
		result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
		result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
		result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
		return result;
	}

	@Override
	public String toString()
	{
		return "Customer{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", city='" + city + '\'' + ", address='"
				+ address + '\'' + '}';
	}
}
