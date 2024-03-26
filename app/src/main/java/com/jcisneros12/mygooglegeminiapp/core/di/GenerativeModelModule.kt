package com.jcisneros12.mygooglegeminiapp.core.di

import com.google.ai.client.generativeai.GenerativeModel
import com.google.gson.Gson
import com.jcisneros12.mygooglegeminiapp.BuildConfig
import com.jcisneros12.mygooglegeminiapp.core.data.ia.GenerativeModelDataSourceImpl
import com.jcisneros12.mygooglegeminiapp.core.data.ia.IGenerativeModelDataSource
import com.jcisneros12.mygooglegeminiapp.core.repository.GenerativeModelRepositoryImpl
import com.jcisneros12.mygooglegeminiapp.core.repository.IGenerativeModelRepository
import com.jcisneros12.mygooglegeminiapp.core.usecase.GenerateKidStoryUseCase
import com.jcisneros12.mygooglegeminiapp.core.usecase.IGenerateKidStoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 * @author Juan Cisneros on 03/03/2024
 */

@Module
@InstallIn(SingletonComponent::class)
object GenerativeModelModule {

    /**
     * Provides data sources
     */
    @Provides
    fun providesGenerativeModelDataSource(generativeModel: GenerativeModel, gson: Gson): IGenerativeModelDataSource =
        GenerativeModelDataSourceImpl(generativeModel, gson)

    /**
     * Provides repositories
     */
    @Provides
    fun providesGenerativeModelRepository(generativeModel: IGenerativeModelDataSource): IGenerativeModelRepository =
        GenerativeModelRepositoryImpl(generativeModel)

    /**
     * Provides use cases
     */
    @Provides
    fun providesGenerateKidStoryUseCase(generativeModelRepo: IGenerativeModelRepository, gson: Gson):
            IGenerateKidStoryUseCase = GenerateKidStoryUseCase(generativeModelRepo, gson)

    /**
     *  Provides Generative Models
     */
    @Provides
    fun providesGenerativeModelModelPro(): GenerativeModel {
        return GenerativeModel(
            modelName = "gemini-pro",
            apiKey = BuildConfig.apiKey
        )
    }

    /**
     * Provides other utils dependencies
     */
    @Provides
    fun providesGson(): Gson = Gson()

}