package com.polinasmogi.partner_api

import com.polinasmogi.core_api.mediator.FeatureEntry

interface PartnerFeatureEntry: FeatureEntry {

    fun partnerRoute(): String
}