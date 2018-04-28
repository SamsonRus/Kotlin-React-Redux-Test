import components.webPage
import model.Car
import react.dom.render
import redux.*
import store.ActionType
import store.ReduxStore
import store.SelectCar
import store.mainReducer
import kotlin.browser.document

fun main(args: Array<String>) {
    val reduxStore = Redux.createStore(::mainReducer, ReduxStore(),
            composeWithDevTools(Redux.applyMiddleware(ReduxThunk)))

    reduxStore.dispatch(ReduxAction(ActionType.SELECT_CAR, SelectCar(Car())))

    render(document.getElementById("root")) {
        provider(reduxStore) {
            webPage()
        }
    }
}