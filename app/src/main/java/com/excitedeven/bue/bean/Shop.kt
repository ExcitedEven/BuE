package com.excitedeven.bue.bean

class Shop {
    var sid: Long = 0
    var sname: String = ""
    var slogo: String = ""
    var sdescription: String = ""
    var foodList: ArrayList<Food>
        get() = foodList
        set(foodList: ArrayList<Food>) {
            this.foodList = foodList
        }
}