package com.qtonz.adapter.advancerecycleview.data

sealed class ListItem {
    data class ItemOne(val data: ItemsMoive) : ListItem()
    data class ItemTwo(val data: ItemsSeries) : ListItem()
}
