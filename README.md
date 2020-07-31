# Simple lab to create a Vert.x reactive order microservice

In this lab you will learn how to create a quarkus project with Reactive route, reactive messaging, and kafka backend. 

```shell
git clone https://github.com/jbcodeforce/reactive-order-ms.git
cd reactive-order-ms
./mvnw compile quarkus:dev
```

## Source of information

* [GETTING STARTED WITH REACTIVE](https://quarkus.io/guides/getting-started-reactive)
* [QUARKUS - USING ECLIPSE VERT.X](https://quarkus.io/guides/vertx)

## Build it yourself

From a terminal windows, create the basic Quarkus project and add the needed extensions: Vert.x web for reactive route, json-b for java to json.

```Shell
mkdir reactive-order-ms
appsody init ibmcase/ibm-gse-eda-quarkus

# Adding reactive route
./mvnw quarkus:add-extension -Dextensions="quarkus-vertx-web"
./mvnw quarkus:add-extension -Dextensions="resteasy-jsonb"
# 
```

Quarkus HTTP support is based on a non-blocking and reactive engine (Eclipse Vert.x and Netty). All the HTTP requests your application receives, are handled by event loops (IO Thread) and then are routed towards the code that manages the request.

* To asynchronously handle the HTTP request, the endpoint method must return a java.util.concurrent.CompletionStage or an io.smallrye.mutiny.Uni (requires the quarkus-resteasy-mutiny extension). See the AsynchGreetingResource.java.

With Mutiny both Uni and Multi expose event-driven APIs: you express what you want to do upon a given event (success, failure, etc.). These APIs are divided into groups (types of operations) to make it more expressive and avoid having 100s of methods attached to a single class.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

The application can be packaged using `./mvnw package`.
It produces the `reactive-order-ms-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/reactive-order-ms-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/reactive-order-ms-1.0-SNAPSHOT-runner`
