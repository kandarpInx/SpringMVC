<html>
<body>

<form action="saveItems" method="post">

	<#if items??>
							<input type="hidden" name="itemId" value="${items.itemId}">
							Item Name :: <input type="text" name="itemName" value="${items.itemName}"><br><br>
							Price :: <input type="text" name="itemPrice" value="${items.itemPrice}"> <br><br>
							
	<#else>
							Item Name :: <input type="text" name="itemName"><br><br>
							Price :: <input type="text" name="itemPrice"> <br><br>
	</#if>
	
	
<button type="submit"> Submit </button>
</form>
</body>
</html>
