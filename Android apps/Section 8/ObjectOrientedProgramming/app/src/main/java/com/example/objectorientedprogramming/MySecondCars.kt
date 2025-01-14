package com.example.objectorientedprogramming

class MySecondCars {
    var name:String? = null
    var model:Int? = null
        private set

    constructor()
    constructor(name: String?, model: Int?) {
        this.name = name
        this.model = model

    }
}