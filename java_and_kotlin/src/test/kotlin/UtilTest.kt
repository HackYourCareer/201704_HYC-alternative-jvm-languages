import bean.Customer
import bean.Order
import bean.Product
import collections.Util
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert.assertEquals
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import java.math.BigDecimal

@RunWith(JUnitPlatform::class)
class OrderUtilTest : Spek({

    describe("Orders Utility class") {

        val customer1 = Customer( "John", "Doe", "Gliwice", "Akademicka 1")
        val customer2 = Customer("Jane", "Doe", "Gliwice", "Akademicka 1")

        val product1 = Product("Effective Java", "Book", BigDecimal(100), true)
        val product2 = Product("Kotlin in action", "Book", BigDecimal(150), true)
        val product3 = Product("Programming in Scala", "Book", BigDecimal(100), true)

        it("should return empty set in case product list is empty") {
            val customer = Customer("John", "Doe", "Gliwice", "Akademicka 1")
            val order1 = Order("1", customer, listOf())
            val orders = setOf(order1)

            val ids = Util.getIdsJava8(orders, "Gliwice", BigDecimal(100))

            assertEquals(0, ids.size)
        }

        it("should return ids of orders with summary price above the threshold") {
            val products1 = listOf(product1, product2)
            val order1 = Order("1", customer1, products1)
            val products2 = listOf(product3)
            val order2 = Order("2", customer2, products2)

            val orders = setOf(order1, order2)

            val ids = Util.getIdsJava8(orders, "Gliwice", BigDecimal(150))

            assertEquals(1, ids.size)
            assertEquals("1", ids.first())
        }

        it("should skip orders for customers from city other than specified") {
            val products1 = listOf(product1)
            val order1 = Order("1", customer1, products1)
            val orders = setOf(order1)

            val ids = Util.getIdsJava8(orders, "Gliwice", BigDecimal(150))

            assertEquals(0, ids.size)
        }

        it("should skip null orders") {
            val products1 = listOf(product1)
            val order1 = Order("1", customer1, products1)
            val orders = setOf(null, order1, null)

            val ids = Util.getIdsJava8(orders, "Gliwice", BigDecimal(150))

            assertEquals(0, ids.size)
        }
    }
})