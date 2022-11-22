# Alternate packlister backend with Micronaut

This repository was made for investigating lightweight Micronaut runtimes for Java/JVM apps by attempting to implement
at least some functionality of [packlister backend](https://github.com/mtuomiko/packlister-backend) with Micronaut
framework. Repository was initialized using [Micronaut Launch](https://micronaut.io/launch).

The rough idea, as I understand it, with both [Micronaut](https://micronaut.io/) and [Quarkus](https://quarkus.io/) (a
similar option) is to move a lot of the runtime operations like reflection, proxies and possible code generation to
compile time with Ahead of Time (AOT) Compilation. The technical details elude me for the moment (🙂) but the general
idea seems interesting. All-in-all, the resulting app should have a smaller memory footprint and faster cold-start times
than contemporary Java solutions (Spring Boot). Caveats will probably reveal themselves as development progresses on
this repo. Lack of examples and support is obvious, at least compared to Spring Boot, due to the fairly conservative
adoption of the framework.

---

Following docs are from initial project generation

## Micronaut 3.7.3 Documentation

- [User Guide](https://docs.micronaut.io/3.7.3/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.7.3/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.7.3/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)

---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)

## Feature test-resources documentation

- [Micronaut Test Resources documentation](https://micronaut-projects.github.io/micronaut-test-resources/latest/guide/)

## Feature security-jwt documentation

- [Micronaut Security JWT documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html)

## Feature mockito documentation

- [https://site.mockito.org](https://site.mockito.org)

## Feature flyway documentation

- [Micronaut Flyway Database Migration documentation](https://micronaut-projects.github.io/micronaut-flyway/latest/guide/index.html)

- [https://flywaydb.org/](https://flywaydb.org/)

## Feature hibernate-validator documentation

- [Micronaut Hibernate Validator documentation](https://micronaut-projects.github.io/micronaut-hibernate-validator/latest/guide/index.html)

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Feature jdbc-hikari documentation

- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)

## Feature assertj documentation

- [https://assertj.github.io/doc/](https://assertj.github.io/doc/)

## Feature openapi documentation

- [Micronaut OpenAPI Support documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://www.openapis.org](https://www.openapis.org)

## Feature management documentation

- [Micronaut Management documentation](https://docs.micronaut.io/latest/guide/index.html#management)


