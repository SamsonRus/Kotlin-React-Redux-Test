package redux

import store.ReduxStore

/**
 * Store reducers.
 */
abstract class Reducer {

    init {
        this.addReducers()
    }

    companion object {

        /** Store reducers. */
        private val reducers = HashMap<String, (reduxAction: dynamic, reduxState: ReduxStore) -> Redux.ReduxState>()
    }


    /**
     * Reduce state and action.
     *
     * @param state redux state.
     * @param action redux action.
     *
     * @return new redux state.
     */
    fun reduce(state: ReduxStore, action: dynamic): Redux.ReduxState =
            if (action.type == "@@INIT") {
                state
            } else {
                reducers[action.type]!!.invoke(action, state)
            }

    /**
     * Add reducer.
     *
     * @param actionType action type for identify action.
     * @param action action for dispatch.
     */
    fun addReducer(actionType: redux.ReduxActionType, action: (reduxAction: dynamic, reduxState: ReduxStore) -> Redux.ReduxState) {
        if (reducers.containsKey(actionType.value())) {
            console.error("Action type already exist!")
        } else {
            reducers[actionType.value()] = action
        }
    }

    /**
     * Add reducers. For adding use [addReducer].
     */
    abstract fun addReducers()
}