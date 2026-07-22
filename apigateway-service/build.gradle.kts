dependencies {
	implementation("org.springframework.cloud:spring-cloud-starter-gateway-server-webflux")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    //logging
    implementation("io.github.oshai:kotlin-logging-jvm:7.0.4")
}
