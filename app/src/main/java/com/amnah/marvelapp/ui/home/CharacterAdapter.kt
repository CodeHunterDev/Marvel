package com.amnah.marvelapp.ui.home

import com.amnah.marvelapp.R
import com.amnah.marvelapp.model.local.entity.CharacterEntity
import com.amnah.marvelapp.ui.base.BaseAdapter
import com.amnah.marvelapp.ui.base.BaseInteractionListener

class CharacterAdapter(
    item: List<CharacterEntity>,
    listener: ICharacterInteraction
) : BaseAdapter<CharacterEntity>(item, listener) {
    override val layoutId: Int = R.layout.character_item
}

interface ICharacterInteraction : BaseInteractionListener