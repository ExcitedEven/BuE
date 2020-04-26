package com.excitedeven.bue.bean

class Order {
    var shopid: Long = 0
    var shopName: String = ""
    var shopImg: String = ""
    var selectedFoodList: ArrayList<SelectedFood>? = null
    var sum: Long = 0
    var adder: String = ""
    var time: Long = 0
}