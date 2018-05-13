package redux

import store.ReduxStore

abstract class Reducer {

    init {
        this.addReducers()
    }

    companion object {
        private val reducers = HashMap<String, (reduxAction: dynamic, reduxState: ReduxStore) -> Redux.ReduxState>()
    }


    fun mainReducer(reduxState: ReduxStore, reduxAction: dynamic): Redux.ReduxState =
            if (reduxAction.type == "@@INIT") {
                reduxState
            } else {
                reducers[reduxAction.type]!!.invoke(reduxAction, reduxState)
            }

    fun addReducer(actionType: redux.ActionType, action: (reduxAction: dynamic, reduxState: ReduxStore) -> Redux.ReduxState) {
        reducers.put(actionType.value(), action)
    }

    abstract fun addReducers()
}