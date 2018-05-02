package redux

import kotlinext.js.js
import store.ActionType

interface ActionPayload
class EmptyPayload : ActionPayload
class ReduxAction(
        private val type: ActionType, private val payload: ActionPayload = EmptyPayload()) {
    operator fun invoke(): dynamic {
        return js {
            this.type = type.name
            this.payload = payload
        }
    }
}