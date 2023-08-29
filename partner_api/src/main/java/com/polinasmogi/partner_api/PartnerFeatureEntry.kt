package com.polinasmogi.partner_api

import com.polinasmogi.core_api.mediator.FeatureEntry

interface PartnerFeatureEntry: com.polinasmogi.core_api.mediator.FeatureEntry {

    fun partnerRoute(): String
}