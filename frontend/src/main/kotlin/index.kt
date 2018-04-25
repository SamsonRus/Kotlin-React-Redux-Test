import components.WebPage
import components.webPage
import model.Car
import kotlin.browser.document
import react.dom.div
import react.dom.render
import redux.*
import store.ActionType
import store.ReduxStore
import store.SelectCar
import store.mainReducer

fun main(args: Array<String>) {
    val reduxStore = Redux.createStore(::mainReducer, ReduxStore(),
            composeWithDevTools(Redux.applyMiddleware(ReduxThunk)))

    reduxStore.dispatch(ReduxAction(ActionType.SELECT_CAR, SelectCar(Car())))

    render(document.getElementById("root")) {

            child(ProviderComponent::class) {
                attrs.store = reduxStore
                attrs.children = webPage()
            }

    }
}