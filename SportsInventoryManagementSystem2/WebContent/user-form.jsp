<!DOCTYPE html>
<html>

 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body id="myPage">


<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-white w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="homepage.html" class="w3-bar-item w3-button w3-teal"><i class="fa fa-home w3-margin-right"></i>Home</a>
  <a href="aboutus.html" class="w3-bar-item w3-button w3-hide-small w3-hover-white">About Us</a>
  <a href="founders.html" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Founders</a>
  <a href="user-form.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Demo</a>
  <a class="w3-bar-item w3-hide-small w3-right">Sports Inventory Management Solution</a>
  </div>
 </div>

	<center>
		<div class="w3-container w3-padding-64 w3-center w3-opacity" >
    <h1 class="w3-xxlarge">Sports Inventory Management Solution</h1>
  </div>
        <h2>
        	<a href="new" class="w3-xlarge w3-button w3-hover-black">Add New Product</a>
        	&nbsp;&nbsp;&nbsp;        	
        	<a href="list" class="w3-xlarge w3-button w3-hover-black">Display Inventory</a>
        	&nbsp;&nbsp;&nbsp;        	
        	<a href="search" class="w3-xlarge w3-button w3-hover-black">Search Inventory</a>
        </h2>
	</center>
    <div align="center">
		<c:if test="${user != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            </caption>
        		<c:if test="${user != null}">
        			<input type="hidden" name="productid" value="<c:out value='${user.productid}' />" />
        		</c:if>            
            <tr>
                <th>Product ID </th>
                <td>
                	<input type="text" name="productid" size="45"
                			value="<c:out value='${user.productid}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Product </th>
                <td>
                	<input type="text" name="product" size="45"
                			value="<c:out value='${user.product}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Model </th>
                <td>
                	<input type="text" name="model" size="45"
                			value="<c:out value='${user.model}' />"
                	/>
                </td>
            </tr>
			<tr>
                <th>Manufacturer </th>
                <td>
                	<input type="text" name="manufacturer" size="45"
                			value="<c:out value='${user.manufacturer}' />"
                	/>
                </td>
            </tr>
			<tr>
                <th>TypeCode </th>
                <td>
                	<input type="text" name="typecode" size="15"
                			value="<c:out value='${user.typecode}' />"
                	/>
                </td>
            </tr>
			<tr>
                <th>MSRP </th>
                <td>
                	<input type="text" name="msrp" size="15"
                			value="<c:out value='${user.msrp}' />"
                	/>
                </td>
            </tr>
			<tr>
                <th>Unit Cost </th>
                <td>
                	<input type="text" name="unitcost" size="15"
                			value="<c:out value='${user.unitcost}' />"
                	/>
                </td>
            </tr>
			<tr>
                <th>Discount Rate </th>
                <td>
                	<input type="text" name="discountrate" size="15"
                			value="<c:out value='${user.discountrate}' />"
                	/>
                </td>
            </tr>
			<tr>
                <th>Stock Quantity </th>
                <td>
                	<input type="text" name="stockqty" size="15"
                			value="<c:out value='${user.stockqty}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>        
    </div>	
</body>
</html>
