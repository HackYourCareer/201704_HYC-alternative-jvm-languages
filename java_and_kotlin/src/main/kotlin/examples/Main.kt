package examples

import bean.Customer
import bean.Order
import java.math.BigDecimal

data class CustomerK(val name: String, val surname: String, val city: String, val address: String)

fun main(args: Array<String>) {
    println("Hello Kotlin!")

    val number = 10

    var string = ""

    val customer = Customer("John", "Doe", "Gliwice", "Akademicka 2")

    val joe = CustomerK("John", "Doe", "Gliwice", "Akademicka 2")
    val jane = joe.copy(name = "Jane")

    println(jane)

    val s: String? = null

}

private fun includeOrder(order: Order, city: String, priceLimit: BigDecimal): Boolean {
    return order.customer.city === city && getSum(order).compareTo(priceLimit) > 0
}

private fun getSum(order: Order): BigDecimal {
    val sum = BigDecimal(0)
    for (product in order.products) {
        sum.add(product.price)
    }
    return sum
}

//	public static Set<String> getIdsJava8(final Set<Order> orders, final String city,
//			final BigDecimal priceLimit)
//	{
//		return orders //
//				.stream() //
//				.filter(order -> includeOrder(order, city, priceLimit)) //
//				.map(order -> order.getId()) //
//				.collect(Collectors.toSet()); //
//	}

fun getIds(orders: Set<Order>, city: String, priceLimit: BigDecimal): Set<String> {
   return orders
           .filter { order -> includeOrder(order, city, priceLimit) }
           .map { order -> order.id }
           .toSet()
}

fun getCount(order: Order?): Int {
  return order?.products?.size ?: -1
}




