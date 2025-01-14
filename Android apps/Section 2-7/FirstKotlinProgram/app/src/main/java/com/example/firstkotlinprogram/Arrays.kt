package com.example.firstkotlinprogram

fun main(args: Array<String>) {
    var age = arrayOf(1,2,3)

    println("First element of the array = " + age[0])
    println("Second element of the array = " + age.get(1))
    println("Third element of the array = " + age[2])

    println("---------------------")

    var cars = arrayOf("Mercedes", "BMW", "Opel")

    println("First element of the array = " + cars[0])
    println("Second element of the array = " + cars.get(1))
    println("Third element of the array = " + cars[2])

    println("---------------------")

    cars.set(2, "Ford")

    println("First element of the array = " + cars[0])
    println("Second element of the array = " + cars.get(1))
    println("Third element of the array = " + cars[2])

    println("Size of cars array = " + cars.size)

    println("---------------------")

    var carsAndAge = arrayOf("Mercedes", 5, "Opel", 10)

    println("First element of the array = " + carsAndAge[0])
    println("Second element of the array = " + carsAndAge.get(1))
    println("Third element of the array = " + carsAndAge[2])
    println("Third element of the array = " + carsAndAge[3])

    //carsAndAge.set(4, 20) //invalid
}