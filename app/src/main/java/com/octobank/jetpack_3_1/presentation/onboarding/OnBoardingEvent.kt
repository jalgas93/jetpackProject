package com.octobank.jetpack_3_1.presentation.onboarding


sealed class OnBoardingEvent {
    object SaveAppEntry : OnBoardingEvent()
}