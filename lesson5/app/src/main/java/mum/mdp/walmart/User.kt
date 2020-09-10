package mum.mdp.walmart

import java.io.Serializable

data class User (var email:String, var password:String) : Serializable {
    lateinit var firstName: String
    lateinit var lastName: String

    constructor(firstName: String, lastName: String, email: String, password: String): this(email, password) {
        this.firstName = firstName
        this.lastName = lastName
    }

    override fun toString(): String {
        return "userName=$email"
    }

    /*override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (email != other.email) return false
        if (password != other.password) return false

        return true
    }*/
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is User) return false
        return email == other.email && password == other.password
    }
}