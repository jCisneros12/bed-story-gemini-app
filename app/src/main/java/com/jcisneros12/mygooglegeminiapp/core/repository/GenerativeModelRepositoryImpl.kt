package com.jcisneros12.mygooglegeminiapp.core.repository

import com.jcisneros12.mygooglegeminiapp.core.data.ia.IGenerativeModelDataSource
import com.jcisneros12.mygooglegeminiapp.core.models.KidStoryGeneratedModel
import com.jcisneros12.mygooglegeminiapp.utils.RequestState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @author Juan Cisneros on 03/03/2024
 */
class GenerativeModelRepositoryImpl @Inject constructor(
    private val generativeModel: IGenerativeModelDataSource
): IGenerativeModelRepository {
    override fun generateKidStory(prompt: String): Flow<RequestState<KidStoryGeneratedModel>>  =
        generativeModel.generateKidStory(prompt)
}