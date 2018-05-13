package redux

import kotlinext.js.js

interface ActionPayload

interface ActionType {
    fun value() : String
}

class EmptyPayload : ActionPayload
class ReduxAction(
        private val type: ActionType, private val payload: ActionPayload = EmptyPayload()) {
    operator fun invoke(): dynamic {
        return js {
            this.type = type.value()
            this.payload = payload
        }
    }
}