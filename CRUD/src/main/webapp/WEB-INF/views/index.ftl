<html>
<head>
<title>CRUD Example</title>
</head>
<body>
<br/>
<br/>

	<table border="2" align="center">
	
		<tr>
			<th>Item Id</th>
			<th>Item Name</th>
			<th>Price</th>
		</tr>
		
		<#list items as items>

			<tr>
				<td>${items.itemId}</td>
				<td>${items.itemName}</td>
				<td>${items.itemPrice}</td>
				<td>
					<a href="updateForm?itemId=${items.itemId}">Update</a>
				</td>
				<td>
					<a href="CRUD/views/delete/${items.itemId}"
					onclick="if (!(confirm('Are you sure you want to delete this item?'))) return false">Delete</a>
				</td>
			</tr>
			</#list>
	</table>
	<br/>

	<a href="showForm"> Add Items </a>
	<#--<input type="button" value="Add Item"
		onclick="window.location.href='showForm'; return false;" />  -->

</body>
</html>