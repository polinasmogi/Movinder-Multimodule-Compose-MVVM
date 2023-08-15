package com.polinasmogi.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.polinasmogi.core_api.mediator.AppWithFacade
import com.polinasmogi.explore_api.ExploreFeatureEntry
import com.polinasmogi.main.di.MainComponent
import com.polinasmogi.partner_api.PartnerFeatureEntry
import com.polinasmogi.profile_api.ProfileFeatureEntry
import com.polinasmogi.ui_atoms.theme.MovinderTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject lateinit var exploreEntry: ExploreFeatureEntry
    @Inject lateinit var partnerEntry: PartnerFeatureEntry
    @Inject lateinit var profileEntry: ProfileFeatureEntry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainComponent.create((application as AppWithFacade).getFacade()).inject(this)
        setContent {
            MovinderTheme() {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainScreen(exploreEntry, partnerEntry, profileEntry)
                }
            }
        }
    }
}
