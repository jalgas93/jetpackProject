package com.octobank.jetpack_3_1.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.octobank.jetpack_3_1.domain.manager.LocalUserManager
import com.octobank.jetpack_3_1.util.Constants
import kotlinx.coroutines.flow.Flow
import com.octobank.jetpack_3_1.util.Constants.USER_SETTING
import com.octobank.jetpack_3_1.util.Constants.APP_ENTRY
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(
    private val context: Context,
) : LocalUserManager {
    override suspend fun saveAppEnter() {
       context.dataStore.edit { setting ->
           setting[PreferencesKeys.APP_ENTRY] = true
       }
    }

    override fun readAppEntry(): Flow<Boolean> {
      return  context.dataStore.data.map { preferences ->
          preferences[PreferencesKeys.APP_ENTRY]?: false
      }
    }

}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTING)

private object PreferencesKeys {
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}