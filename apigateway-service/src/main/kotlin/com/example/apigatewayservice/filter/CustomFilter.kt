package com.example.apigatewayservice.filter

import com.example.apigatewayservice.util.log
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.core.Ordered
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class CustomFilter : AbstractGatewayFilterFactory<Any>() {

    override fun apply(config: Any): GatewayFilter {
        return OrderedGatewayFilter({ exchange, chain ->
            val request = exchange.request
            val response = exchange.response

            // Custom Pre Filter
            log.info { "Custom PRE Filter: request id -> ${request.id}" }

            chain.filter(exchange)
                .then(
                    Mono.fromRunnable {
                        // Custom Post Filter
                        log.info { "Custom POST Filter: response code -> ${response.statusCode}" }
                    }
                )
        }, Ordered.HIGHEST_PRECEDENCE)
    }

}