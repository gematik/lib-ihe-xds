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

IHE profiles for exchange of medical documents are used in more and more projects worldwide. They represent a modern, international basis for the electronic
exchange of medical data in the healthcare sector.
As the profiles are quite complex and the objects are difficult to understand, we provide a library that converts human-readable Document-Request and Responses
to IHE conform Objects. Hereby, the mapping contains no validation, it maps exactly what is given.

It supports the following IHE operations:

- Provide and Register Document Set-b [ITI-41]
- Registry Stored Query [ITI-18] with the following query names:
    - FindDocuments
    - FindDocumentsByTitle
    - FindDocumentsByComment
    - FindDocumentsByReferenceId
    - FindFolders
    - GetAll
    - GetFolderAndContents
- Retrieve Document Set [ITI-43]
- Remove Metadata [ITI-62]
- Restricted Update Document Set (ITI-92)

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

Copyright 2023 gematik GmbH

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.

See the [LICENSE](./LICENSE) for the specific language governing permissions and limitations under the License.

## Additional Notes and Disclaimer from gematik GmbH

1. Copyright notice: Each published work result is accompanied by an explicit statement of the license conditions for use. These are regularly typical
   conditions in connection with open source or free software. Programs described/provided/linked here are free software, unless otherwise stated.
2. Permission notice: Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "
   Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute,
   sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions::
1. The copyright notice (Item 1) and the permission notice (Item 2) shall be included in all copies or substantial portions of the Software.
2. The software is provided "as is" without warranty of any kind, either express or implied, including, but not limited to, the warranties of fitness for a
   particular purpose, merchantability, and/or non-infringement. The authors or copyright holders shall not be liable in any manner whatsoever for any damages
   or other claims arising from, out of or in connection with the software or the use or other dealings with the software, whether in an action of contract,
   tort, or otherwise.
3. The software is the result of research and development activities, therefore not necessarily quality assured and without the character of a liable product.
   For this reason, gematik does not provide any support or other user assistance (unless otherwise stated in individual cases and without justification of a
   legal obligation). Furthermore, there is no claim to further development and adaptation of the results to a more current state of the art.
3. Gematik may remove published results temporarily or permanently from the place of publication at any time without prior notice or justification.
4. Please note: Parts of this code may have been generated using AI-supported technology.’ Please take this into account, especially when troubleshooting, for
   security analyses and possible adjustments.

## Kontakt

gematik GmbH: [OSPO@gematik.de](mailto:OSPO@gematik.de)

