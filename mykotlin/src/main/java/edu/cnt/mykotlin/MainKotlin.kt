package edu.cnt.mykotlin

fun main() {

    println("Hola")
    val n = (0..100).random()
    println("Aleatorio = $n")

    var user1: User_ = User_("Vale", 42)
    var user2: User_ = User_("Pepa", 18)
    var user3: User_ = User_("Jose", 32)
    var user4: User_ = User_("Juani", 15)
    var user5: User_ = User_("Manolo", 75)

    var usersList = listOf(user1, user2, user3, user4, user5)

    usersList.forEach({ user -> println(user)})
    usersList.forEach{ user -> println(user.name)}
    var usersListLess30 = usersList.filter { u -> u.age <= 30 }
    usersListLess30.forEach{ u -> println(u.name + " " + u.age ) }

}