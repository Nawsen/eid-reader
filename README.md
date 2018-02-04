# eID-reader

Belgian eID reader printing out the ID info in json format.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites

- Java 6 +
- Maven 3.3.3

### Building

The project can be build with:

```
mvn clean install
```

After building the project will generate a jar called "wvd-eid-reader.jar". This jar file contains all needed dependencies.

### Usage

Navigate to the jar file mentioned above and run this command

```
java -cp wvd-eid-reader.jar be.wannesvandorpe.eid.BeIDCardReader
```

## License

The source code of the Commons eID Project is licensed under GNU LGPL v3.0.
