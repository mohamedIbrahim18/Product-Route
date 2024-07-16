package com.example.data.reposritoryImpl

import com.example.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class di {

    @Binds
    abstract fun provideProductRepository
                (productRepositoryImpl: ProductRepositoryImpl):
            ProductRepository

}