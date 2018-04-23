allprojects {
    group = "Kotlin-react-redux-test"
    version = "1.0"

    repositories {
        mavenLocal()
        jcenter()
    }
}

plugins {
    base
}

dependencies {
    subprojects.forEach {
        archives(it)
    }
}