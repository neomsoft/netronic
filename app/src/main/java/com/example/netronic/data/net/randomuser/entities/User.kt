package com.example.netronic.data.net.randomuser.entities
import com.example.netronic.data.entities.User as MainUser

/**
 * User.
 *
 * @param gender стать юзера. Тип [Gender]
 * @param name імя юзера.
 * @param id ідентифікатор юзера.
 * @param picture фото юзера.
 * @param nat національність.
 * ...
 */
data class User(
    val gender: Gender,
    val name: Name,
    val location: Location,
    val email: String,
    val login: Login,
    val dob: DateAge,
    val registered: DateAge,
    val phone: String,
    val cell: String,
    val id: Id,
    val picture: Picture,
    val nat: Nationality
) {

    companion object {

        fun User.toUser() = MainUser(
            id = id.value,
            name = name.first,
            photo = picture.large,
            age = dob.age,
            email = email,
            birthday = dob.date,
        )
    }
}
