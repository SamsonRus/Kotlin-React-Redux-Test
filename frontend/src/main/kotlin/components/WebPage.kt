package components

import containers.*
import containers.DumbComponent.Companion.dumb
import containers.SmartComponent.Companion.smart
import org.w3c.dom.css.StyleSheet
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import redux.connectRedux

class WebPage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div {
            h2 { +"Cars" }
            connectRedux<CarsList, CarsListRProps>(carsListConnector) {}
            dumb()
            smart()
            hr { }
            h3 { +"Details" }
            connectRedux<Details, DetailsRProps>(detailsConnector) {}
        }
    }
}

fun RBuilder.webPage() = child(WebPage::class) {}