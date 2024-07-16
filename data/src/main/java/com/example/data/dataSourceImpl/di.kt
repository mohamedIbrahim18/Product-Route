package com.example.data.dataSourceImpl

import com.example.data.dataSource.ProductDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class di {

    @Binds
    abstract fun provideDataSource(
        productDataSourceImpl: ProductDataSourceImpl
    ):ProductDataSource
}