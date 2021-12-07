package com.amnah.marvelapp.ui.home

import com.amnah.marvelapp.data.repository.domain.models.Characters

sealed class HomeItems(val type: HomeItemsTypes)  {
    class ComicsType(val items: List<Characters>): HomeItems(HomeItemsTypes.TYPE_COMICS)
    class EventsType(val items: List<Characters>): HomeItems(HomeItemsTypes.TYPE_EVENTS)
    class CharactersType(val items: List<Characters>): HomeItems(HomeItemsTypes.TYPE_CHARACTERS)

}
