package com.mivanovskaya.ricknmortycompose.di

import com.mivanovskaya.ricknmortycompose.data.MainRepositoryImpl
import com.mivanovskaya.ricknmortycompose.data.RicknMortyService
import com.mivanovskaya.ricknmortycompose.domain.MainRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**excessive for Hilt, needed in Dagger-only app*/
//@Component(modules = [AppModule::class])
//interface AppComponent {
//    fun inject(activity: MainActivity)
//}

//TODO: свериться с другими моими hilt apps, это кажется лишним

@Module(includes = [NetworkModule::class, AppBindModule::class])
@InstallIn(SingletonComponent::class)
class AppModule

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideRicknMortyService(): RicknMortyService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }
}

@Module
@InstallIn(SingletonComponent::class)
interface AppBindModule {

    @Suppress("FunctionName")
    @Binds
    fun bindMainRepositoryImpl_to_MainRepository(
        mainRepositoryImpl: MainRepositoryImpl
    ): MainRepository
}

const val BASE_URL = "https://rickandmortyapi.com"