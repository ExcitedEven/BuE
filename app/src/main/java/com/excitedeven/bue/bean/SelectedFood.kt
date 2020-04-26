package com.excitedeven.bue.bean

class SelectedFood {
    var food: Food? = null
    var number: Int = 0
        set(number: Int) {
            field = number
            sum = number * food!!.fprice
        }
    var sum: Long = 0

    //TODO 改为ID判断
    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }
//        if (other == this) {
//            return true
//        }
        if (other is SelectedFood) {
            var selectedFood: SelectedFood = other
            if (this.food?.fname == selectedFood.food?.fname) {
                return true
            }
            if (selectedFood.food?.equals(this.food?.fname)!!) {
                return true
            }
        }

        return false
    }
}