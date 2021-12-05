package com.amnah.marvelapp.ui.characters

import com.amnah.marvelapp.R
import com.amnah.marvelapp.data.local.entity.CharacterEntity
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.ui.base.BaseAdapter
import com.amnah.marvelapp.ui.base.BaseInteractionListener

class CharacterAdapter(
    item: List<CharacterEntity>,
    listener: ICharacterInteraction
) : BaseAdapter<CharacterEntity>(item, listener) {
    override val layoutId: Int = R.layout.character_item
}

interface ICharacterInteraction : BaseInteractionListener