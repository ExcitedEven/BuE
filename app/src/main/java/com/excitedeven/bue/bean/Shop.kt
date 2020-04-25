package com.excitedeven.bue.bean

class Shop {
    var sid: Long = 0
    var sname: String = ""
    var slogo: String = ""
    var sdescription: String = ""
    var dishesList: ArrayList<Dishes>
        get() = dishesList
        set(dishesList: ArrayList<Dishes>) {
            this.dishesList = dishesList
        }
}