package com.excitedeven.bue.bean

import java.io.Serializable

class User : Serializable {
    var id: Long = 0
    var username: String = ""
    var phone: String = ""
    var pwd: String = ""
    var logourl: String = ""
    var adder: String = ""
    var orderList: ArrayList<Order>? = null
}