package com.f98k.tipstermindcocoapods.data.repository.main

import com.f98k.tipstermindcocoapods.data.model.BottomBarList

interface MainRepository {
   fun getDefaultBottomBar(): BottomBarList
}