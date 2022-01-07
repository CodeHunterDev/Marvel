package com.amnah.marvelapp.ui.profile

import com.amnah.marvelapp.R
import com.amnah.marvelapp.data.repository.domain.models.Characters
import com.amnah.marvelapp.ui.base.BaseAdapter
import com.amnah.marvelapp.ui.base.BaseInteractionListener

class CharacterAdapter(
    item: List<Characters>,
    listener: ICharacterInteraction
) : BaseAdapter<Characters>(item, listener) {
    override val layoutId: Int = R.layout.item_comics_raw
}

interface ICharacterInteraction : BaseInteractionListener