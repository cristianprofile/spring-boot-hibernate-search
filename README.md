# spring-boot-hibernate-search
Spring Boot with hibernate search (lucene capabilities)


Whenever we have to implement full-text search functionality, using tools we’re already well-versed with is always a plus.

In case we’re already using Hibernate and JPA for ORM, we’re only one step away from Hibernate Search.

Hibernate Search integrates Apache Lucene, a high-performance and extensible full-text search-engine library written in Java. This combines the power of Lucene with the simplicity of Hibernate and JPA.

Simply put, we just have to add some additional annotations to our domain classes, and the tool will take care of the things like database/index synchronization.

Hibernate Search also provides an Elasticsearch integration; however, as it’s still in an experimental stage, we’ll focus on Lucene here.

100000 million of Thanks to: http://www.baeldung.com/hibernate-search 