package mum.mdp.walmart
import java.io.Serializable

data class Product(
    var id: Int?, var category: Category?, var title: String?, var price: Double?,
    var color: String?, var image: Int, var description: String?): Serializable {

    override fun toString(): String {
        return "$title \$$price"
    }
}