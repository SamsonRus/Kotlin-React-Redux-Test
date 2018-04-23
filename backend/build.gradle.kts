//group 'EducationCards'
//version '0.0.1-SNAPSHOT'

buildscript {
    val springBootVersion: String = properties["springBootVersion"] as String
    val kotlin_version: String = parent!!.properties["kotlin_version"] as String

    repositories {
        mavenCentral()
    }
    dependencies {
        //classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        //classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlin_version}")
        //classpath("org.jetbrains.kotlin:kotlin-allopen:${kotlin_version}")
        //classpath("io.spring.gradle:dependency-management-plugin:0.4.0.RELEASE")
    }
}

apply {
    plugin('kotlin')
    //plugin('kotlin-spring')
    //plugin('eclipse')
    //plugin('org.springframework.boot')
    //plugin('kotlin-platform-jvm')
}


//sourceCompatibility = 1.8
//compileKotlin {
//    kotlinOptions.jvmTarget = "1.8"
//}
//compileTestKotlin {
//    kotlinOptions.jvmTarget = "1.8"
//}
//
//jar {
//    baseName = 'kotlin-react-redux-test'
//    version = '0.0.1-SNAPSHOT'
//}

repositories {
    mavenCentral()
    jcenter()
}

val kotlin_version: String = parent!!.properties["kotlin_version"] as String
dependencies {
    //"compile"('org.springframework.boot:spring-boot-starter-data-jpa')
    //"compile"('org.springframework.boot:spring-boot-starter-web')
    //"compile"('org.springframework.boot:spring-boot-starter-jersey')
    //"compile"("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlin_version}")
    //"compile"("org.jetbrains.kotlin:kotlin-reflect:${kotlin_version}")
    //"runtime"('mysql:mysql-connector-java')
    //"runtime"('org.springframework.boot:spring-boot-devtools')

    expectedBy project(":common")

}
