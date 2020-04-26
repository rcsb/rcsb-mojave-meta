# RCSB-MOJAVE-META

The repository contains Java types and constants for the JSON schema meta-schema itself. The [JSON Schema 
core specification](http://json-schema.org/latest/json-schema-core.html) defines terminology 
and describes validation keywords used to write JSON Schema instances. We also define custom vocabulary 
that extend core keywords by adding new properties to the JSON Schema draft. Custom properties are appended 
under `rcsb_` namespace to indicate provenance.
 
The draft and extensions are stored in [rcsb-json-schema](https://github.com/rcsb/rcsb-json-schema) repository.

## Tying Meta-Schemas to Types
Code is generated in the `generate-sources` phase during the project build. Generation works by calling the following 
classes from the _pom.xml_:
- `org.rcsb.mojave.tools.core.GenerateSchemaConstants` - generates Java constants that correspond directly 
to definitions in the JSON schema meta-schema.
- `org.rcsb.mojave.tools.core.GenerateSchemaEnums`- generates Java enums that correspond to keywords described 
as enums in the JSON schema meta-schema.

## Using Generated Types

Using generated constants and enums allows working with JSON schemas and RCSB extensions type-safely, specifically 
writing type-aware parsers that will read and understand schema semantics. Type-safety means when your schema changes, 
the generated code will change as well. Removing or renaming the definitions will lead to compilation errors, which can 
be detected early.

To use generated types in your Java project you need to import `org.rcsb.mojave.meta.MetaSchemaConstants` and 
`org.rcsb.mojave.meta.enums.*`.

## Versioning
 Version numbers should follow [Semantic Versioning Specification](https://semver.org/#semantic-versioning-specification-semver) 
(SemVer). Release version takes the **x.y.z** form, where **x** is the major version, **y** is the minor version, 
and **z** is the patch version (e.g. 0.1.0).
