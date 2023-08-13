package com.polinasmogi.profile_api

import com.polinasmogi.core_api.mediator.FeatureEntry

interface ProfileFeatureEntry: FeatureEntry {

    fun profileRoute(): String
}
