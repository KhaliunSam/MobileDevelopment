package mum.mdp.walmart

import java.io.Serializable

data class Category(var name: String?, var description:String?, var picture: Int?) :
    Serializable {

    override fun toString(): String {
        return "Category(name=$name, description=$description, picture=$picture)"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Category) return false
        return name == other.name
    }
}

