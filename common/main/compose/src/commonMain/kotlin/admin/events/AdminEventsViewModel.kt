package admin.events

import admin.events.models.AdminEventsAction
import admin.events.models.AdminEventsEvent
import admin.events.models.AdminEventsState
import com.adeo.kviewmodel.BaseSharedViewModel

class AdminEventsViewModel :
    BaseSharedViewModel<AdminEventsState, AdminEventsAction, AdminEventsEvent>(initialState = AdminEventsState()) {

    override fun obtainEvent(viewEvent: AdminEventsEvent) {

    }
}
