package redux

/**
 * Store reducers.
 */
abstract class Reducer<T : Redux.ReduxState> {

    /** Store reducers. */
    private val reducers = HashMap<String, (reduxAction: dynamic, reduxState: T) -> Redux.ReduxState>()

    init {
        addInitReducer()
        this.addReducers()
    }

    /**
     * Add init reducer.
     */
    private fun addInitReducer() {
        reducers["@@INIT"] = { _: dynamic, reduxState: T -> reduxState }
    }

    /**
     * Reduce state and action.
     *
     * @param state redux state.
     * @param action redux action.
     *
     * @return new redux state.
     */
    fun reduce(state: T, action: dynamic): Redux.ReduxState =
            if ((action.type as String).startsWith("@@redux/INIT") ) {
                state
            } else {
                reducers[action.type as String]!!.invoke(action, state)
            }

    /**
     * Add reducer.
     *
     * @param actionType action type for identify action.
     * @param action action for dispatch.
     */
    fun addReducer(actionType: redux.ReduxActionType, action: (reduxAction: dynamic, reduxState: T) -> Redux.ReduxState) {
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