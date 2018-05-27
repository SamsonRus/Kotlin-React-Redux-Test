package redux

import kotlinext.js.js

interface ActionPayload

interface ReduxActionType {

    fun value() : String
}

class EmptyPayload : ActionPayload

class ReduxAction(
        private val type: ReduxActionType, private val payload: ActionPayload = EmptyPayload()) {

    operator fun invoke(): dynamic {
        return js {
            this.type = type.value()
            this.payload = payload
        }
    }
}