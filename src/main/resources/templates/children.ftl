<#import "/spring.ftl" as spring>

<!DOCTYPE html>
<html>

<body>
	<h2>List of children</h2>
	<ul>
	   	<#list children as child>
	     	<li>${child}</li>
	    </#list>
	</ul>

	<p> <a href="/logout">Logout</a> </p>
</body>

</html>