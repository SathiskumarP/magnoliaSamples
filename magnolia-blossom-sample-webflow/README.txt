Instructions to install and use

* add it the pom.xml of your project

    <dependency>
      <groupId>info.magnolia</groupId>
      <artifactId>magnolia-blossom-sample-webflow</artifactId>
      <version>1.0.0-SNAPSHOT</version>
    </dependency>

* add this to your applicationContext.xml or equivalent

      <import resource="classpath:/info/magnolia/blossom/sample/webflow/webflow-config.xml" />

* add this to your blossom-servlet.xml or equivalent

	<context:component-scan base-package="info.magnolia.blossom.sample" use-default-filters="false">
		<context:include-filter type="annotation" expression="info.magnolia.module.blossom.annotation.Paragraph"/>
	</context:component-scan>

* add 'booking-flow' to a new bar in one of your templates