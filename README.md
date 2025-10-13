# StrutsTestCase for JUnit

This is a fork of StrutsTestCase that aims for JUnit 5 support and migrates from `javax.*` to `jakarta.*` packages.

## Branches

This repository has two main branches:

*   **main**: This branch uses the `jakarta.*` namespace and is the primary development branch. The versions for this branch will be `1.x.x`.
*   **javax**: This branch uses the older `javax.*` namespace. The versions for this branch will be `0.x.x`.

If you need to work with the older `javax` dependencies, please use the `javax` branch. For new development and `jakarta` support, use the `main` branch.

## Building and Testing

This project uses Apache Ant for building. The `build.xml` file contains all the necessary targets.

### Building the project

To build the project, run:

```bash
ant build
```

This will compile the Java sources and put them into the `build` directory.

### Running tests

To run the tests, use:

```bash
ant test
```

Test results will be available in the `test-results` directory.

### Creating artifacts

To create the JAR file, you can run:

```bash
ant package
```

The final JAR will be placed in the `dist/strutstest` directory.

To create a release zip file, use:

```bash
ant release
```

## Original README

The original README content is preserved below.

---

StrutsTestCase for JUnit - release 2.1.4
----------------------------------------

This is a point release to add support for Struts 1.3. Tests written
for Struts 1.2 apps that have since been deployed to 1.3 may be tested
under 1.3 with this release.

This release does NOT support configurations that use the
ComposableRequestProcessor new to Struts 1.3 -- only the 1.2
RequestProcessor/TilesRequestProcessor or their subclasses. Full-fledged
support for 1.3-style applications will be offered in a future release.

The StrutsTestCase library is available as three distinct
releases supporting the 2.2, 2.3, and 2.4 versions of the
Servlet specification, and the 1.2 (and 1.3) versions of the Struts
Framework. PLEASE NOTE that StrutsTestCase no longer supports
the Struts 1.0 release.

Deryl Seale and Ben Speakmon
http://strutstestcase.sourceforge.net
