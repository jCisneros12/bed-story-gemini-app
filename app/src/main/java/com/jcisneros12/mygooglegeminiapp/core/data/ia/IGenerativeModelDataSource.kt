package com.jcisneros12.mygooglegeminiapp.core.data.ia

import com.jcisneros12.mygooglegeminiapp.core.models.KidStoryGeneratedModel
import com.jcisneros12.mygooglegeminiapp.utils.RequestState
import kotlinx.coroutines.flow.Flow


/**
 * @author Juan Cisneros on 03/03/2024
 */
interface IGenerativeModelDataSource {
    fun generateKidStory(prompt: String): Flow<RequestState<KidStoryGeneratedModel>>
}