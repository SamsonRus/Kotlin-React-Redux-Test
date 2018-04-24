import components.webPage
import kotlin.browser.document
import react.dom.div
import react.dom.render
import redux.Redux
import redux.ReduxThunk
import redux.composeWithDevTools
import store.ReduxStore
import store.mainReducer

fun main(args: Array<String>) {
    val reduxStore = Redux.createStore(::mainReducer, ReduxStore(),
            composeWithDevTools(Redux.applyMiddleware(ReduxThunk)))

    render(document.getElementById("root")) {
        div {
            webPage()
        }
    }
}