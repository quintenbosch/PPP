package com.example.objectorientedprogramming.interfaces

fun main(args: Array<String>) {
    var vehicle = Vehicle()

    println("Name: ${vehicle.name}")
    vehicle.go()
    vehicle.stop()
}