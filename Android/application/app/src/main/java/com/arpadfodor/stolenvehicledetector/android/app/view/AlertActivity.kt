package com.arpadfodor.stolenvehicledetector.android.app.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.arpadfodor.stolenvehicledetector.android.app.R
import com.arpadfodor.stolenvehicledetector.android.app.view.utils.MasterDetailActivity
import com.arpadfodor.stolenvehicledetector.android.app.viewmodel.AlertViewModel

class AlertActivity : MasterDetailActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlertViewModel::class.java)

        listName = getString(R.string.alert_list)
        detailName = getString(R.string.alert_details)

        sendSucceed = getString(R.string.alert_sent)
        sendFailed = getString(R.string.alert_sending_failed)
        deleted = getString(R.string.alert_deleted)
        alreadySent = getString(R.string.alert_already_sent)
        updateSucceed = getString(R.string.updated)
        updateFailed = getString(R.string.update_failed)

    }

}
