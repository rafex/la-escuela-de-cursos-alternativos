# How to create project with Maven

```Shell
mvn archetype:generate \
  -DgroupId=mx.rafex.tutum.school \
  -DartifactId=alternative-courses \
  -DinteractiveMode=false
```

```Shell
mvn archetype:generate \
  -DgroupId=mx.rafex.tutum.school.parent \
  -DartifactId=alternative-courses-parent \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.4 \
  -DinteractiveMode=false
```

```Shell
mvn archetype:generate \
  -DgroupId=mx.rafex.tutum.school.model \
  -DartifactId=alternative-courses-model \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.4 \
  -DinteractiveMode=false
```

```Shell
mvn archetype:generate \
  -DgroupId=mx.rafex.tutum.school.webapp \
  -DartifactId=alternative-courses-webapp \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.4 \
  -DinteractiveMode=false
```

```Shell
mvn archetype:generate \
  -DgroupId=mx.rafex.tutum.school.rest \
  -DartifactId=alternative-courses-rest \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.4 \
  -DinteractiveMode=false
```

```Shell
mvn archetype:generate \
  -DgroupId=mx.rafex.tutum.school.service \
  -DartifactId=alternative-courses-service \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.4 \
  -DinteractiveMode=false
```

```Shell
mvn archetype:generate \
  -DgroupId=mx.rafex.tutum.school.repository \
  -DartifactId=alternative-courses-repository \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.4 \
  -DinteractiveMode=false
```
