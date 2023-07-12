<img align="right" width="250" height="47" src="Gematik_Logo_Flag_With_Background.png"/> <br/> 

# lib-ihe-xds

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    <li>
      <a href="#getting-started">Getting Started</a>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

## About The Project

IHE profiles for exchange of medical documents are used in more and more projects worldwide. They represent a modern, international basis for the electronic exchange of medical data in the healthcare sector. 
As the profiles are quite complex and the objects are difficult to understand, we provide a library that converts human-readable Document-Request and Responses to IHE conform Objects. Hereby, the mapping contains no validation, it maps exactly what is given.

### Release Notes
The Release-Notes can be found in the file [ReleaseNotes.md](./ReleaseNotes.md)

## Getting Started

### Prerequisites
In case you want to clone the project you need:
* Git
* Java JDK 17 or newer (Tested on OpenJDK)
* Maven 3.8.0 or newer

In case you just want to use the built artefact in your project get it as dependency.

Maven:

    <dependency>
      <groupId>de.gematik.epa</groupId>
      <artifactId>lib-ihe-xds</artifactId>
      <version>x.y.z</version>
    </dependency>  

For gradle it is

    implementation 'de.gematik.epa:lib-ihe-xds:x.y.z'

## Usage

This project is a library and only contains utility methods for the conversion to IHE-Request and from IHE-Responses. 
Currently we support saving, finding, retrieving, replacing and removing of documents.

The class [de.gematik.epa.LibIheXdsMain](src/main/java/de/gematik/epa/LibIheXdsMain.java) is the main class,
which contains static methods for the supported conversions.

To delve in deeper, in 
- [AdhocQueryUtils.java](src/main/java/de/gematik/epa/conversion/AdhocQueryUtils.java)
- [DeleteObjectsUtils.java](src/main/java/de/gematik/epa/conversion/DeleteObjectUtils.java)
- [ProvideAndRegisterUtils.java](src/main/java/de/gematik/epa/conversion/ProvideAndRegisterUtils.java)
- [RetrieveDocumentUtils.java](src/main/java/de/gematik/epa/conversion/RetrieveDocumentUtils.java)

you can find the methods for converting a given DocumentObject to corresponding IHE/XDS objects.

In [ResponseUtils.java](src/main/java/de/gematik/epa/conversion/ResponseUtils.java) you can find the conversion from IHE-Responses to DocumentObjects.

## Contributing
If you want to contribute, please check our [CONTRIBUTING.md](./CONTRIBUTING.md).

## License
See [LICENSE](./LICENSE)

## Contact
gematik GmbH: [OSPO@gematik.de](mailto:OSPO@gematik.de)