import components.webPage
import model.Car
import react.dom.render
import redux.*
import store.*
import store.ActionType
import kotlin.browser.document

fun main(args: Array<String>) {
    val reduxStore = Redux.createStore({ reduxState, reduxAction -> MainReducer().reduce(reduxState, reduxAction) }, ReduxStore(),
            composeWithDevTools(Redux.applyMiddleware(ReduxThunk)))

    reduxStore.dispatch(ActionType.SELECT_CAR, SelectCar(Car()))

    render(document.getElementById("root")) {
        provider(reduxStore) {
            webPage()
        }
    }
}