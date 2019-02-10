<!-- Namespace Boiler code -->

<display-name>SimpleMVCWebApplication</display-name>

<filter>
	<filter-name>authentication</filter-name>
	<filter-class>com.youneskasri.AuthenticationFilter</filter-class>
</filter>
<filter-mapping>
	<filter-name>authentication</filter-name>
	<servlet-name>AdminRequestHandler</servlet-name>
</filter-mapping>

filter
	name = log
	class = com.youneskasri.LoggerFilter
filter-mapping
	filter-name = log
	servlet-name = AdminRequestHandler
