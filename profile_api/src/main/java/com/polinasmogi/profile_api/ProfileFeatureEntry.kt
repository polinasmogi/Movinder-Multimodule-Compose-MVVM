package com.polinasmogi.profile_api

import com.polinasmogi.core_api.mediator.FeatureEntry

interface ProfileFeatureEntry: com.polinasmogi.core_api.mediator.FeatureEntry {

    fun profileRoute(): String
}
