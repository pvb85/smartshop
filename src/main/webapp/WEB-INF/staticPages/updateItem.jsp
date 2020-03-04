<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<script type="text/javascript">

function validate()

{

	var name=document.item.itemName;

	var price=document.item.itemPrice;

	var quantity=document.item.itemQuanty;

	

	if(name.value=="")

		{

		window.alert("Please enter your name."); 

        name.focus(); 

        return false; 

		}

	if(price.value=="")

	{

	window.alert("Please enter your price."); 

    name.focus(); 

    return false; 

	}

	if(quantity.value=="")

	{

	window.alert("Please enter your quantity."); 

    name.focus(); 

    return false; 

	}

}





</script>

</head>

<body>



<form  action="/update"  name="item" method="post" commandName="item">



<table>

<td>Item Id:</td><td><input type="" name="itemId" value="${item.itemId }" readonly/></td>

<td>Item Name:</td><td><input type ="text" name="itemName" value="${item.itemName }"  /></td></br>

<td>Item Price:</td><td><input type ="text" name="price" value="${item.price }"  /></td></br>

<td>Item Quantity:</td><td><input type ="text" name="quantity" value="${item.quantity }" /></td></br>

<td><input type="submit" name="" value="updateItem"/></td>



</table>



</form>

</body>

</html>