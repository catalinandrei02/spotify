package com.cmcode.spotify.main.di

import com.cmcode.spotify.main.core.CommonRepository
import com.cmcode.spotify.main.infra.CommonRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
fun interface CommonModule {

    @Binds
    fun bindCommonRepository(commonRepositoryImpl: CommonRepositoryImpl): CommonRepository

    companion object {

        @Provides
        @Singleton
        fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth

    }
}
