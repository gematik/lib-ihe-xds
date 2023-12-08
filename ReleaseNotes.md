<img align="right" width="200" height="37" src="Gematik_Logo_Flag_With_Background.png" alt="Gematik Logo"/> <br/>

# Release notes lib-ihe-xds

## Release 1.0.5

### fixed
- Updated releaseChain.jenkinsfile - use variable TAGNAME for publishing

## Release 1.0.4

### fixed
- Migration to deploy Snapshot-Only Artifacts
- Added missing DIGA oid to the author attribute

## Release 1.0.3

### added
- DIGA format code

## Release 1.0.2

### fixed
- Added missing url element in POM file

## Release 1.0.1

### fixed
- Copyright header was missing in several places

## Release 1.0.0

### added
- Conversion operations covering:
  - DocumentSubmissionRequest -> urn:ihe:iti:xds-b:2007:ProvideAndRegisterDocumentSetRequestType
  - DocumentReplaceRequest -> urn:ihe:iti:xds-b:2007:ProvideAndRegisterDocumentSetRequestType
  - FindRequest -> urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0:AdhocQueryRequest
    - Covered are the query types:
      * FindDocuments (urn:uuid:14d4debf-8f97-4251-9a74-a90016b0af0d)
      * FindDocumentsByTitle (urn:uuid:ab474085-82b5-402d-8115-3f37cb1e2405)
      * FindFolders (urn:uuid:958f3006-baad-4929-a4de-ff1114824431)
      * GetAll (urn:uuid:10b545ea-725c-446d-9b95-8aeb444eddf3)
      * GetFolderAndContents (urn:uuid:b909a503-523d-4517-8acf-8e5834dfc4c7)
      * GetRelatedApprovedDocuments (urn:uuid:1c1f1cea-ad3a-11ed-afa1-0242ac120002)
  - RetrieveDocumentsRequest -> urn:ihe:iti:xds-b:2007:RetrieveDocumentSetRequestType
  - DeleteObjectsRequest -> urn:oasis:names:tc:ebxml-regrep:xsd:lcm:3.0:RemoveObjectsRequest
  - urn:oasis:names:tc:ebxml-regrep:xsd:rs:3.0:RegistryResponseType -> ProxyResponse
  - urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0:AdhocQueryResponse -> ProxyFindResponse
  - urn:ihe:iti:xds-b:2007:RetrieveDocumentSetResponseType -> RetrieveDocumentsResponse

