package com.example.androidpreparation.data

class MovieRepositoryImpl constructor(override var a: Int): MovieRepositoryInterface {
    override fun getMovie(): String = "Repository Value"
}