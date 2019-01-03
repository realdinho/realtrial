<#import "/spring.ftl" as spring>

<!DOCTYPE html>
<html>

<body>	
	<h2>List of Parents</h2>
	<ul>
	   	<#list parents as parent>
	     	<li>${parent}</li>
	    </#list>
	</ul>
	<p> <a href="/logout">Logout</a> </p>
</body>

</html>