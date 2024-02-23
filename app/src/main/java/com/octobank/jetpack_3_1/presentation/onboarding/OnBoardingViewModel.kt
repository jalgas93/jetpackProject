package com.octobank.jetpack_3_1.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.octobank.jetpack_3_1.domain.usecases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor (
    private  val appEntryUseCases: AppEntryUseCases
        ):ViewModel() {

            fun  onEvent(event: OnBoardingEvent){
                when(event){
                    is OnBoardingEvent.SaveAppEntry -> {
                        saveAppEntry()
                    }
                }
            }

    private  fun saveAppEntry(){

        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }

    }

}